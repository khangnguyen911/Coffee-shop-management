package tdtu.edu.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 55)
	private String firstname;
	
	@Column(nullable = false, length = 55)
	private String lastname;
	
	@Column(nullable = false, unique = true, length = 88)
	private String email;
	
	@Column(nullable = false, length = 66)
	private String password;
	
	@Column(nullable = false)
	private String address;
}
