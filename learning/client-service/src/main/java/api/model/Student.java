package api.model;

/**
 * Created by Pawel on 2017-04-26.
 */
public class Student {

    private final Integer age;
    private final String name;
    private final Integer id;

    public Student(Integer age, String name, Integer id) {
        this.age = age;
        this.name = name;
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }
}
