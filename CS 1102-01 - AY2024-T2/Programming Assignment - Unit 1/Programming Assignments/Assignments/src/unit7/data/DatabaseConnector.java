package unit7.data;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import java.io.File;
import java.io.IOException;
import org.xml.sax.SAXException;

public class DatabaseConnector {

    private final DocumentBuilderFactory documentBuilderFactory;
    private final TransformerFactory transformerFactory;

    public DatabaseConnector() {
        this.documentBuilderFactory = DocumentBuilderFactory.newInstance();
        this.transformerFactory = TransformerFactory.newInstance();
    }

    public Document readXmlFile(String tableName) {
        try {
            DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
            return builder.parse(new File(tableName + ".xml"));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException("Error reading XML file: " + tableName, e);
        }
    }

    public void writeXmlFile(Document document, String tableName) {
        try {
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult file = new StreamResult(new File(tableName + ".xml"));
            transformer.transform(source, file);
        } catch (TransformerException e) {
            throw new RuntimeException("Error writing XML file: " + tableName, e);
        }
    }
}
