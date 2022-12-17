package tdtu.edu.demo.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	@Column(name = "user_id")
	private Integer userID;
	
	@Column(nullable = false, length = 64)
	private String firstname;
	
	@Column(nullable = false, length = 64)
	private String lastname;
	
	@Column(nullable = false, length = 64)
	private String username;
	
	@Column(nullable = false, length = 64)
	private String password;
	
	@Column(nullable = false, unique = true, length = 64)
	private String email;
	
	@Column(nullable = false, length = 96)
	private String address;
	
	@Column(length = 64, name = "tokenresetpassword")
	private String tokenresetpassword;
	
	@Column(name = "verification_code", length = 64, updatable = false)
	private String verificationCode;
	
	private boolean enabled;

	@Column(name = "account_non_locked")
	private boolean accountNonLocked;
	
	@Column(name = "failed_attempt")
	private int failedAttempt;
	
	@Column(name = "lock_time")
	private Date lockTime;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name = "tbl_users_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
			)
	private Set<Role> roles = new HashSet<>();
	
	public void addRole(Role role) {
		this.roles.add(role);
	}
	
	/*
	 *  check if the currently logged-in user has a specific role or not.
	 *  
	 *  The hasRole() method will return true if the user is assigned with the specified role, or false otherwise
	 */
	
	public boolean hasRole(String roleName) {
		Iterator<Role> iterator = this.roles.iterator();
		
		while (iterator.hasNext()) {
			Role role = iterator.next();
			if(role.getName().equals(roleName)) {
				return true;
			}
		}
		
		return false;
	}
}
