package indi.zzw.handler;

import indi.zzw.constant.SystemConstant;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

public class RoleWebAuthenticationDetails extends WebAuthenticationDetails {
	private static final long serialVersionUID = 6975601077710753878L;
	private final String role;

	public RoleWebAuthenticationDetails(HttpServletRequest request) {
		super(request);
		role = request.getParameter(SystemConstant.PARAM_ROLE);
	}


	public String getRole() {
		return role;
	}
}
