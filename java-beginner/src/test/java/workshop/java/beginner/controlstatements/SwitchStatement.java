package workshop.java.beginner.controlstatements;

import workshop.java.beginner.basics.Gender;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by michal on 14.06.2016.
 */
public class SwitchStatement {

    @Test(dataProvider = "intValues")
    public void simpleSwitch(int value) {

        // there is sometimes need of chaining if-else statements like that:
        // if (value == 0) {
        //     return "zero";
        // } else if (value == 1) {
        //     return "one";
        // } else {
        //     return "other";
        // }

        // sometimes we can use switch-statement instead
        // but it is not really recommended

        switch (value) {
            case 0:
                System.out.println(value + " is zero");
                break;
            case 1:
                System.out.println(value + " is one");
                break;
            default:
                System.out.println(value + " is other");
                break;
        }

        // WARNING! do not forget about "break" in each case
    }

    @Test(dataProvider = "intValues")
    public void collapsingCases(int value) {

        // when we execute same code in two or more cases

        switch (value) {
            case 0:
            case 1:
                System.out.println(value + " is zero or one");
                break;
            default:
                System.out.println(value + " is other");
                break;
        }

    }

    @Test(dataProvider = "genderValues")
    public void switchOverEnum(Gender gender) {

        // switch-statement is most commonly used with enums

        switch (gender) {
            case FEMALE:
                System.out.println("for a girl we use " + gender.getHonorific());
                break;
            case MALE:
                System.out.println("for a man we use " + gender.getHonorific());
                break;
            default:
                System.out.println("unknown gender");
                break;
        }
    }

    @Test(dataProvider = "stringValues")
    public void stringSwitch(String value) {

        // since java 7 we can switch with strings

        switch (value) {
            case "zero":
                System.out.println("it zero");
                break;
            case "one":
                System.out.println("now it one");
                break;
            default:
                System.out.println("some oder text for " + value);
                break;
        }
    }

    @DataProvider
    public static Object[][] intValues() {
        return new Object[][]{{1}, {0}, {-3}};
    }

    @DataProvider
    public static Object[][] genderValues() {
        return new Object[][]{{Gender.MALE}, {Gender.FEMALE}, {Gender.MIXED}};
    }

    @DataProvider
    public static Object[][] stringValues() {
        return new Object[][] {{"zero"}, {"fife"}, {"one"}};
    }
}
