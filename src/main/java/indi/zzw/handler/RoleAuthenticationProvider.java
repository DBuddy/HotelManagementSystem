package indi.zzw.handler;

import indi.zzw.api.user.UserService;
import indi.zzw.exception.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class RoleAuthenticationProvider implements AuthenticationProvider{
	@Autowired
	private UserService userService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		RoleWebAuthenticationDetails details = (RoleWebAuthenticationDetails) authentication.getDetails();
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
		UserDetails userDetails = null;
		try {
			userDetails = userService.loadUserByCardId(token.getName(),details.getRole());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		if (userDetails == null) {
			throw new UsernameNotFoundException("找不到该用户!");
		}
		if(!userDetails.getPassword().equals(token.getCredentials().toString()))
		{
			throw new BadCredentialsException("密码错误!");
		}
		return new UsernamePasswordAuthenticationToken(userDetails,userDetails.getPassword(),userDetails.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
