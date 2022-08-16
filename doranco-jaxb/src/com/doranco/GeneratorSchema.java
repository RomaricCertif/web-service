package com.doranco;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

public class GeneratorSchema {

	public static void main(String[] args) throws JAXBException, IOException {
		JAXBContext context=JAXBContext.newInstance(Account.class);
		context.generateSchema(new SchemaOutputResolver() {
			
			@Override
			public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
				File file=new File ("account.xsd");
				StreamResult result=new StreamResult(file);
				result.setSystemId(file.getName());
				return result;
			}
		});

	}

}
