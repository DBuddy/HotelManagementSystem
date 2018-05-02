package indi.zzw.api;

import indi.zzw.exception.ApplicationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

	@GetMapping("/main")
	public String getMainPage() throws ApplicationException {
		return "mainPage";
	}

	@GetMapping("login")
	public String getLoginPage() throws ApplicationException {
		return "login";
	}
}
