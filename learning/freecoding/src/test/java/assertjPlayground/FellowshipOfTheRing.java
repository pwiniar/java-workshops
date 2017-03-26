package assertjPlayground;

/**
 * Created by Pawel on 2017-03-08.
 */
public class FellowshipOfTheRing {
    private final String name;
    private final int age;
    private final Race race;

    public FellowshipOfTheRing(String name, int age, Race race) {
        this.name = name;
        this.age = age;
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Race getRace() {
        return race;
    }
}
