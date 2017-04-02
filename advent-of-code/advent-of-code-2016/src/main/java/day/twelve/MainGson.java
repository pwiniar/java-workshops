package day.twelve;

import com.google.gson.Gson;
import utils.Tools;

import java.util.List;
import java.util.Map;


/**
 * Created by Pawel on 2016-12-13.
 */
public class MainGson {

    public static void main(String[] args) {
        String path = "advent-of-code-2016/src/main/java/day/twelve/data/input";
        String json = Tools.readFileAsStream(path).toString();
        Gson gson = new Gson();
        Map<String, Object> contents = (Map<String, Object>) gson.fromJson(json, Object.class);
        System.err.println("Sum of numbers: " + sumNumbers(contents, false));
        System.err.println("Sum of numbers: " + sumNumbers(contents, true));
    }

    private static Integer sumNumbers(Object obj, boolean ignoreRed) {
        int sum = 0;
        if (obj instanceof Map) {
            for (Map.Entry<String, Object> entry : ((Map<String, Object>) obj).entrySet()) {
                if (ignoreRed && "red".equals(entry.getValue())) {
                    return 0;
                }
                sum += sumNumbers(entry.getValue(), ignoreRed);
            }
            return sum;
        } else if (obj instanceof List) {
            for ( Object item : (List) obj) {
                sum += sumNumbers(item, ignoreRed);
            }
            return sum;
        } else if (obj instanceof Number) {
            return ((Double) obj).intValue();
        }
        return 0;
    }
}
