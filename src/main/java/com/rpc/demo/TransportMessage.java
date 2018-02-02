package com.rpc.demo;

import java.io.Serializable;

public class TransportMessage implements Serializable {

    public String interfaceName;

    public String methodName;

    public Class[] paramsTypes;

    public Object[] parameters;
 
    public TransportMessage() {
        super();
        // TODO Auto-generated constructor stub
    }
 

    public TransportMessage(String interfaceName, String methodName,

            Class[] paramsTypes, Object[] parameters) {

        super();

        this.interfaceName = interfaceName;

        this.methodName = methodName;

        this.paramsTypes = paramsTypes;

        this.parameters = parameters;

    }
 
}

