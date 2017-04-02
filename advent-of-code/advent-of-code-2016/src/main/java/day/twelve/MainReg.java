package day.twelve;

import utils.Tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Pawel on 2016-12-13.
 */
public class MainReg {

    public static void main(String[] a) {
        String path = "advent-of-code-2016/src/main/java/day/twelve/data/input";
        String i = Tools.readFileAsStream(path).toString();
        Pattern p = Pattern.compile("\\{[^\\{]+?\\}");
        for(Matcher m = p.matcher(i); m.find(); m = p.matcher(i)) i = i.replaceFirst(""+p, ""+f(m.group()));
        System.out.print(f(i));
    }

    public static int f(String s) {
        int r=0;
        for(Matcher m = Pattern.compile("-?\\d+").matcher(s); m.find() && !s.contains(":\"r");) r+=new Integer(m.group());
        return r;
    }
}
