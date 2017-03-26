package lambda;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pawel on 2017-03-14.
 */

@AllArgsConstructor
@Value(staticConstructor = "of")
public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public int getAge() {
        return LocalDate.now().getYear() - birthday.getYear();
    }

    public void printPerson() {
        System.out.format("My name is %s, and I am %s. I am %d " +
                "years old and my email is %s", name, gender.name(), LocalDate.now().getYear() -
                birthday.getYear(), emailAddress + "\n");
    }

    public static List<Person> createRoster() {

        List<Person> roster = new ArrayList<>();
        roster.add(
                new Person(
                        "Fred",
                        IsoChronology.INSTANCE.date(1980, 6, 20),
                        Person.Sex.MALE,
                        "fred@example.com"));
        roster.add(
                new Person(
                        "Jane",
                        IsoChronology.INSTANCE.date(1990, 7, 15),
                        Person.Sex.FEMALE, "jane@example.com"));
        roster.add(
                new Person(
                        "George",
                        IsoChronology.INSTANCE.date(1991, 8, 13),
                        Person.Sex.MALE, "george@example.com"));
        roster.add(
                new Person(
                        "Bob",
                        IsoChronology.INSTANCE.date(2000, 9, 12),
                        Person.Sex.MALE, "bob@example.com"));

        return roster;
    }
}
