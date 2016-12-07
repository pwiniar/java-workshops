package day.seven.analyzers;

import utils.Tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pawel on 2016-12-07.
 */

public class Tls implements Analyzer {

    @Override
    public int analyze(String path) {
        BufferedReader br = Tools.readFileAsBuffer(path);
        String line;
        int countValidIPs = 0;

        try {
            while ((line = br.readLine()) != null) {
                List<String> bracketed = new ArrayList<>();
                List<String> nonBracketed = new ArrayList<>();

                line += "\0"; // add a space at the end to signify end of line
                String sofar = "";
                for (char ch : line.toCharArray()) {
                    sofar += ch;
                    if (ch == '[' || ch == '\0') {
                        nonBracketed.add(sofar.substring(0, sofar.length() - 1));
                        sofar = "";
                    }
                    if (ch == ']') {
                        bracketed.add(sofar.substring(0, sofar.length() - 1));
                        sofar = "";
                    }
                }

                if (countABBA(bracketed) == 0 && countABBA(nonBracketed) != 0)
                    countValidIPs++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return countValidIPs;
    }

    private int countABBA(List<String> strings) {
        int count = 0;
        for (String s : strings) {
            for (int i = 0; i <= s.length() - 4; i++) {
                if (isABBA(s.substring(i, i + 4))) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    // checks if the given 4 letter string is valid ABBA
    private boolean isABBA(String s) {
        if (s.length() != 4) {
            System.out.println("error");
            return false;
        }
        if (s.charAt(0) != s.charAt(1) && s.charAt(0) == s.charAt(3) && s.charAt(1) == s.charAt(2)) {
            return true;
        }
        return false;
    }
}
