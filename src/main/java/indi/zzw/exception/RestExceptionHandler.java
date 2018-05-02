package indi.zzw.exception;


import com.alibaba.fastjson.JSONObject;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler({HttpMessageNotReadableException.class})
	@ResponseBody
	public String requestNotReadable (HttpMessageNotReadableException ex) {
		ex.printStackTrace();
		JSONObject result = new JSONObject();
		//json数据读取失败
		result.put("code",400);
		result.put("message","json数据读取失败！");

		return result.toJSONString();
	}
}
