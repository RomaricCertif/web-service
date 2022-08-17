package com.ws;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
@Stateless
public class Calculator {
	
	int somme=0;
	
	@WebMethod 
	public int sum ( @WebParam (name = "a") int a, @WebParam (name = "b") int b) {
		System.out.println("Web Service SOAP s'executant dans le seveur ....");
		somme=a+b;
		return somme;
	}

}
