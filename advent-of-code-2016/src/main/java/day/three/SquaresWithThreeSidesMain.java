package day.three;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Pawel on 2016-12-05.
 */
public class SquaresWithThreeSidesMain {

    private static Pattern p = Pattern.compile("-?\\d+");
    private static final int[] numberOfTriangles = {0};
    private static List<Integer> strings = new ArrayList<>();
    private static Path path = FileSystems.getDefault().getPath("advent-of-code/src/main/java/quares/witht/three/sides/testInput");


    public static void main(String[] args) throws IOException {

//        part1();
        part2();

    }

    private static void part2() throws IOException {
        Files.lines(path, StandardCharsets.UTF_8)
                .forEach(v -> {
                    v.replace(" +", " ").substring(1).split(" ");
                    Matcher m = p.matcher(v);
                    while (m.find()) {
                        strings.add(Integer.parseInt(m.group()));
                    }


//                    if (Integer.parseInt(v[0]) + Integer.parseInt(v[1]) > Integer.parseInt(v[2])) {
//                        if (Integer.parseInt(v[0]) + Integer.parseInt(v[2]) > Integer.parseInt(v[1])) {
//                            if (Integer.parseInt(v[2]) + Integer.parseInt(v[1]) > Integer.parseInt(v[0])) {
//                                numberOfTriangles[0]++;
//                            }
//                        }
//                    }
                });

        System.out.println(Arrays.toString(numberOfTriangles));
    }

    private static void part1() throws IOException {
        Files.lines(path, StandardCharsets.UTF_8).forEach(s -> {
            Matcher m = p.matcher(s);
            while (m.find()) {
                strings.add(Integer.parseInt(m.group()));
            }

            Integer a = strings.get(0);
            Integer b = strings.get(1);
            Integer c = strings.get(2);
            if (a + b > c && a + c > b && c + b > a) {
                numberOfTriangles[0]++;
            }
            for (int i = 0; i < 3; i++) {
                strings.remove(0);
            }
        });

        System.out.println(Arrays.toString(numberOfTriangles));
    }
}