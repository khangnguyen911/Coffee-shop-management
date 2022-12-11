package tdtu.edu.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tdtu.edu.demo.entity.User;

//public interface UserRepository extends JpaRepository<User, Integer>{
//	@Query("SELECT u FROM User u WHERE u.email = ?1")
//	public User findByEmail(String email);
//	User findByAddress(String address);
//}
	
public interface UserRepository extends CrudRepository<User, Integer>{
	
	@Query("SELECT u FROM User u WHERE u.username = :username")
	public User getUserByUsername(@Param("username") String username);
	
	public User findByEmail(String email);
}
