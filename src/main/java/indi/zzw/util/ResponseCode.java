package indi.zzw.util;

public enum ResponseCode {
	SUCCESS(0, "请求成功"),
	WARN(-1, "网络异常，请稍后重试"),
	LOGINFAILED(-2,"登录失败"),
	EXCEPTION(-3,"出现异常");

	private int code;
	private String msg;

	ResponseCode(int code, String msg) {
		this.msg = msg;
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
}
