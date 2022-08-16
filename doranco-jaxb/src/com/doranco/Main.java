package com.doranco;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Main {

	public static void main(String[] args) throws JAXBException {
		JAXBContext jaxbContext=JAXBContext.newInstance(Account.class);
		Marshaller marshaller=jaxbContext.createMarshaller();
		Account account=new Account();
		account.setAccountId("001");
		account.setAmount(10000);
		account.setDate(new Date());
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(account, new File("account.xml"));
		System.out.println("Succes");
	}

}
