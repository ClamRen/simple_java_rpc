package com.rpc.demo;

public class ServiceHello implements Service{

	public void say(String str) {
		System.out.println("server: "+str);
	}

}
