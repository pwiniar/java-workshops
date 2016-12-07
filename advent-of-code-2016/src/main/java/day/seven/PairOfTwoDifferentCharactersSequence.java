package day.seven;

import utils.Tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Pawel on 2016-12-07.
 */

public class PairOfTwoDifferentCharactersSequence implements Analyzer {

    @Override
    public int analyze(String path, String pattern) {
        final int[] result = {0};
        Tools.readFile(path).forEach(s -> {
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(s);

            if (m.find()) {
                result[0]++;
            }
        });

        return result[0];
    }


}
