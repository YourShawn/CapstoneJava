//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.capstone.healthcare.common;

/**
 * @author xw
 * @param <T>
 */
public class ResultModel<T> {
	public static final int REST_SUCCESS_CODE = 200;

	/**
	 * Message
	 */
	private String message = "success";

	/**
	 * code
	 */
	private int code = 200;

	/**
	 * data
	 */
	private T data;

	public ResultModel() {
	}

	public ResultModel(T data) {
		this.data = data;
	}

	public ResultModel(int code, String message) {
		this.code = code;
		this.message = message;
	}


	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return this.code == 200;
	}

}
