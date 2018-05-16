package indi.zzw.handler;

import indi.zzw.api.user.User;
import indi.zzw.api.user.UserService;
import indi.zzw.exception.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	@Autowired
	private UserService userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
		HttpSession session = httpServletRequest.getSession();
		RoleWebAuthenticationDetails details = (RoleWebAuthenticationDetails) authentication.getDetails();
		try {
			User user = userService.findUserByCardId(authentication.getName());
			session.setAttribute("id", user.getId());
			session.setAttribute("role", details.getRole());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		String targetUrl = httpServletRequest.getHeader("Referer");
		handle(httpServletRequest, httpServletResponse, authentication);
		clearAuthenticationAttributes(httpServletRequest);
	}
}
