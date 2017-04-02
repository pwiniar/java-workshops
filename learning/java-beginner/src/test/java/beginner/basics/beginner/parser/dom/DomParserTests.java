package beginner.basics.beginner.parser.dom;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Pawel on 2016-10-27.
 */
public class DomParserTests {

    private final String goodFile = "src/test/java/workshop/java/beginner/basics/beginner/parser/dom/example.xml";
    private final String fileWihoutRootElemet = "src/test/java/workshop/java/beginner/basics/beginner/parser/dom/badExample.xml";

    @Test
    public void whenTypeIsReturnedThenShouldBeEqualToSavings() throws Exception {
        DomParserMain domParser = new DomParserMain();
        domParser.parse(goodFile);
        Assert.assertEquals("saving", domParser.getAccType());
    }

    @Test
    public void whenIdReturnedThenShouldBeEqualToSavings() throws Exception {
        DomParserMain domParser = new DomParserMain();
        domParser.parse(goodFile);
        Assert.assertEquals("1001", domParser.getId());
    }

    @Test
    public void whenNameReturnedThenShouldBeEqualToJack() throws Exception {
        DomParserMain domParser = new DomParserMain();
        domParser.parse(goodFile);
        Assert.assertEquals("Jack Robinson", domParser.getName());

    }

    @Test
    public void whenAmtReturnedThenShouldBeEqualTo1000() throws Exception {
        DomParserMain domParser = new DomParserMain();
        domParser.parse(goodFile);
        Assert.assertEquals("10000", domParser.getAmt());

    }

    @Test(expected = RuntimeException.class)
    public void whenRootElementIsUnavailableThrowException() throws Exception {
        DomParserMain domParser = new DomParserMain();
        domParser.parse(fileWihoutRootElemet);
    }

    @Test
    public void whenRootElementIsUnavailableThenThrowException() throws Exception {
        DomParserMain domParser = new DomParserMain();
        RuntimeException exception = null;

        try {
            domParser.parse(fileWihoutRootElemet);
        } catch (RuntimeException e) {
            exception = e;
        }

        Assert.assertNotNull(exception);
        Assert.assertEquals("Root element is empty", exception.getMessage());
    }
}
