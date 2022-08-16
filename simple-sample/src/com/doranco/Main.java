package com.doranco;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		File file = new File("service.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(file);
		doc.getDocumentElement().normalize();
		System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
		NodeList nodeList = doc.getElementsByTagName("operation");
		for (int i = 0; i < nodeList.getLength(); ++i) {
			Node node = nodeList.item(i);
			System.out.println(node.getNodeName());
			Element tElement = (Element) node;
			System.out.println("Element " + tElement.getElementsByTagName("id").
					item(0).getTextContent());
		}
		
		NodeList nodeList1 = doc.getElementsByTagName("parameters");
		for (int i = 0; i < nodeList1.getLength(); ++i) {
			Node node = nodeList1.item(i);
			System.out.println(node.getNodeName());
			Element tElement = (Element) node;
			System.out.println("Element " + tElement.getElementsByTagName("par1").
					item(0).getTextContent());
		}
	}

}
