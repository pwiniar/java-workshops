package assertjPlayground;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Set;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.tuple;
import static org.assertj.core.util.Sets.newLinkedHashSet;

/**
 * Created by Pawel on 2017-03-08.
 */
public class PlayWithAssertJ {

    private static Set<String> JEDIS = newLinkedHashSet("Luke", "Yoda", "Obiwan");

    @Test
    public void testOne() throws Exception {

        Predicate<String> predicate = s -> JEDIS.contains(s);

        System.out.println(predicate.test("Yoda"));

//        Condition<String> jediPower = new Condition<>(predicate, "jedi power");
    }

    private final static Set<FellowshipOfTheRing> fellowshipOfTheRings = newLinkedHashSet(
            new FellowshipOfTheRing("Boromir", 37, Race.MAN),
//            new FellowshipOfTheRing("Gandalf", 1001, Race.WIZARD),
//            new FellowshipOfTheRing("Frodo", 41, Race.HOBBIT),
            new FellowshipOfTheRing("Sam", 32, Race.HOBBIT),
//            new FellowshipOfTheRing("Pippin", 18, Race.HOBBIT),
//            new FellowshipOfTheRing("Merry", 36, Race.HOBBIT),
            new FellowshipOfTheRing("Legolas", 1002, Race.ELF)
    );

    @Test
    public void test2() throws Exception {

        Assertions.assertThat(fellowshipOfTheRings).extracting("name", "age", "race")
                .contains(tuple("Boromir", 37, Race.MAN),
                        tuple("Sam", 32, Race.HOBBIT),
                        tuple("Legolas", 1002, Race.ELF));


    }


}