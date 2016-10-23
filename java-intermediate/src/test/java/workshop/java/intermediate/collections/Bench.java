package workshop.java.intermediate.collections;

import org.openjdk.jmh.annotations.Benchmark;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by michal on 22.10.2016.
 */
public class Bench {

    public static final Collection<String> base = Collections.unmodifiableCollection(
            new Random().doubles(10_000)
            .mapToObj(d -> "next random value is: " + d)
            .collect(Collectors.toList())
    );

    @Benchmark // JMH benchmark
    public void arrayList() throws Exception {
        ArrayList<String> list = new ArrayList<>(0);
        for (String s : base) {
            list.add(s);
        }
    }
}
