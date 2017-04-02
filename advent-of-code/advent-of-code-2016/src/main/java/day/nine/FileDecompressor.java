package day.nine;

import java.util.List;

/**
 * Created by Pawel on 2016-12-11.
 */
public class FileDecompressor {

    public static long solution(List<String> lines, boolean partTwo) {
        return lines.stream().map(s -> decompress(s, partTwo)).reduce(0L, Long::sum);
    }

    private static long decompress(String lines, boolean partTwo) {
        long cnt = 0;

        char[] chars = lines.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ')
                continue;
            else if (chars[i] == '(') {
                int end = lines.indexOf(')', i);
                int howMuch = Integer.valueOf(lines.substring(i + 1, end).split("x")[0]);
                int times = Integer.valueOf(lines.substring(i + 1, end).split("x")[1]);
                String repeat = lines.substring(end + 1, end + 1 + howMuch);
                cnt += times * ((partTwo) ? decompress(repeat, partTwo) : repeat.length());
                i = end + howMuch;
            } else {
                cnt++;
            }
        }

        return cnt;

    }
}
