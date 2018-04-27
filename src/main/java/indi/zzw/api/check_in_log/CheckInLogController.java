package indi.zzw.api.check_in_log;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/checkInLog")
public class CheckInLogController {
	@Autowired
	private CheckInLogService checkInLogService;

	@GetMapping
	public String checkInLogPage() {
		return "checkInLog";
	}

	/**
	 * 根据条件分页查询入住记录信息
	 *
	 * @param cardId
	 * @param userName
	 * @param roomNumber
	 * @param principal
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(path = "/query",method = RequestMethod.GET)
	public PageInfo<CheckInLog> getCheckInLogByPage(@RequestParam(required = false) String cardId,
													@RequestParam(required = false) String userName,
													@RequestParam(required = false) String roomNumber,
													Principal principal)  throws Exception{
		return checkInLogService.getAllCheckInLog(cardId, roomNumber,userName);
	}

}
