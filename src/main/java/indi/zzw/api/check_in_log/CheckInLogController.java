package indi.zzw.api.check_in_log;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckInLogController {
	@RequestMapping(path = "/hello",method = RequestMethod.GET)
	public String say() {
		return "helloWorld!";
	}
}
