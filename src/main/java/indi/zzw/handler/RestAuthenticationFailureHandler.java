package indi.zzw.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import indi.zzw.util.ResponseCode;
import indi.zzw.util.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RestAuthenticationFailureHandler implements AuthenticationFailureHandler{

	@Override
	public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
		httpServletResponse.setContentType("application/json");
		httpServletResponse.setCharacterEncoding("UTF-8");
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(new ResponseEntity(ResponseCode.LOGINFAILED,null));
		httpServletResponse.getWriter().write(json);
		httpServletResponse.getWriter().flush();
	}
}
