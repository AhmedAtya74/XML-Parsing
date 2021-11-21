package Parsing;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Printer {

	public void printNode(Node node) {
		if (node == null) {
			System.out.println("Node is NULL");
			return;
		}
		Element eElement = (Element) node;
		System.out.println("CD TITLE: " + eElement.getElementsByTagName("TITLE").item(0).getTextContent());
		System.out.println("CD ARTIST: " + eElement.getElementsByTagName("ARTIST").item(0).getTextContent());
		System.out.println("CD COUNTRY: " + eElement.getElementsByTagName("COUNTRY").item(0).getTextContent());
		System.out.println("CD COMPANY: " + eElement.getElementsByTagName("COMPANY").item(0).getTextContent());
		System.out.println("CD PRICE: " + eElement.getElementsByTagName("PRICE").item(0).getTextContent());
		System.out.println("CD YEAR: " + eElement.getElementsByTagName("YEAR").item(0).getTextContent());
	}

	public void printAll(Catalogue catalogue) {
		Document doc = null;
		try {
			doc = catalogue.getDocument();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

		NodeList nodeList = doc.getElementsByTagName("CD");

		for (int itr = 0; itr < nodeList.getLength(); itr++) {
			Node node = nodeList.item(itr);
			System.out.println("\nNode Name: " + node.getNodeName());
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				System.out.println("CD TITLE: " + eElement.getElementsByTagName("TITLE").item(0).getTextContent());
				System.out.println("CD ARTIST: " + eElement.getElementsByTagName("ARTIST").item(0).getTextContent());
				System.out.println("CD COUNTRY: " + eElement.getElementsByTagName("COUNTRY").item(0).getTextContent());
				System.out.println("CD COMPANY: " + eElement.getElementsByTagName("COMPANY").item(0).getTextContent());
				System.out.println("CD PRICE: " + eElement.getElementsByTagName("PRICE").item(0).getTextContent());
				System.out.println("CD YEAR: " + eElement.getElementsByTagName("YEAR").item(0).getTextContent());
			}
		}
	}
}
