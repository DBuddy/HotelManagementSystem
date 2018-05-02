package indi.zzw.api.room;

import com.github.pagehelper.PageInfo;
import indi.zzw.exception.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@Controller
@RequestMapping("/room")
public class RoomController {
	@Autowired
	private RoomService roomService;

	@GetMapping("")
	public String roomPage() throws Exception {
		return "room";
	}

	/**
	 *  列表查询房间信息
	 *
	 * @param roomNo
	 * @param roomType
	 * @param roomStatus
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(path = "/query", method = RequestMethod.GET)
	public PageInfo<Room> getRoomPageByCondition(@RequestParam(required = false) String roomNo,
												 @RequestParam(required = false) String roomType,
												 @RequestParam(required = false) String roomStatus) throws ApplicationException {
		return roomService.getRoomPageByCondition(roomNo, roomType, roomStatus);
	}

	@ResponseBody
	@RequestMapping(path = "/{id}",method = RequestMethod.GET)
	public Map<String, Object> getRoomById(@PathVariable String id) throws ApplicationException {
		return roomService.getRoomById(id);
	}


	/**
	 *  修改房间信息
	 *
	 * @param paramMap
	 * @throws ApplicationException
	 * @throws ClassNotFoundException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.PATCH)
	public void modityRoomById(@RequestBody Map<String ,Object> paramMap) throws ApplicationException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
		roomService.modifyRoomById(paramMap);
	}
}
