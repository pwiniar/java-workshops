package day.six.analyzer;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.File;

/**
 * Created by Pawel on 2016-12-06.
 */
public class RepetitionCodeAnalyzerTest {

    private ClassLoader classLoader = getClass().getClassLoader();
    private RepetitionCodeAnalyzer repetitionCodeAnalyzer = new RepetitionCodeAnalyzer(
            new File(classLoader.getResource("day.six/testInput").getFile()).getPath());

    @Test
    public void numberOfColumnsIsSix() throws Exception {
        Assertions.assertThat(repetitionCodeAnalyzer.getNumberOfColumns()).isEqualTo(6);
    }
}
