package com.hj.action;

public class HelloAction {
	public String hello() {
		System.out.println("前台请求hello");
		return "success";
	}
}
