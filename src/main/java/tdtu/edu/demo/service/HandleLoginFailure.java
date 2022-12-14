package tdtu.edu.demo.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tdtu.edu.demo.entity.User;

@Component
public class HandleLoginFailure extends SimpleUrlAuthenticationFailureHandler{
	
	@Autowired
	private UserService userService;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String usernameString = request.getParameter("username");
		String errorString = exception.getMessage();
		User user = userService.getUserByUsername(usernameString);
		
		if(user != null) {
			System.out.println("Failed to login in username: "+usernameString+"\n"
					+ "Reason: "+errorString);
			if(user.isAccountNonLocked()) {
				if(user.getFailedAttempt() < UserService.MAX_FAILED_ATTEMPTS - 1) {
					userService.increaseFailedAttempt(user);
				} else {
					userService.lockUser(user);
					exception = new LockedException("Your account has been lock in 3 minutes because you enter wrong password 3 times");
				}
			} else if (!user.isAccountNonLocked()) {
				if(userService.unlockUser(user)) {
					exception = new LockedException("Your account has been unlocked !!! Please try to login again");
				}
			}
		} else {
			System.out.println("Username is not exist");
		}
		
		super.setDefaultFailureUrl("/account/login?error");
		super.onAuthenticationFailure(request, response, exception);
	}
	
}
