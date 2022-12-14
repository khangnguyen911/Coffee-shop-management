package tdtu.edu.demo.generate;

import jakarta.servlet.http.HttpServletRequest;

public class Utility {
	public static String getSiteURL(HttpServletRequest httpServletRequest) {
		String siteURL = httpServletRequest.getRequestURL().toString();
		return siteURL.replace(httpServletRequest.getServletPath(), "");
	}
}
