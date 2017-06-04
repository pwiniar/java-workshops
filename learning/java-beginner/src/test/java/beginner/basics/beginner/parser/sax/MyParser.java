package beginner.basics.beginner.parser.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by Pawel on 2016-10-26.
 */
public class MyParser extends DefaultHandler {

    private String plainText;
    private Account acct;
    private List<Account> accList = new ArrayList<>();

    public void characters(char[] buffer, int start, int length) {
        plainText = new String(buffer, start, length);
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        plainText = "";
        if (qName.equalsIgnoreCase("Account")) {
            acct = new Account();
            acct.setType(attributes.getValue("type"));
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("Account")) {
            accList.add(acct);
        } else if (qName.equalsIgnoreCase("Name")) {
            acct.setName(plainText);
        } else if (qName.equalsIgnoreCase("Id")) {
            acct.setId(Integer.parseInt(plainText));
        } else if (qName.equalsIgnoreCase("Amt")) {
            acct.setAmount(Integer.parseInt(plainText));
        }
    }

    protected void showAccounts() {
        System.out.println("No of accounts in nicebank '" + accList.size()  + "'.");
        Iterator<Account> iterator = accList.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }
}
