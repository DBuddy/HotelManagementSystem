package indi.zzw.api.user.Password;

import com.google.common.base.Strings;
import indi.zzw.exception.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPasswordService {
	@Autowired
	private UserPasswordMapper userPasswordMapper;

	public String findUserPasswordById(String id) throws ApplicationException {
		if (Strings.isNullOrEmpty(id)) {
			throw new ApplicationException("传入ID不能为空!");
		}
		return userPasswordMapper.getPasswordById(id);
	}
}
