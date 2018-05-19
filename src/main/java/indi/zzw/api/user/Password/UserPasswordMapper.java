package indi.zzw.api.user.Password;

import indi.zzw.exception.ApplicationException;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserPasswordMapper {
	//根据userPasswordId查询用户密码信息
	String findPasswordById(String id) throws ApplicationException;
}
