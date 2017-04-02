package day.seven;

import day.seven.analyzers.Ssl;
import day.seven.analyzers.Tls;

/**
 * Created by Pawel on 2016-12-07.
 */
public class Main {

    public static void main(String[] args) {
        RunManager.execute("advent-of-code-2016/src/main/java/day/seven/data/input",
                new Tls(),
                new Ssl());
    }
}
