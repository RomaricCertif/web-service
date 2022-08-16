package com.doranco;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class MainDeserializer {

	public static void main(String[] args) throws JAXBException {
		JAXBContext jaxbContext=JAXBContext.newInstance(Account.class);
		Unmarshaller marshaller=jaxbContext.createUnmarshaller();
		Account account=(Account) marshaller.unmarshal(new File("account.xml"));
		System.out.println("Affichage des données");
		System.out.println(account.toString());
	}

}
