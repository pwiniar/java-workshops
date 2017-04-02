package beginner.basics.beginner.parser.sax;

import org.junit.Test;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by Pawel on 2016-10-26.
 */
public class XmlParserMain {

    @Test
    public void parserTest() throws Exception {
        String file = "src/test/java/sax/parser/example.xml";

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        MyParser myParser = new MyParser();
        saxParser.parse(file, myParser);
        myParser.showAccounts();

    }
}