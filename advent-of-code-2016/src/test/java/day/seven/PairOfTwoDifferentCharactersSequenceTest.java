package day.seven;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.regex.Pattern;

/**
 * Created by Pawel on 2016-12-07.
 */

public class PairOfTwoDifferentCharactersSequenceTest {

    private Pattern p = Pattern.compile("(\\w)((?!\\1)\\w)\\2\\1");
    private Analyzer classUnderTests = new PairOfTwoDifferentCharactersSequence();

    @Test
    public void testWhenValidPatternIsBeforeSquareBrackets() throws Exception {
        String path = new File(getClass().getClassLoader().getResource("day.seven/test-input-1-valid").getFile()).getPath();

        int analyze = classUnderTests.analyze(path, p.pattern());
        Assert.assertEquals(analyze, 1);
    }

    @Test
    public void testWhenValueIsOutsideSquareBracketsWithinLargerString() throws Exception {
        String path = new File(getClass().getClassLoader().getResource("day.seven/test-input-2-valid").getFile()).getPath();

        int analyze = classUnderTests.analyze(path, p.pattern());
        Assert.assertEquals(analyze, 1);
    }

    @Test
    public void testWhenValueIsWithinSquareBrackets() throws Exception {
        String path = new File(getClass().getClassLoader().getResource("day.seven/test-input-3-invalid").getFile()).getPath();

        int analyze = classUnderTests.analyze(path, p.pattern());
        Assert.assertEquals(analyze, 0);
    }

    @Test
    public void testWhenValueNotFound() throws Exception {
        String path = new File(getClass().getClassLoader().getResource("day.seven/test-input-4-invalid").getFile()).getPath();

        int analyze = classUnderTests.analyze(path, p.pattern());
        Assert.assertEquals(analyze, 0);
    }
}
