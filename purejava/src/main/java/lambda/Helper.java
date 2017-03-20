package lambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Pawel on 2017-03-19.
 */
public class Helper {

    @FunctionalInterface
    public interface CheckPerson<T> {
        boolean test(T p);
    }

    //
//    public interface CheckPerson {
//        boolean test(Person p);
//    }

//    public interface Predicate<T> {
//        boolean test(T t);
//    }

    public void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    public void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        roster.forEach(p -> {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        });
    }


    public void printPersons(List<Person> roster, CheckPerson<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public void printPersonsPredicate(List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public void printPersonsPredicateNegate(List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.negate().test(p)) {
                p.printPerson();
            }
        }
    }

    public void processPersons(List<Person> roster, Predicate<Person> tester, Consumer<Person> block) {
        roster.forEach(person -> {
            if (tester.test(person)) {
                block.accept(person);
            }
        });
    }

    public void println() {
        System.out.println();
    }

    public void printText(String x) {
        System.out.println(x);
    }

    public class CheckPersonEligibleForSelectiveService implements Helper.CheckPerson<Person> {
        @Override
        public boolean test(Person p) {
            return p.getGender() == Person.Sex.MALE
                    && p.getAge() >= 15
                    && p.getAge() <= 25;
        }
    }

    public void processPersonsWithFunction(List<Person> roster, Predicate<Person> tester, Function<Person, String> mapper,
                                           Consumer<String> block) {
        roster.forEach(person -> {
            if (tester.test(person)) {
                String data = mapper.apply(person);
                block.accept(data);
            }
        });
    }

    public <X, Y> void processPersonsWithFunctionGeneric(
            Iterable<X> source,
            Predicate<X> tester,
            Function<X, Y> mapper,
            Consumer<Y> block) {
        source.forEach(X -> {
            if (tester.test(X)) {
                Y data = mapper.apply(X);
                block.accept(data);
            }
        });
    }


    public interface DoTheShit<X, Y> {
        void doTheShit(X x, Y y);
    }

    public <X, Y> void processPersonsWithFunctionGenericNext(
            Iterable<X> source,
            Predicate<X> tester,
            Function<X, Y> mapper,
            DoTheShit<X, Y> block) {
        source.forEach(X -> {
            if (tester.test(X)) {
                Y data = mapper.apply(X);
                block.doTheShit(X, data);
            }
        });
    }


}
