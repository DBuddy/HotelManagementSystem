package indi.zzw.config;

import indi.zzw.constant.RoleNameConstant;
import indi.zzw.handler.RestAuthenticationFailureHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> authenticationDetailsSource;
	@Autowired
	private AuthenticationProvider  authenticationProvider;

	@Autowired
	private AuthenticationSuccessHandler successHandler;


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/js/**", "/css/**", "/img/**").permitAll()//访问：/home 无需登录认证权限
				.antMatchers("/main").permitAll()
				.antMatchers("/logout").permitAll()
				.antMatchers("/room").hasAnyRole(RoleNameConstant.ROLE_ADMIN_FOR_CONFIG,RoleNameConstant.ROLE_STAFF_FOR_CONFIG) //登陆后之后拥有“ADMIN”权限才可以访问/hello方法，否则系统会出现“403”权限不足的提示
				.anyRequest().authenticated() //其他所有资源都需要认证，登陆后访问
				.and()
				.formLogin().loginPage("/login").permitAll()
				.loginProcessingUrl("/login")
				.authenticationDetailsSource(authenticationDetailsSource)
				.successHandler(successHandler)
				.failureHandler(new RestAuthenticationFailureHandler())
				.and().csrf().disable();
	}
}
