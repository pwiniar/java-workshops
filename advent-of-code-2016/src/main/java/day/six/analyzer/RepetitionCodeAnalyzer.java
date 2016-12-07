package day.six.analyzer;

import utils.Tools;

import java.util.stream.Stream;

/**
 * Created by Pawel on 2016-12-06.
 */
public class RepetitionCodeAnalyzer {

    private Stream<String> stringStream;

    public RepetitionCodeAnalyzer(String filePath) {
        this.stringStream = Tools.readFileAsStream(filePath);
    }

    public int getNumberOfColumns() {
        return stringStream.findFirst().get().length();
    }




}
