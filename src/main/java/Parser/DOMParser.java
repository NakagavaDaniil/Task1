package Parser;

import Entity.Person;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.LinkedList;
import java.util.List;


public class DOMParser {


    public DOMParser() {

    }

    public List<Person> getData(File file){
        List<Person> list = new LinkedList<Person>();
//        try {
//
//            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder builder = factory.newDocumentBuilder();
//            Document document = builder.parse(file);
//
//            XPathFactory xPathFactory = XPathFactory.newInstance();
//            XPath xPath = xPathFactory.newXPath();
//
//            NodeList sections = (NodeList) xPath.evaluate("/catalog/notebook/person",document, XPathConstants.NODESET);
//
//            int numSections = sections.getLength();
//            for (int i = 0; i < numSections; i++) {
//                Element section = (Element) sections.item(i);
//                System.out.println(section.getTagName());
//            for(int g=0;g<section.getChildNodes().getLength();g++) {
//                Node title = section.getChildNodes().item(g);
//                while (title != null && title.getNodeType() != Node.ELEMENT_NODE) {
//                    title = title.getNextSibling();
//                }
//
//                if (title != null)
//                    System.out.println(title.getTextContent());
//            }
//            }
//
//
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getElementsByTagName("person"));
            NodeList nList = doc.getElementsByTagName("person");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Name : "
                            + eElement.getElementsByTagName("name").item(0)
                            .getTextContent());
                    System.out.println("address : "
                            + eElement
                            .getElementsByTagName("address")
                            .item(0)
                            .getTextContent());
                    System.out.println("cash : "
                            + eElement
                            .getElementsByTagName("cash")
                            .item(0)
                            .getTextContent());
                    System.out.println("education : "
                            + eElement
                            .getElementsByTagName("education")
                            .item(0)
                            .getTextContent());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
