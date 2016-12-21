package day.two;

import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Pawel on 2016-12-16.
 */
public class SolutionOneTest {

    @Test
    public void name() throws Exception {
        File file = new File(getClass().getClassLoader().getResource("day.one/test").getFile());
        List<String> lines = Files.readAllLines(Paths.get(file.getPath()));







    }
}
