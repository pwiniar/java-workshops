package beginner.basics.beginner.parser.dom;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;

/**
 * Created by Pawel on 2016-10-27.
 */
public class DomParserMain {

    private String accType;
    private String id;
    private String name;
    private String amt;

    public void parse(String file) throws IOException, SAXException {
        DOMParser parser = new DOMParser();
        parser.parse(file);
        Document doc = parser.getDocument();
        NodeList root = doc.getChildNodes();

        Node rootElement = getNode(xmlHierarchyTag.root, root);

        if (rootElement == null) {
            throw new RuntimeException("Root element is empty");
        }

        Node account = getNode(xmlHierarchyTag.account, rootElement.getChildNodes());

        accType = getNodeAttr(xmlHierarchyTag.type, account);

        NodeList accounts = account.getChildNodes();
        id = getNodeValue(xmlHierarchyTag.id, accounts);
        name = getNodeValue(xmlHierarchyTag.name, accounts);
        amt = getNodeValue(xmlHierarchyTag.amt, accounts);
    }

    private static Node getNode(String tagName, NodeList nodes) {
        for (int x = 0; x < nodes.getLength(); x++) {
            Node node = nodes.item(x);
            if (node.getNodeName().equalsIgnoreCase(tagName)) {
                return node;
            }
        }

        return null;
    }

    private String getNodeAttr(String tagName, String attrName, NodeList nodes) {
        for (int x = 0; x < nodes.getLength(); x++) {
            Node node = nodes.item(x);
            if (node.getNodeName().equalsIgnoreCase(tagName)) {
                NodeList childNodes = node.getChildNodes();
                for (int y = 0; y < childNodes.getLength(); y++) {
                    Node data = childNodes.item(y);
                    if (data.getNodeType() == Node.ATTRIBUTE_NODE) {
                        if (data.getNodeName().equalsIgnoreCase(attrName))
                            return data.getNodeValue();
                    }
                }
            }
        }

        return "";
    }

    private String getNodeAttr(String attrName, Node node) {
        NamedNodeMap attrs = node.getAttributes();
        for (int y = 0; y < attrs.getLength(); y++) {
            Node attr = attrs.item(y);
            if (attr.getNodeName().equalsIgnoreCase(attrName)) {
                return attr.getNodeValue();
            }
        }
        return "";
    }

    protected String getNodeValue(String tagName, NodeList nodes ) {
        for ( int x = 0; x < nodes.getLength(); x++ ) {
            Node node = nodes.item(x);
            if (node.getNodeName().equalsIgnoreCase(tagName)) {
                NodeList childNodes = node.getChildNodes();
                for (int y = 0; y < childNodes.getLength(); y++ ) {
                    Node data = childNodes.item(y);
                    if ( data.getNodeType() == Node.TEXT_NODE )
                        return data.getNodeValue();
                }
            }
        }
        return "";
    }

    private interface xmlHierarchyTag {
        String root = "Bank";
        String account = "Account";
        String type = "type";
        String id = "Id";
        String name = "Name";
        String amt = "Amt";
    }

    public String getAccType() {
        return accType;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAmt() {
        return amt;
    }
}
