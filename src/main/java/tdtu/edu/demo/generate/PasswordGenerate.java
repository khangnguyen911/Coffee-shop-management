package tdtu.edu.demo.generate;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerate {
	public static void main(String[] args) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String password = "buicthanh";
		String encodePassword = bCryptPasswordEncoder.encode(password);
		
		System.out.println(encodePassword);
	}
}
