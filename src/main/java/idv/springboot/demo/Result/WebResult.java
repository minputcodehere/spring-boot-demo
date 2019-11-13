package idv.springboot.demo.Result;

import lombok.Data;

@Data
public class WebResult {

	private String sts;

	private String msg;

	private Object result;

	public WebResult(String sts, String msg, Object result) {

		this.sts = sts;

		this.msg = msg;

		this.result = result;
	}

	public static String GetResultString(String sts, String msg, Object result) {

		return new WebResult(sts, msg, result).toString();
	}

//	public static String GetSuccessResult(Object result) {
//
//		return new WebResult(0, StringUtils.EMPTY, result).toString();
//	}
}
