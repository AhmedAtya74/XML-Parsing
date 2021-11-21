package Parsing;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Catalogue {

	public Catalogue() {
		try {
			getDocument();
		} catch (SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Document getDocument() throws SAXException, IOException, ParserConfigurationException {

		File xmlFile = new File("C:\\Users\\dell\\Documents\\NetBeansProjects\\SOA - XML\\Catalogue.xml");

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilder db = dbf.newDocumentBuilder();

		Document doc = db.parse(xmlFile);
		doc.getDocumentElement().normalize();

		return doc;
	}

	public void addCD(CD cdInfo) {
		Document doc = null;
		try {
			doc = getDocument();
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Element root = doc.getDocumentElement();

		Element cd = doc.createElement("CD");
		root.appendChild(cd);

		Element aTitle = doc.createElement("TITLE");
		Element anArtist = doc.createElement("ARTIST");
		Element aCountry = doc.createElement("COUNTRY");
		Element aCompany = doc.createElement("COMPANY");
		Element aPrice = doc.createElement("PRICE");
		Element aYear = doc.createElement("YEAR");

		aTitle.appendChild(doc.createTextNode(cdInfo.getTitile()));
		anArtist.appendChild(doc.createTextNode(cdInfo.getArtist()));
		aCountry.appendChild(doc.createTextNode(cdInfo.getCountry()));
		aCompany.appendChild(doc.createTextNode(cdInfo.getCompany()));
		aPrice.appendChild(doc.createTextNode(cdInfo.getPrice()));
		aYear.appendChild(doc.createTextNode(cdInfo.getYear()));

		cd.appendChild(aTitle);
		cd.appendChild(anArtist);
		cd.appendChild(aCountry);
		cd.appendChild(aCompany);
		cd.appendChild(aPrice);
		cd.appendChild(aYear);

		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = null;
		try {
			transformer = factory.newTransformer();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DOMSource domSource = new DOMSource(doc);
		StreamResult streamResult = new StreamResult(new File("Catalogue.xml"));
		try {
			transformer.transform(domSource, streamResult);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Node searchByKey(String key) {
		Document doc = null;
		try {
			doc = getDocument();
		} catch (SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		NodeList nodeList = doc.getElementsByTagName("CD");
		Node ans = null;
		for (int itr = 0; itr < nodeList.getLength(); itr++) {
			Node node = nodeList.item(itr);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				String aTitle = eElement.getElementsByTagName("TITLE").item(0).getTextContent();
				String anArtist = eElement.getElementsByTagName("ARTIST").item(0).getTextContent();
				if (aTitle.toLowerCase().equals(key.toLowerCase())
						|| anArtist.toLowerCase().equals(key.toLowerCase())) {
					ans = node;
				}
			}

		}

		return ans;
	}
}
