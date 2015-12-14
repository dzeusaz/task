package com.competition.client;


import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.Transformer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Created by Kestutis on 2015.12.12.
 */
public class CreateXML {

    public CreateXML(List<DecathlonFinalResultData> resultData, String savePath){
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            Document document = initXML(docBuilder, resultData);
            Element root = document.getDocumentElement();

            Node node = document.createProcessingInstruction
                    ("xml-stylesheet", "type=\"text/xsl\" href=\"appearance.xsl\"");
            document.insertBefore(node, root);

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(savePath));


            transformer.setOutputProperty
                    (OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.ENCODING,"ISO-8859-1");
            transformer.setOutputProperty
                    ("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            transformer.transform(source, result);


        }catch (ParserConfigurationException e){
            e.printStackTrace();
        }catch (TransformerException e){
            e.printStackTrace();
        }
    }

    private Document initXML(DocumentBuilder docBuilder, List<DecathlonFinalResultData> resultData){

        Document document = docBuilder.newDocument();
        Element rootElement = document.createElement("Decathlon");
        document.appendChild(rootElement);



        for(DecathlonFinalResultData data :  resultData){

            Element athlete = document.createElement("Result");
            rootElement.appendChild(athlete);

            Element athletePosition = document.createElement("Place");
            if(data.getSharePositionWith() > 0) {
                athletePosition.appendChild(document.createTextNode(data.getPosition()+
                        " - "+ (data.getPosition()+data.getSharePositionWith())));
            }else {
                athletePosition.appendChild(document.createTextNode(String.valueOf(data.getPosition())));
            }
            athlete.appendChild(athletePosition);

            Element athleteName = document.createElement("Name");
            athleteName.appendChild(document.createTextNode(data.getAthleteName()));
            athlete.appendChild(athleteName);

            Element athleteTotalScore = document.createElement("Score");
            athleteTotalScore.appendChild(document.createTextNode(String.valueOf(data.getTotalScore())));
            athlete.appendChild(athleteTotalScore);

        }
       return document;
    }
}
