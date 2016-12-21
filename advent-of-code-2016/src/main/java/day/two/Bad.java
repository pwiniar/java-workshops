package day.two;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Pawel on 2016-12-16.
 */
public class Bad {


    enum Move {
        U(0, -1), L(-1, 0), D(0, 1), R(1, 0);

        int dx, dy;

        Move(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }
    }

    static int[][] key = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    static int[][] key2 = {{0, 0, 1, 0, 0}, {0, 2, 3, 4, 0},
            {5, 6, 7, 8, 9}, {0, 10, 11, 12, 0}, {0, 0, 13, 0, 0}};

    static boolean inBounds(int x, int y) {
        return (x >= 0 && x <= 2 && y >= 0 && y <= 2);
        // change upper bounds to 2 for both for part 1
    }

    public static void main(String[] args) throws IOException {
        int x = 1;
        int y = 1;
        List<String> input = Files.readAllLines(Paths.get("advent-of-code-2016/src/main/java/day/two/data/data"));
        String passcode = "";

        for (String each : input) {
            for (int i = 0; i < each.length(); i++) {
                Move current = Move.valueOf(each.substring(i, i + 1));
                int nx = x + current.dx;
                int ny = y + current.dy;
                if (inBounds(nx, ny)) {
//                    // remove this conditional and use key for part 1
//                    if (key2[ny][nx] != 0) {
//                        x = nx;
//                        y = ny;
//                    }
                }
            }
            passcode += key[y][x]; // part 1
//            passcode += Integer.toHexString(key2[y][x]);
        }
        System.out.println(passcode.toUpperCase());
    }
}
