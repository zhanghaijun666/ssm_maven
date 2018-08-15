package com.model;

public class ResultMsg {
	
	private int resultCode;
	private String msg;
	private Object data;
	
	public ResultMsg() {
	}
	public ResultMsg(int resultCode, String msg, Object data) {
		super();
		this.resultCode = resultCode;
		this.msg = msg;
		this.data = data;
	}
	public int getResultCode() {
		return resultCode;
	}
	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResultMsg [resultCode=" + resultCode + ", msg=" + msg + ", data=" + data + "]";
	}
	
	
	

}
