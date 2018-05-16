package indi.zzw.api.apply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/apply")
public class ApplyController {
	@Autowired
	private ApplyService applyService;

	/**
	 * 返回订房房间申请界面
	 *
	 * @return
	 */
	@GetMapping("/checkIn")
	public String checkInPage() {
		return "checkIn";
	}

	/**
	 * 返回退房房间申请界面
	 *
	 * @return
	 */
	@GetMapping("/checkOut")
	public String checkOutPage() {
		return "checkOut";
	}
}
