package workshop.java.intermediate.collectionsprocessing;

import org.junit.Test;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by michal on 21.10.2016.
 */
public class RegexpTest {

    @Test
    public void splitAsStream() throws Exception {
        Pattern.compile(":")
                .splitAsStream("foobar:foo:bar")
                .filter(s -> s.contains("bar"))
                .sorted()
                .collect(Collectors.joining(":"));
    }

    @Test
    public void patternAsPredicate() throws Exception {
        Pattern pattern = Pattern.compile(".*@gmail\\.com");
        Stream.of("bob@gmail.com", "alice@hotmail.com")
                .filter(pattern.asPredicate())
                .count();
    }
}
