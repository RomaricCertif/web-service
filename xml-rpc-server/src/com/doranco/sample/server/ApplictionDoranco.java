package com.doranco.sample.server;
//https://mavenlibs.com/jar/file/javax.xml.rpc/javax.xml.rpc-api

import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;
public class ApplictionDoranco {
	


	public static void main(String[] args) throws Exception{
		
		WebServer webServer = new WebServer(2022);
		
		XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();
	

		PropertyHandlerMapping propHandlerMapping = new PropertyHandlerMapping();
		propHandlerMapping.addHandler("calculator", Calculator.class);
		//propHandlerMapping.load(Thread.currentThread().getContextClassLoader(), "handler.properties");
		xmlRpcServer.setHandlerMapping(propHandlerMapping);
	


		webServer.start();

		System.out.println("Server started successfully...");;
	}

}
