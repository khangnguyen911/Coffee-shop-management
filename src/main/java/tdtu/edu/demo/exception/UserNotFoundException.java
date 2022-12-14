package tdtu.edu.demo.exception;

import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	
	public UserNotFoundException(String email) {
		super("Email address: "+email+" not found in the database");
		this.email = email;
	}
}
