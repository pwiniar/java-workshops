package business.entities;

/**
 * Created by Winiar on 02.07.2017.
 */
public class User {

    private final String firstName;
    private final String lastName;
    private final String nationality;
    private final Integer age;


    public User(String firstName, String lastName, String nationality, Integer age) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.age = age;
    }
}
