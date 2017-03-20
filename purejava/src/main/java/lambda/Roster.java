package lambda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Pawel on 2017-03-14.
 */
public class Roster {

    private static final List<Person> roster = Person.createRoster();
    private static final Helper helper = new Helper();
    private static final Predicate<Person> predicate = p ->
            p.getGender() == Person.Sex.MALE
                    && p.getAge() >= 25
                    && p.getAge() <= 26;

    private static Map<String, Consumer<Helper>> handler = new HashMap<>();

    public static void main(String[] args) {

        handler.put("printPersonsOlderThan", helper -> helper.printPersonsOlderThan(roster, 20));
        handler.put("printPersonsWithinAgeRange", helper -> helper.printPersonsWithinAgeRange(roster, 14, 30));
        handler.put("checkPersonEligibleForSelectiveService", helper -> helper.new CheckPersonEligibleForSelectiveService());


////         Approach 1: Create Methods that Search for Persons that Match One characteristic
//        helper.printText("1.Persons older than 20:");
//        handler.get("printPersonsOlderThan");
//        helper.println();

        //    // Approach 2: Create More Generalized Search Methods
//        helper.printText("2.Persons between the ages of 14 and 30:");
//        handler.get("printPersonsWithinAgeRange");
//        helper.println();

        //  // Approach 3: Specify Search Criteria Code in a Local Class
//        helper.printText("3.Persons who are eligible for Selective Service:");
//        helper.printPersons(roster, handler.get("checkPersonEligibleForSelectiveService"));

//        helper.printText("3.Persons who are eligible for Selective Service with Predicate:");
//        Predicate<Person> pp = p -> p.getGender() == Person.Sex.MALE
//                && p.getAge() >= 15
//                && p.getAge() <= 25;
//
//        helper.printPersonsPredicate(roster, pp);
//        System.out.println();
//
//         Approach 4: Specify Search Criteria Code in an Anonymous Class
//        helper.printText("4.Persons who are eligible for Selective Service (anonymous class):");
//        helper.printPersons(roster, new Helper.CheckPerson<Person>() {
//                    public boolean test(Person p) {
//                        return p.getGender() == Person.Sex.MALE
//                                && p.getAge() >= 25
//                                && p.getAge() <= 26;
//                    }
//                }
//        );
//
//        helper.printText("4. Persons who are eligible for Selective Service (anonymous class predicate):");
//        helper.printPersonsPredicate(roster, new Predicate<Person>() {
//            @Override
//            public boolean test(Person p) {
//                return p.getGender() == Person.Sex.MALE
//                        && p.getAge() >= 25
//                        && p.getAge() <= 26;
//            }
//        });
//
//
////         Approach 5: Specify Search Criteria Code with a Lambda Expression
//        helper.printText("Approach 5: Specify Search Criteria Code with a Lambda Expression");
//        helper.printPersons(roster, new Helper.CheckPerson<Person>() {
//            @Override
//            public boolean test(Person p) {
//                return p.getGender() == Person.Sex.MALE
//                        && p.getAge() >= 25
//                        && p.getAge() <= 26;
//            }
//        });
//
//        helper.printText("Approach 5: Specify Search Criteria Code with a Lambda Expression interface predicate");
//        helper.printPersonsPredicate(roster, (Person p) ->
//                p.getGender() == Person.Sex.MALE
//                        && p.getAge() >= 25
//                        && p.getAge() <= 26);
//
//
//         Approach 7: Use Lambda Expressions Throughout Your Application
//        helper.printText("Approach 7: Use Lambda Expressions Throughout Your Application");
//        helper.processPersons(roster, predicate, Person::printPerson);
//        helper.processPersonsWithFunction(roster, predicate, Person::getEmailAddress, System.out::println);
//        helper.println();
        //Approach 8: Use Generics More Extensively

//        helper.printText("Approach 8: Use Generics More Extensively");
//        helper.processPersonsWithFunctionGeneric(roster, predicate, Person::getName, System.out::println);
        //       helper.println();


        List<String> strings = Arrays.asList("adsdfsdfesE", "adsdfsdfes", "adsdfsdfes", "adsdfsdfes", "adsdfsdfes");
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.substring(1, 3).length() == 2;
            }
        };

//        helper.processPersonsWithFunctionGeneric(strings, predicate, s -> s.endsWith("s"), System.out::println);

        helper.processPersonsWithFunctionGenericNext(strings, predicate,
                (Function<String, Object>) s -> s.contains("E"), (s, o) -> {
                    System.out.println(String.format("Dostalem: %s i dalej: %s", s, o));
                }
        );


        DoTheMatn add = (a, b) -> a + b;
        DoTheMatn sub = (a, b) -> a - b;
        DoTheMatn mult = (a, b) -> a * b;

        Roster roster = new Roster();
        System.out.println(roster.doOperation(1, 2, add));
    }

    public int doOperation(int a, int b, DoTheMatn c) {
        return c.oper(a, b);
    }

    interface DoTheMatn {
        int oper(int a, int b);
    }


}
