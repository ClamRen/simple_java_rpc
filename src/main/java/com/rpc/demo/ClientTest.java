package com.rpc.demo;

import java.io.IOException;
import java.net.UnknownHostException;

public class ClientTest {

	public static void main(String[] args) {
		System.out.println("client start!!!");
		RPCClient client=new RPCClient("109.105.4.109",10010);
		TransportMessage message=new TransportMessage();
		message.interfaceName="com.rpc.demo.Service";
		message.methodName="say";
		message.paramsTypes= new Class[]{String.class};
		message.parameters=new Object[]{"test!!!"};
		
		try {
			client.sendAndReceive(message);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
