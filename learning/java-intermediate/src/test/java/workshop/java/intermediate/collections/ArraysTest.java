package workshop.java.intermediate.collections;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import workshop.java.intermediate.boilerplatefree.Person;

/**
 * Created by michal on 14.06.2016.
 */
public class ArraysTest {

    @Test
    public void basicsOfArrays() throws Exception {

        // arrays are fixed size
        // special notation
        String[] empty = new String[0];
        Assertions.assertThat(empty).isEmpty();

        // when instantiated that way all elements are nulls
        // we can not grow size of arrays
        String[] size1 = new String[1];
        Assertions.assertThat(size1).hasSize(1);

        // elements indexed by int
        // special notation
        Assertions.assertThat(size1[0]).isNull();
    }

    @Test
    public void initialisationOfArrays() throws Exception {

        // special notation for initialisation
        String[] empty = {};
        Assertions.assertThat(empty).isEmpty();

        // we can initialize values in array
        String[] size1 = {"initial value"};
        Assertions.assertThat(size1).hasSize(1);

        Assertions.assertThat(size1[0]).isEqualTo("initial value");

        size1[0] = "new value";
        Assertions.assertThat(size1[0]).isEqualTo("new value");
    }

    @Test
    public void multidimensionalArrays() throws Exception {

        String[][] twoByTwo = {
                {"row0 col0", "row0 col1"},
                {"row1 col0", "row1 col1"},
        };

        for (String[] row : twoByTwo) {
            for (String column : row) {
                System.out.print("\t" + column);
            }
            System.out.println();
        }
        Assertions.assertThat(twoByTwo).hasSize(2);
        Assertions.assertThat(twoByTwo[0]).hasSize(2);
        Assertions.assertThat(twoByTwo[1]).hasSize(2);
    }

    @Test
    public void anyType() throws Exception {
        int[] ints = {1, 2};
        double[] doubles = {1.1, 2.1};
        String[] strings = {"first", "second"};

        Person[] pets = {new Person("Bella"), new Person("Cody")};

        Assertions.assertThat(ints).hasSize(2);
        Assertions.assertThat(doubles).hasSize(2);
        Assertions.assertThat(strings).hasSize(2);
        Assertions.assertThat(pets).hasSize(2);
    }
}
