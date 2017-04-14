package soundsystem;

import org.springframework.stereotype.Component;

/**
 * Created by Pawel on 2017-04-12.
 */
@Component
public class StgPeppers implements CompactDisk {

    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }

    @Override
    public String toString() {
        return "StgPeppers{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }
}
