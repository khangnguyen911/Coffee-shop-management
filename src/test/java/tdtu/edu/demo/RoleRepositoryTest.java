package tdtu.edu.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import tdtu.edu.demo.entity.Role;
import tdtu.edu.demo.entity.User;
import tdtu.edu.demo.repository.RoleRepository;
import tdtu.edu.demo.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTest {
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void testCreateRole() {
		Role userRole = new Role("USER");
		Role creatorRole = new Role("CREATOR");
		Role editorRole = new Role("EDITOR");
		Role adminRole = new Role("ADMIN");
		Role customerRole = new Role("CUSTOMER");
		
		roleRepository.saveAll(List.of(userRole, creatorRole, editorRole, adminRole, customerRole));
		
		List<Role> listRoles = roleRepository.findAll();
		
		assertThat(listRoles.size()).isEqualTo(9);
	}
	
	@Test
	public void testAddRoleToNewUser() {
		User user = new User();
		user.setFirstname("Nguyen");
		user.setLastname("Khang");
		user.setUsername("npdkhang123");
		user.setPassword("npdkhang123");
		user.setAddress("TPHCM");
		
		Role role = roleRepository.findByName("USER");
		user.addRole(role);
		
		User savedUser = userRepository.save(user);
		
		assertThat(savedUser.getRoles().size()).isEqualTo(1);
	}
}
