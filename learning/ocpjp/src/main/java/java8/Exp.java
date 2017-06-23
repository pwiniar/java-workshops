package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Winiar on 22.06.2017.
 */
public class Exp {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("perte", "anna", "mike", "xenia");

        names.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });

        int i=0;
        for(String temp: names){
            System.out.println("names " + ++i + " : " + temp);
        }

        List<String> names2 = Arrays.asList("perte", "anna", "mike", "xenia");
        Comparator<String> byName = String::compareToIgnoreCase;
        names2.sort(byName);
        System.out.println(names2);


    }


}
