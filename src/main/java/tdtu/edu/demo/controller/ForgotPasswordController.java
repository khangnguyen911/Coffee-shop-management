package tdtu.edu.demo.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import net.bytebuddy.utility.RandomString;
import tdtu.edu.demo.entity.User;
import tdtu.edu.demo.exception.UserNotFoundException;
import tdtu.edu.demo.generate.Utility;
import tdtu.edu.demo.service.UserService;

@Controller
public class ForgotPasswordController {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private UserService userService;

	@GetMapping("/account/forgot_password")
	public String showForgotPassword(Model model) {
		model.addAttribute("pageTitle", "Forgot password");
		return "account/forgot_password_form";
	}

	@PostMapping("/account/forgot_password")
	public String forgotPasswordProcessing(HttpServletRequest httpServletRequest, Model model) {
		String emailString = httpServletRequest.getParameter("email");
		String tokenString = RandomString.make(64);
		System.out.println("Email: "+emailString);
		System.out.println("Token: "+tokenString);
		
		try {
			userService.updateResetTokenPassword(tokenString, emailString);
			// Generate reset password link
			String resetPasswordLink = Utility.getSiteURL(httpServletRequest)+"/account/reset_password?token="+tokenString;
			System.out.println("Reset password link: "+resetPasswordLink);
			// Send email
			
			sendEmail(emailString, resetPasswordLink);
			
			model.addAttribute("message", "We have sent a link to your email address !!!\nPlease check your email");
		} catch (UserNotFoundException e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
		} catch (UnsupportedEncodingException | MessagingException e) {
			// TODO Auto-generated catch block
			model.addAttribute("error", "Error while sending email !!!\nPlease try again !");
		}
		
		return "account/forgot_password_form";
	}

	private void sendEmail(String emailString, String resetPasswordLink) throws UnsupportedEncodingException, MessagingException {
		// TODO Auto-generated method stub
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
		
		mimeMessageHelper.setFrom("letgood1234@gmail.com", "Admin Coffee shop");
		mimeMessageHelper.setTo(emailString);
		
		String subjectString = "Hello, this is the link to reset your password";
		
		String contentString = "<p>Hello</p>"
				+ "<p>You have requested to change the password.</p>"
				+ "<p>Click the link below to change your password</p>"
				+ "<p><a href=\""+resetPasswordLink+"\">Change my password</a></p>"
				+ "<br>"
				+ "<p>Ignor this email if you remember your password or you have not made the request!!!</p>"
				;
		mimeMessageHelper.setSubject(subjectString);
		mimeMessageHelper.setText(contentString, true);
		javaMailSender.send(mimeMessage);
	}

	@GetMapping("/account/reset_password")
	public String showResetPassword(@Param(value = "token") String token, Model model) {
		
		User user = userService.getResetTokenPassword(token);
		model.addAttribute("token", token);
		
		if(user == null) {
			model.addAttribute("message", "Invalid token");
			return "account/message";
		}
		
		return "account/reset_password_form";
	}

	@PostMapping("/account/reset_password")
	public String resetPasswordProcessing(HttpServletRequest httpServletRequest, Model model) {
		String tokenString = httpServletRequest.getParameter("token");
		String passwordString = httpServletRequest.getParameter("password");
		
		User user = userService.getResetTokenPassword(tokenString);
		if(user == null) {
			model.addAttribute("message", "Invalid token");
			return "account/message";
		} else {
			userService.updatePassword(user, passwordString);
			
			model.addAttribute("message", "You have change your password successfully !!!");
		}
		
		return "account/message";
	}
}
