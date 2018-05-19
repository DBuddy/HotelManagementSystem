package indi.zzw.api.user;

import com.google.common.base.Strings;
import indi.zzw.api.user.Password.UserPasswordService;
import indi.zzw.constant.RoleNameConstant;
import indi.zzw.constant.SystemConstant;
import indi.zzw.exception.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserPasswordService userPasswordService;

	/**
	 * 根据身份证号码查询用户
	 *
	 * @param cardId
	 * @return
	 * @throws ApplicationException
	 */
	public User findUserByCardId(String cardId) throws ApplicationException {
		return userMapper.findUserByCardId(cardId);
	}

	public UserDetails loadUserByCardId(String cardId, String role) throws ApplicationException {
		if (Strings.isNullOrEmpty(cardId)) {
			throw new ApplicationException("身份证号码不能为空!");
		}
		User user = findUserByCardId(cardId);
		//如果是酒店顾客
		if (SystemConstant.USER_ROLE_CUSTOMER.equals(role)) {
			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(RoleNameConstant.ROLE_CUSTOM_USER_FOR_DESTRIBUTION));
			return new org.springframework.security.core.userdetails.User(user.getCardId(), userPasswordService.findUserPasswordById(user.getUserPasswordId()), authorities);
		}
		//如果是酒店员工
		if (SystemConstant.USER_ROLE_STAFF.equals(role)) {
			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(RoleNameConstant.ROLE_STAFF_FOR_DESTRIBUTION));
			return new org.springframework.security.core.userdetails.User(user.getCardId(), userPasswordService.findUserPasswordById(user.getUserPasswordId()), authorities);
		}
		//如果是酒店管理员
		if (SystemConstant.USER_ROLE_ADMIN.equals(role)) {
			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(RoleNameConstant.ROLE_ADMIN_FOR_DESTRIBUTION));
			return new org.springframework.security.core.userdetails.User(user.getCardId(), userPasswordService.findUserPasswordById(user.getUserPasswordId()), authorities);
		}
		throw new UsernameNotFoundException("非指定登录种类!");
	}


	public void addUser(Map<String, Object> paramMap) throws ApplicationException {

	}
}
