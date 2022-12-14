package tdtu.edu.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tdtu.edu.demo.entity.Role;
import tdtu.edu.demo.entity.User;
import tdtu.edu.demo.exception.UserNotFoundException;
import tdtu.edu.demo.repository.RoleRepository;
import tdtu.edu.demo.repository.UserRepository;

@Service
@Transactional
public class UserService {
	public static final int MAX_FAILED_ATTEMPTS = 3;
	
	private static final long LOCK_DURATION = 3*60*1000; // 1 hours
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public void saveUserWithDefaultRole(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		Role role = roleRepository.findByName("USER");
		user.addRole(role);
		
		userRepository.save(user);
	}
	
	public List<User> listAll(){
		return (List<User>) userRepository.findAll();
	}
	
	public User get(Integer id) {
		return userRepository.findById(id).get();
	}
	
	public List<Role> getRoles(){
		return roleRepository.findAll();
	}
	
	public void save(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		userRepository.save(user);
	}
	
	public void updateResetTokenPassword(String token_reset_password, String email) throws UserNotFoundException{
		User user = userRepository.findByEmail(email);
		if(user != null) {
			user.setTokenresetpassword(token_reset_password);
			userRepository.save(user);
		} else {
			throw new UserNotFoundException("Couldn't find user with email: "+email);
		}
	}
	
	public User getResetTokenPassword(String token_reset_password) {
		return userRepository.findByTokenresetpassword(token_reset_password);
	}
	
	public void updatePassword(User user, String newPassword) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String encodePassword = bCryptPasswordEncoder.encode(newPassword);
		
		user.setPassword(encodePassword);
		user.setTokenresetpassword(null);
		
		userRepository.save(user);
	}
	
	public User getUserByUsername(String username) {
		return userRepository.getUserByUsername(username);
	}

	public void increaseFailedAttempt(User user) {
		// TODO Auto-generated method stub
		int newFailedAttempt = user.getFailedAttempt() + 1;
		userRepository.updateFailedAttempt(newFailedAttempt, user.getUsername());
	}
	
	public void resetFailedAttempt(String username) {
		userRepository.updateFailedAttempt(0, username);
	}

	public void lockUser(User user) {
		// TODO Auto-generated method stub
		user.setAccountNonLocked(false);
		user.setLockTime(new Date());
		
		userRepository.save(user);
	}
	
	public boolean unlockUser(User user) {
		long lockTimeMillis = user.getLockTime().getTime();
		long currentTimeMillis = System.currentTimeMillis();
		
		if(lockTimeMillis + LOCK_DURATION < currentTimeMillis) {
			user.setAccountNonLocked(true);
			user.setLockTime(null);
			user.setFailedAttempt(0);
			
			userRepository.save(user);
			
			return true;
		}
		
		return false;
	}
	
	
}
