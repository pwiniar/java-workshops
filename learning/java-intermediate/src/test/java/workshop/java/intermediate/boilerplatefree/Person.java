package workshop.java.intermediate.boilerplatefree;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.Optional;

/**
 * Created by michal on 21.10.2016.
 */
@Value
@AllArgsConstructor
public class Person {

    private final String name;
    private final String involvement;

    public Person(String name) {
        this.name = name;
        involvement = null;
    }

    public Optional<String> getInvolvement() {
        return Optional.ofNullable(involvement);
    }
}
