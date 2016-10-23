package workshop.java.intermediate.collectionsprocessing;

import org.junit.Test;
import workshop.java.intermediate.boilerplatefree.Movie;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by michal on 22.10.2016.
 */
public class BasicsOperations {

    @Test
    public void justFun() throws Exception {
        List<String> myList =
                Arrays.asList("b1", "a2", "c2", "a1", "c1", "a2");

        myList
                .stream()
                .filter(s -> !s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .peek(System.out::println)
                .skip(1)
                .limit(3)
                .distinct()
                .flatMapToInt(CharSequence::chars)
                .peek(System.out::println)
                .count()
        ;
    }

    public static List<String> genres() {
        return Arrays.stream(Movie.Genre.values())
                .map(Movie.Genre::name)
                .collect(Collectors.toList());
    }
}
