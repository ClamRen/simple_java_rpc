package com.rpc.demo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class RPCServer {
	private final int port;
	private static ServerSocket server;
	private static HashMap<String,Object> objmap;
	
	RPCServer(int port) throws IOException{
		if(server==null)
			server=new ServerSocket(port);
		objmap=new HashMap<String,Object>();
		this.port=port;
	}
	
	public static void putObj(String name,Object obj){
		objmap.put(name,obj);
	}
	
	public void receiveAndSend() throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		while(true){
			Socket socket=server.accept();
			ObjectInputStream input=new ObjectInputStream(socket.getInputStream());
			Object obj=input.readObject();
			TransportMessage message=(TransportMessage)obj;
			System.out.println(message.interfaceName);
			String interfaceName=message.interfaceName;
			String methodName=message.methodName;
			Class[] paramTypes=message.paramsTypes;
			Object[] params=message.parameters;
			Object service=objmap.get(interfaceName);
			
			System.out.println(interfaceName);
			
			Class<?> serviceclass=Class.forName(interfaceName);
			Method method=serviceclass.getMethod(methodName,paramTypes);
			Object result=method.invoke(service,params);
			
			ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
			out.writeObject(result);
		}
	}
}
