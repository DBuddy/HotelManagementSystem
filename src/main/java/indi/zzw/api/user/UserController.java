package indi.zzw.api.user;

import indi.zzw.exception.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(path = "/name",method = RequestMethod.GET)
	public String getNameByCardId(@RequestParam String cardId) throws ApplicationException {
		return userService.findUserByCardId(cardId).getName();
	}

	@RequestMapping(path = "/user/add",method = RequestMethod.POST)
	public void addUser(@RequestBody Map<String, Object> userMap) throws ApplicationException {
		userService.addUser(userMap);
	}
}
