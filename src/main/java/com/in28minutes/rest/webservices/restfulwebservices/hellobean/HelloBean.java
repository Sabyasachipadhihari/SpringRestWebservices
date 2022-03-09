package com.in28minutes.rest.webservices.restfulwebservices.hellobean;

public class HelloBean {

	private String msg;

	public HelloBean(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "HelloBean [msg=" + msg + "]";
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
