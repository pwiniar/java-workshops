package workshop.java.intermediate.boilerplatefree;

import java.util.Optional;

/**
 * Created by michal on 21.10.2016.
 */
public class Person {

    private final String name;
    private final String involvement;

    public Person(String name) {
        this.name = name;
        this.involvement = null;
    }

    public Person(String name, String involvement) {
        this.name = name;
        this.involvement = involvement;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getInvolvement() {
        return Optional.ofNullable(involvement);
    }
}
