package day.seven;

import day.seven.analyzers.Analyzer;

/**
 * Created by Pawel on 2016-12-07.
 */
public class RunManager {

    public static void execute(String path, Analyzer... analyzers) {
        for (Analyzer analyzer : analyzers) {
            int analyze = analyzer.analyze(path);
            System.out.println(String.format("Result for : %s, value : %s ", analyzer.getClass().getSimpleName(), analyze));
        }
    }
}
