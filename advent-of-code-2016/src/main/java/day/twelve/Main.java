package day.twelve;

import day.twelve.decoder.Decoder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Pawel on 2016-12-12.
 */
public class Main {


    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("advent-of-code-2016/src/main/java/day/twelve/data/input"));
        Decoder.solution(lines);
        System.out.println(Decoder.getResultFor("a"));
    }

}
