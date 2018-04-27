package indi.zzw.api.room;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RoomMapper {
	//根据条件查询房间信息
	List<Room> selectRoomByCondition(Map<String, Object> criteria);
}
