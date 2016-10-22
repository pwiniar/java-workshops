package workshop.java.intermediate.collections;

import org.junit.Test;
import workshop.java.intermediate.boilerplatefree.Movie;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static workshop.java.intermediate.boilerplatefree.Movie.Genre.Action;
import static workshop.java.intermediate.boilerplatefree.Movie.Genre.Adventure;
import static workshop.java.intermediate.boilerplatefree.Movie.Genre.Thriller;
import static workshop.java.intermediate.collectionsprocessing.BasicsOperations.genres;

/**
 * Created by michal on 21.10.2016.
 */
public class SpecialPurposeCollections {

    // not accept nulls
    // is not sorted, iteration order will make you cry
    @Test
    public void priorityQueue() throws Exception {
        List<String> genres = genres();

        PriorityQueue<String> priority = new PriorityQueue<>(String::compareTo);
        for (String genre : genres) {
            priority.offer(genre);
        }
        genres.sort(String::compareTo);

        int i = 0;
        for (String genre : priority) {
            System.out.println(
                    String.format("at %s:\t%s\t%s", i, genre, genres.get(i))
            );
            ++i;
        }
        assertThat(priority)
            //.containsExactlyElementsOf(genres) // it fails
                .containsExactlyInAnyOrder(genres.toArray(new String[genres.size()]));
    }

    @Test
    public void enumSet() throws Exception {
        EnumSet<Movie.Genre> genres = EnumSet.of(Action, Adventure, Thriller);
    }

    @Test
    public void enumMap() throws Exception {
        EnumMap<Movie.Genre, Movie> enumMap = new EnumMap<>(Movie.Genre.class);
    }

    // ignores implementation of equals and hashcode
    // object identity semantic, even for value objects
    @Test
    public void identityMap() throws Exception {
        IdentityHashMap<String, String> identityMap = new IdentityHashMap<>();

        identityMap.put("Java", "");
        identityMap.put("Java", "");

        assertThat(identityMap).hasSize(1);

        identityMap.put(new String("Java"), "");

        assertThat(identityMap).hasSize(2);
    }

    // if key is not referenced
    // intended for use with key objects with memory identity semantic of equality
    // will not work properly for value objects
    @Test
    public void weakMap() throws Exception {
        WeakHashMap<String, Movie> weakMap = new WeakHashMap<>();
    }
}
