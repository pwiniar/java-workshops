package day.seven;

import day.seven.analyzers.Analyzer;
import day.seven.analyzers.Ssl;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * Created by Pawel on 2016-12-07.
 */
public class SslTest {

    private Analyzer classUnderTests = new Ssl();

    @Test
    public void testOutsideSquareBracketsWithCorrespondingBabWithinSquareBrackets() throws Exception {
        String path = new File(getClass().getClassLoader().getResource("day.seven/test-input-1-valid-ssl").getFile()).getPath();

        int analyze = classUnderTests.analyze(path);
        Assert.assertEquals(1,analyze);
    }

    @Test
    public void testWithinLongStringCorrectValueAndInsideSquareBrackets() throws Exception {
        String path = new File(getClass().getClassLoader().getResource("day.seven/test-input-2-valid-ssl").getFile()).getPath();

        int analyze = classUnderTests.analyze(path);
        Assert.assertEquals(1,analyze);
    }

    @Test
    public void testEkeInSupernetWithCorrespondingKekInHypernet() throws Exception {
        String path = new File(getClass().getClassLoader().getResource("day.seven/test-input-3-valid-ssl").getFile()).getPath();

        int analyze = classUnderTests.analyze(path);
        Assert.assertEquals(1,analyze);
    }

    @Test
    public void testNoCorrespondingValueInSquareAndAfterSquareBrackets() throws Exception {
        String path = new File(getClass().getClassLoader().getResource("day.seven/test-input-4-invalid-ssl").getFile()).getPath();

        int analyze = classUnderTests.analyze(path);
        Assert.assertEquals(0,analyze);
    }
}
