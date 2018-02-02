package com.rpc.demo;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class ServerTest {

	public static void main(String[] args) {
		System.out.println("server!!!");
		try {
			RPCServer server=new RPCServer(8000);
			server.putObj("com.rpc.demo.Service",new ServiceHello());
			try {
				server.receiveAndSend();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
