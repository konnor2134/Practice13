package org.example.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ConnectionParser {
    File inputFile;
    DocumentBuilderFactory factory;
    DocumentBuilder builder;
    Document document;

    public ConnectionParser(String pathName) throws IOException, SAXException, ParserConfigurationException {
        inputFile = new File(pathName);
        factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        builder = factory.newDocumentBuilder();
        document = builder.parse(inputFile);
    }

    public HashMap<String, String> setConnection() {
        HashMap<String, String> res = new HashMap<>(4);
        NodeList nList = document.getElementsByTagName("datasource");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                NodeList fields = nNode.getChildNodes();

                for (int i = 0; i < fields.getLength(); i++) {
                    Node field = fields.item(i);

                    if (field.getNodeType() == Node.ELEMENT_NODE) {
                        if ("connection-url".equals(field.getNodeName())) {
                            res.put("url", field.getChildNodes().item(0).getTextContent());
                        } else if ("driver-class".equals(field.getNodeName())) {
                            res.put("driver", field.getChildNodes().item(0).getTextContent());
                        } else if ("user-name".equals(field.getNodeName())) {
                            res.put("user", field.getChildNodes().item(0).getTextContent());
                        } else if ("password".equals(field.getNodeName())) {
                            res.put("password", field.getChildNodes().item(0).getTextContent());
                        }
                    }
                }
            }
        }
        return res;
    }
}
