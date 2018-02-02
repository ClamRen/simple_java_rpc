package com.rpc.demo;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

public class RPCClient {
	public final String address;
	public final int port;
	
	RPCClient(String address,int port){
		this.address=address;
		this.port=port;
	}
	
	public Object sendAndReceive(TransportMessage message) throws UnknownHostException, IOException, ClassNotFoundException {
		System.out.println(address+" "+port);
		
		Socket socket=new Socket(address,port);
		
		ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
		
		out.writeObject(message);
		
		ObjectInputStream input=new ObjectInputStream(socket.getInputStream());
		
		Object result=input.readObject();
		
		return result;
	}
	
}
