package tdtu.edu.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tdtu.edu.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("SELECT u FROM User u WHERE u.email = ?1")
	public User findByEmail(String email);
	User findByAddress(String address);
}
