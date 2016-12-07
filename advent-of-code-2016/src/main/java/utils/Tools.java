package utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.stream.Stream;

/**
 * Created by Pawel on 2016-12-06.
 */
public class Tools {

    public static Stream<String> readFile(String path) {
        Stream<String> lines = null;
        try {
            lines = Files.lines(FileSystems.getDefault().getPath(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
