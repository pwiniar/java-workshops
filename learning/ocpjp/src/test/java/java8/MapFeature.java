package java8;

import lombok.Value;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by Winiar on 19.06.2017.
 */
public class MapFeature {

    private final Map<Integer, String> map = new HashMap<>();
    private final String EMPTY_STRING = "";


    @Test
    public void merge() throws Exception {

        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");

        map.merge(1, "D", new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String s2) {
                return (s + "_" + s2).toLowerCase();
            }
        });

        printMap();
    }

    @Test
    public void merge2() throws Exception {

        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");

        map.merge(4, "D", new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String s2) {
                return (s + "_" + s2).toLowerCase();
            }
        });

        printMap();
    }

    @Test
    public void compute() throws Exception {
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");

        map.compute(1, (integer, s) -> String.valueOf(integer) + s);
        printMap();


        map.compute(4, (integer, s) -> {
            if (s == null) {
                s = EMPTY_STRING;
            }
            return String.valueOf(integer) + s;
        });
        printMap();

    }

    @Test
    public void computeIfAbsent() throws Exception {
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
//        map.put(null, "D");

        map.computeIfAbsent(null, new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return String.valueOf(integer);
            }
        });
        printMap();

        System.out.println(map.get(null));

//
//        map.compute(4, (integer, s) -> {
//            if (s == null) {
//                s = EMPTY_STRING;
//            }
//            return String.valueOf(integer) + s;
//        });
//        printMap();

    }

    @Test
    public void getOrDefault() throws Exception {
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");

        System.out.println(map.getOrDefault(null, "brak danych"));
    }


    @Test
    public void mergeing() throws Exception {
        Map<String, Level> map = new HashMap<>();
        map.put("A", new Level("abcd", "100", null));

        map.merge("A", new Level("abcd", "100", "200"), new BiFunction<Level, Level, Level>() {
            @Override
            public Level apply(Level level, Level level2) {
                return new Level(level.getId(), level2.getLevel1(), level2.getLevel2());
            }
        });

        System.out.println(map);

    }

    @Value
    private static class Level {
        String id;
        String level1;
        String level2;
    }

    private void printMap() {
        System.out.println(map);
    }
}
