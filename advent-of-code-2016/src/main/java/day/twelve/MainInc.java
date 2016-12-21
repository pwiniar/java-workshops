package day.twelve;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Pawel on 2016-12-13.
 */
public class MainInc {
    static Map<String, Integer> map = new HashMap<>();
    static ArrayList<String> instructions = new ArrayList<>();


    public static void main(String[] args) throws FileNotFoundException {
        String path = "advent-of-code-2016/src/main/java/day/twelve/data/input";
        Scanner scan = new Scanner(new File(path));
        while (scan.hasNext()) {
            instructions.add(scan.nextLine());
        }
        map.put("a", 0);
        map.put("b", 0);
        map.put("c", 1);
        map.put("d", 0);
        for (int i = 0; i < instructions.size(); i++) {
            String[] line = instructions.get(i).split(" ");
            if (line[0].equals("cpy")) {
                try {
                    int x = Integer.parseInt(line[1]); //is it an int
                    map.put(line[2], x);
                } catch (Exception e) {
                    map.put(line[2], map.get(line[1])); //if not it's a character
                }
            } else if (line[0].equals("inc")) {
                map.put(line[1], map.get(line[1]) + 1);
            } else if (line[0].equals("dec")) {
                map.put(line[1], map.get(line[1]) - 1);
            } else if (line[0].equals("jnz")) {
                try {
                    int x = Integer.parseInt(line[1]);
                    if (x != 0)
                        i += Integer.parseInt(line[2]) - 1;
                    if (i > instructions.size())
                        break;
                } catch (Exception e) {
                    int x = map.get(line[1]);
                    if (x != 0)
                        i += Integer.parseInt(line[2]) - 1;
                    if (i > instructions.size())
                        break;
                }
            }
        }
        System.out.println(map.get("a"));
    }

}
