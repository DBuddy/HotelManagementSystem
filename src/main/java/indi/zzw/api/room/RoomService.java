package indi.zzw.api.room;

		import com.github.pagehelper.PageInfo;
		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.stereotype.Service;

		import java.util.HashMap;
		import java.util.List;
		import java.util.Map;

@Service
public class RoomService {
	@Autowired(required = false)
	private RoomMapper roomMapper;

	PageInfo<Room> getRoomPageByCondition(String roomNo, String roomType, String roomStatus) throws Exception {
		Map<String, Object> criteria = new HashMap<>();
		criteria.put("roomNo",roomNo);
		criteria.put("roomType",roomType);
		criteria.put("roomStatus",roomStatus);
		List<Room> roomList = roomMapper.selectRoomByCondition(criteria);
		return new PageInfo<>(roomList);
	}
}
