package struktury.danych.stos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Winiar on 20.08.2017.
 */
public class ImplementationOne implements Stos {

    private final List<Element> elements = new ArrayList<>();
    private Element firstElement;

    public void push(Element e) {
        firstElement = e;
        elements.add(e);
    }

    public Element pop() {
        Element tmp = firstElement;
        int i = elements.lastIndexOf(firstElement);
        elements.remove(i);
        firstElement = elements.get(i - 1);
        return tmp;
    }

    public void printStos() {
        elements.forEach(System.out::println);
    }

}
