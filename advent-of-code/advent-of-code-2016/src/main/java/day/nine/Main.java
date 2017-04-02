package day.nine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Pawel on 2016-12-11.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("advent-of-code-2016/src/main/java/day/nine/data/input"));
        System.out.println(FileDecompressor.solution(lines, false));
        System.out.println(FileDecompressor.solution(lines, true));
    }
}
