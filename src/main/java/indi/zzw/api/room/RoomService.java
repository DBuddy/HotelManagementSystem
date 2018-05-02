package indi.zzw.api.room;

import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import indi.zzw.exception.ApplicationException;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoomService {
	@Autowired(required = false)
	private RoomMapper roomMapper;

	/**
	 * 分页查询房价信息
	 *
	 * @param roomNo
	 * @param roomType
	 * @param roomStatus
	 * @return
	 * @throws ApplicationException
	 */
	PageInfo<Room> getRoomPageByCondition(String roomNo, String roomType, String roomStatus) throws ApplicationException {
		Map<String, Object> criteria = new HashMap<>();
		criteria.put("roomNo",roomNo);
		criteria.put("roomType",roomType);
		criteria.put("roomStatus",roomStatus);
		List<Room> roomList = roomMapper.selectRoomByCondition(criteria);
		return new PageInfo<>(roomList);
	}

	void modifyRoomById(Map<String, Object> paramMap) throws ApplicationException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
		String id = (String) paramMap.get("id");
		if (Strings.isNullOrEmpty(id)) {
			throw new ApplicationException("房间ID不能为空！");
		}
		Object bean = Class.forName("indi.zzw.api.room.Room").newInstance();
		BeanUtils.populate(bean,paramMap);
		roomMapper.updateRoomByModel((Room) bean);
	}

	/**
	 * 根据Id获取房间详情
	 *
	 * @param id
	 * @return
	 * @throws ApplicationException
	 */
	public Map<String, Object> getRoomById(String id) throws ApplicationException {
		if (Strings.isNullOrEmpty(id)) {
			throw new ApplicationException("房间ID不能为空！");
		}
		return roomMapper.selectRoomById(id);
	}
}
