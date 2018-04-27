package indi.zzw.api.room;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
												 @RequestParam(required = false) String roomStatus) throws Exception {
		return roomService.getRoomPageByCondition(roomNo, roomType, roomStatus);
	}
}
