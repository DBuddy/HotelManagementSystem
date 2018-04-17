package indi.zzw.api.check_in_log;

import com.github.pagehelper.PageInfo;
import indi.zzw.HmsApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(HmsApplication.class)
public class CheckInLogServiceTest {
	@Autowired(required = false)
	private CheckInLogService checkInLogService;

	@Test
	public void getAllCheckInLog() throws Exception {
		PageInfo<CheckInLog> checkInLogPageInfo = checkInLogService.getAllCheckInLog("","","");
		assertNotNull(checkInLogPageInfo);
	}

	@Test
	public void getCheckInLogById() throws Exception {
		String id = "HC001";
		CheckInLog checkInLog = checkInLogService.getCheckInLogById(id);
		assertNotNull(checkInLog);
	}

}