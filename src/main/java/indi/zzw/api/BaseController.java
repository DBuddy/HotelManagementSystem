package indi.zzw.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class BaseController {
	@GetMapping("swiper")
	public String getSwiperMainPage() throws Exception {
		return "swipermainpage";
	}

	@GetMapping
	public String getMainPage() throws Exception {
		return "mainPage";
	}
}
