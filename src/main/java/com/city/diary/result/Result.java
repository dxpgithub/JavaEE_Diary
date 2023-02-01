package com.city.diary.result;

public class Result<T> {
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}
	private int code;//状态码	成功=1，失败=0
	private String msg;//提示信息
	private T result;//返回的对象(字符串，javaBean...)
}
