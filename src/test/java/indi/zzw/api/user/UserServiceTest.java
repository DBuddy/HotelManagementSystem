package indi.zzw.api.user;

import indi.zzw.HmsApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(HmsApplication.class)
public class UserServiceTest {
	@Autowired
	private UserService userService;

	@Test
	public void findUserByCardId() throws Exception {
		String cardId = "360203199612111012";
		User user = userService.findUserByCardId(cardId);
		Assert.assertNotNull(user);
	}

	@Test
	public void loadUserByCardId() throws Exception {
	}

}