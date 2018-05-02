package indi.zzw.exception;

import java.util.Arrays;

public class ApplicationException extends Exception{
	private String code;
	private String[] parameter;

	public ApplicationException(String code, String... parameter) {
		super(code+":"+ Arrays.toString(parameter));
		this.code = code;
		this.parameter = parameter;
	}

	public String getCode() {
		return code;
	}

	public String[] getParameter() {
		return parameter;
	}
}
