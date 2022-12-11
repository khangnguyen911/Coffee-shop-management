package tdtu.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tdtu.edu.demo.entity.Role;
import tdtu.edu.demo.entity.User;
import tdtu.edu.demo.repository.RoleRepository;
import tdtu.edu.demo.repository.UserRepository;

@Service
public class UserService {
	
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
}
