package indi.zzw.api.check_in_log;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CheckInLogMapper{
	List<CheckInLog> selectAll();
	//根据条件查询入住记录信息
	List<CheckInLog> selectAllByCondition(Map<String, Object> criteria);
}

