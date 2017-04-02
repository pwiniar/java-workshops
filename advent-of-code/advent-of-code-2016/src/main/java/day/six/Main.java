package day.six;

import utils.Tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Pawel on 2016-12-06.
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();

        List<Character> index0 = new ArrayList<>();
        List<Character> index1 = new ArrayList<>();
        List<Character> index2 = new ArrayList<>();
        List<Character> index3 = new ArrayList<>();
        List<Character> index4 = new ArrayList<>();
        List<Character> index5 = new ArrayList<>();
        List<Character> index6 = new ArrayList<>();
        List<Character> index7 = new ArrayList<>();

        Tools.readFileAsStream("advent-of-code-2016/src/main/java/day/six/input/input")
                .forEach(s -> {
                    index0.add(s.trim().charAt(0));
                    index1.add(s.trim().charAt(1));
                    index2.add(s.trim().charAt(2));
                    index3.add(s.trim().charAt(3));
                    index4.add(s.trim().charAt(4));
                    index5.add(s.trim().charAt(5));
                    index6.add(s.trim().charAt(6));
                    index7.add(s.trim().charAt(7));
                });

        System.out.print(main.analyzeLowestRepetition(index0));
        System.out.print(main.analyzeLowestRepetition(index1));
        System.out.print(main.analyzeLowestRepetition(index2));
        System.out.print(main.analyzeLowestRepetition(index3));
        System.out.print(main.analyzeLowestRepetition(index4));
        System.out.print(main.analyzeLowestRepetition(index5));
        System.out.print(main.analyzeLowestRepetition(index6));
        System.out.print(main.analyzeLowestRepetition(index7));
    }

    public Character analyzeHighestRepetition(List<Character> list) {
        Map<Character, Integer> integerMap = new HashMap<>();
        Character letter = null;
        Integer value = -1;

        for (Character character : list) {
            if (integerMap.keySet().contains(character)) {
                integerMap.put(character, integerMap.get(character) + 1);
            } else {
                integerMap.put(character, 1);
            }
        }

        for (Character character : integerMap.keySet()) {
            if (integerMap.get(character) > value) {
                value = integerMap.get(character);
                letter = character;
            }
        }

        return letter;
    }

    public Character analyzeLowestRepetition(List<Character> list) {
        Map<Character, Integer> integerMap = new HashMap<>();
        Character letter = null;
        Integer value = 500;

        for (Character character : list) {
            if (integerMap.keySet().contains(character)) {
                integerMap.put(character, integerMap.get(character) + 1);
            } else {
                integerMap.put(character, 1);
            }
        }

        for (Character character : integerMap.keySet()) {
            if (integerMap.get(character) < value) {
                value = integerMap.get(character);
                letter = character;
            }
        }

        return letter;
    }
}
