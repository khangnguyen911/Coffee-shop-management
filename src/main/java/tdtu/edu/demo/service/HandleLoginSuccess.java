package tdtu.edu.demo.service;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class HandleLoginSuccess extends SavedRequestAwareAuthenticationSuccessHandler{

	/*
	 *  the onAuthenticationSuccess() method will be invoked by Spring Security upon user’s successful login. 
	 *  So it’s very logically to put the redirection code in this method, 
	 *  for redirecting the authenticated users based on their roles. 
	 * 
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
		
		String redirectedURL = request.getContextPath();
		
		if(customUserDetails.hasRole("USER")) {
			redirectedURL = "../home-user";
		} else if (customUserDetails.hasRole("CREATOR")) {
			redirectedURL = "../home-creator";
		} else if (customUserDetails.hasRole("EDITOR")) {
			redirectedURL = "../home-editor";
		} else if (customUserDetails.hasRole("ADMIN")){
			redirectedURL = "../home-admin";
		}
		
		response.sendRedirect(redirectedURL);
	}
	
	
}
