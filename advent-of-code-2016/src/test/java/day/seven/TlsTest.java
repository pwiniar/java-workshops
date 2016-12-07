package day.seven;

import day.seven.analyzers.Analyzer;
import day.seven.analyzers.Tls;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * Created by Pawel on 2016-12-07.
 */

public class TlsTest {

    private Analyzer classUnderTests = new Tls();

    @Test
    public void testWhenValidPatternIsBeforeSquareBrackets() throws Exception {
        String path = new File(getClass().getClassLoader().getResource("day.seven/test-input-1-valid").getFile()).getPath();

        int analyze = classUnderTests.analyze(path);
        Assert.assertEquals(1,analyze);
    }

    @Test
    public void testWhenValueIsOutsideSquareBracketsWithinLargerString() throws Exception {
        String path = new File(getClass().getClassLoader().getResource("day.seven/test-input-2-valid").getFile()).getPath();

        int analyze = classUnderTests.analyze(path);
        Assert.assertEquals(1,analyze);
    }

    @Test
    public void testWhenValueIsWithinSquareBrackets() throws Exception {
        String path = new File(getClass().getClassLoader().getResource("day.seven/test-input-3-invalid").getFile()).getPath();

        int analyze = classUnderTests.analyze(path);
        Assert.assertEquals(0,analyze);
    }

    @Test
    public void testWhenValueNotFound() throws Exception {
        String path = new File(getClass().getClassLoader().getResource("day.seven/test-input-4-invalid").getFile()).getPath();

        int analyze = classUnderTests.analyze(path);
        Assert.assertEquals(0,analyze);
    }
}
