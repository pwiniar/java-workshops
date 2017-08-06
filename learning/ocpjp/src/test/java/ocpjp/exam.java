package ocpjp;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * Created by Winiar on 04.08.2017.
 */
public class exam {

    @Test
    public void name() throws Exception {
        Stream.of("ace ", "jack ", "queen ", "king ", "joker ")
                .mapToInt(String::length)
                .filter(len -> len > 3)
                .limit(2)
                .forEach(System.out::println);


    }
}
