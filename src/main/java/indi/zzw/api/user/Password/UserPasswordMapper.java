package indi.zzw.api.user.Password;

import indi.zzw.exception.ApplicationException;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserPasswordMapper {
	public String getPasswordById(String id) throws ApplicationException;
}
