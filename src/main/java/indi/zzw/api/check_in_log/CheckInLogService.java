package indi.zzw.api.check_in_log;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CheckInLogService {
	@Autowired(required = false)
	private CheckInLogMapper checkInLogMapper;

	/**
	 * 分页查询入住记录信息
	 *
	 * @param cardId
	 * @param roomNumber
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public PageInfo<CheckInLog> getAllCheckInLog(String cardId, String roomNumber, String userName) throws Exception {
		Map<String, Object> criteria = new HashMap<>();
		criteria.put("cardId", cardId);
		criteria.put("userName", userName);
		criteria.put("roomNumber", roomNumber);
		List<CheckInLog> checkInLogs = checkInLogMapper.selectAllByCondition(criteria);
		return new PageInfo<>(checkInLogs);
	}

	public CheckInLog getCheckInLogById(String id) throws Exception {
		return null;
	}

}
