package indi.zzw.handler;

import indi.zzw.api.user.User;
import indi.zzw.api.user.UserService;
import indi.zzw.constant.SystemConstant;
import indi.zzw.exception.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	@Autowired
	private UserService userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
		HttpSession session = httpServletRequest.getSession();
		RoleWebAuthenticationDetails details = (RoleWebAuthenticationDetails) authentication.getDetails();
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
		try {
			User user = userService.findUserByCardId(token.getName());
			session.setAttribute("cardId", user.getCardId());
			session.setAttribute("role", details.getRole());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		httpServletResponse.addCookie(new Cookie("cardId",token.getName()));
		httpServletResponse.addCookie(new Cookie("role",details.getRole()));
		if (SystemConstant.USER_ROLE_CUSTOMER.equals(details.getRole())) {
			httpServletResponse.sendRedirect("/apply/checkIn");
		}
		if(SystemConstant.USER_ROLE_STAFF.equals(details.getRole())) {
			httpServletResponse.sendRedirect("/checkInLog");
		}
		else if (SystemConstant.USER_ROLE_ADMIN.equals(details.getRole())){
			httpServletResponse.sendRedirect("/room");
		}
		clearAuthenticationAttributes(httpServletRequest);
	}
}
