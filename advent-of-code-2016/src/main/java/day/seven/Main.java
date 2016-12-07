package day.seven;

import day.seven.analyzers.Analyzer;
import day.seven.analyzers.Ssl;
import day.seven.analyzers.Tls;

/**
 * Created by Pawel on 2016-12-07.
 */
public class Main {

    public static void main(String[] args) {
        final String path = "advent-of-code-2016/src/main/java/day/seven/data/input";

        Analyzer task1 = new Tls();
        Analyzer task2 = new Ssl();

        RunManager.execute(path, task1, task2);
    }
}
