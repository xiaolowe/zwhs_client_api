package cn.org.citycloud.zwhs.bean;

import java.io.Serializable;

/**
 * 返回错误信息Bean
 * @author lanbo
 *
 */
public class Result implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7532296739603122995L;

	public String code;

	public String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
