package struktury.danych.stos;

/**
 * Created by Winiar on 20.08.2017.
 */
public class Element<T> {

    private final String name;
    private final T value;

    public Element(String name, T value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Element{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
