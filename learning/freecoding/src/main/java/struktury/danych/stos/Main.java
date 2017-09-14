package struktury.danych.stos;

import java.util.Stack;

/**
 * Created by Winiar on 20.08.2017.
 */
public class Main {

    //Sterta : HEAP
    //Stos  : STACK

    public static void main(String[] args) {
        Element<String> one = new Element<>("one", "one");
        Element<String> two = new Element<>("two", "two");
        Element<String> three = new Element<>("three", "three");
        Element<String> four = new Element<>("four", "four");
        Element<String> five = new Element<>("five", "five");

        ImplementationOne implementationOne = new ImplementationOne();

        implementationOne.push(one);
        implementationOne.push(two);
        implementationOne.push(three);
        implementationOne.push(four);
        implementationOne.push(five);

        implementationOne.printStos();
        System.out.println(implementationOne.pop());
        System.out.println(implementationOne.pop());
        System.out.println(implementationOne.pop());


        Stack<String> strings = new Stack<>();

    }


}
