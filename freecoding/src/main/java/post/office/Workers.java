package post.office;

/**
 * Created by Pawel on 2017-03-06.
 */
public class Workers {

    public enum Experience {
        JUNIOR, MIDDLE, SENIOR
    }

    private final String name;
    private final String profession;
    private final Experience experience;

    public Workers(String name, String profession, Experience experience) {
        this.name = name;
        this.profession = profession;
        this.experience = experience;
    }


}
