package workshop.java.intermediate.collectionsprocessing;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by michal on 21.10.2016.
 */
public class FileSystemTest {

    @Test
    public void listFiles() throws Exception {
        try (Stream<Path> stream = Files.list(Paths.get(""))) {
            String joined = stream
                    .map(String::valueOf)
                    .filter(path -> !path.startsWith("."))
                    .sorted()
                    .collect(Collectors.joining("; "));
            System.out.println("List: " + joined);
        }
    }

    @Test
    public void findFiles() throws Exception {
        Path start = Paths.get("");
        int maxDepth = 15;
        try (Stream<Path> stream = Files.find(start, maxDepth,
                (path, attr) -> String.valueOf(path).endsWith(".java"))) {
            String joined = stream
                    .sorted()
                    .map(String::valueOf)
                    .collect(Collectors.joining("; "));
            System.out.println("Found: " + joined);
        }
    }

    @Test
    public void readLines() throws Exception {
        try (Stream<String> stream = Files.lines(
                Paths.get(
                        "src/test/java",
                        "workshop/java/intermediate",
                        "almostlikefunctional/$EntryTest.java")
        )) {
            stream
                    .filter(line -> line.contains("//"))
                    .map(String::trim)
                    .forEach(System.out::println);
        }
    }
}
