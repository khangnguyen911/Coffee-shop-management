package tdtu.edu.demo.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tdtu.edu.demo.entity.User;
	
public interface UserRepository extends CrudRepository<User, Integer>{
	
	@Query("SELECT u FROM User u WHERE u.username = :username")
	public User getUserByUsername(@Param("username") String username);
	
	@Query("SELECT u FROM User u WHERE u.email = :email")
	public User findByEmail(String email);
	
	/*
	 * the findByTokenresetpassword() method will be used to validate the token 
	 * when the user clicks the change password link in email
	 */
	
	public User findByTokenresetpassword(String tokenresetpassword);
	
	@Query("UPDATE User u SET u.failedAttempt = ?1 WHERE u.username = ?2")
	@Modifying
	public void updateFailedAttempt(int failedAttempt, String username);
	
	@Query("UPDATE User u SET u.enabled = true WHERE u.id = ?1")
	@Modifying
	public void enableUser(Integer id);
	
	@Query("SELECT u FROM User u WHERE u.verificationCode = ?1")
	public User findByVerificationCode(String code);
}
