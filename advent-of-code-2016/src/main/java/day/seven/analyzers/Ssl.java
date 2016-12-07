package day.seven.analyzers;

import utils.Tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Pawel on 2016-12-07.
 */
public class Ssl implements Analyzer {
    @Override
    public int analyze(String path) {
        BufferedReader br = Tools.readFileAsBuffer(path);
        String line;
        int countValidSSLs = 0;

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

                if (isValidSSL(bracketed, nonBracketed))
                    countValidSSLs++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return countValidSSLs;
    }

    private boolean isValidSSL(List<String> bracketed, List<String> nonBracketed) {
        Set<String> ABAs = new HashSet<>();
        Set<String> invertedBABs = new HashSet<>();
        // find all ABAs
        for (String s : nonBracketed) {
            for (int i = 0; i <= s.length() - 3; i++) {
                String sub = s.substring(i, i + 3);
                if (sub.charAt(0) == sub.charAt(2) && sub.charAt(0) != sub.charAt(1)) {
                    ABAs.add(sub);
                }
            }
        }

        // find all BABs, but invert it as ABA
        for (String s : bracketed) {
            for (int i = 0; i <= s.length() - 3; i++) {
                String sub = s.substring(i, i + 3);
                if (sub.charAt(0) == sub.charAt(2) && sub.charAt(0) != sub.charAt(1)) {
                    invertedBABs.add("" + sub.charAt(1) + sub.charAt(0) + sub.charAt(1));
                }
            }
        }

        // check intersection of sets
        ABAs.retainAll(invertedBABs);
        if (ABAs.size() > 0) {
            return true;
        }
        return false;
    }
}
