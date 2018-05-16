package indi.zzw.api.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

	//根据身份证号码查询用户信息
	User findUserByCardId(String cardId);
}
