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
		
		System.out.println("User name: "+authentication.getName()+" logged in !!!");
		
		String redirectedURL = request.getContextPath();
		
		if(customUserDetails.hasRole("USER")) {
			redirectedURL = "/user/home-user";
		} else if (customUserDetails.hasRole("MANAGER")) {
			redirectedURL = "/manager/home-manager";
		} else if (customUserDetails.hasRole("ADMIN")){
			redirectedURL = "/admin/home-admin";
		}
		
		response.sendRedirect(redirectedURL);
	}
	
	
}
