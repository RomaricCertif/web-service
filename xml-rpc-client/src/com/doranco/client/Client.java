package com.doranco.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

public class Client {
	
	public static void main(String[] args) throws MalformedURLException, XmlRpcException {
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		config.setServerURL(new URL("http://localhost:2022"));
         Vector params = new Vector();
         params.addElement(new Integer(10));
         params.addElement(new Integer(13));
		XmlRpcClient client = new XmlRpcClient();
		client.setConfig(config);
		Object result=client.execute("calculator.sum", params);
		  int sum = ((Integer) result).intValue();
		System.out.println("La somme a donné "+sum);
	}

}
