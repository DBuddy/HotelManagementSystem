package indi.zzw.api.room;

import indi.zzw.HmsApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Import(HmsApplication.class)
public class RoomServiceTest {
	@Autowired
	private RoomService roomService;

	@Test
	public void getRoomPageByCondition() throws Exception {
		StringBuilder stringBuilder = new StringBuilder("ssa");
		while (stringBuilder.length()<8) {
			stringBuilder.insert(0,'0');
		}
		System.out.println("--------->111");
	}

	@Test
	public void main() throws Exception {
		Map<String, Boolean> booleanMap = new HashMap<>();
		booleanMap.put("key",true);
		boolean value = booleanMap != null ? booleanMap.get("key") : false;
		System.out.println(value);
	}

	@Test
	public void testMap2Bean() throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		String updateUserId = "HU0001";
		paramMap.put("id","HR001");
		paramMap.put("roomNo","606a");
		paramMap.put("roomType","普通单间");
		paramMap.put("roomStatus","RS01");
		paramMap.put("roomPrice","200");
		paramMap.put("updateUserId",updateUserId);
		roomService.modifyRoomById(paramMap);
	}


}