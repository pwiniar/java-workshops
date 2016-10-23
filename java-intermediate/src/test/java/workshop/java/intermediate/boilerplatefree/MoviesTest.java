package workshop.java.intermediate.boilerplatefree;

import lombok.val;
import org.junit.Test;

import java.net.URI;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Year;
import java.util.EnumSet;
import java.util.Optional;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static workshop.java.intermediate.boilerplatefree.Movie.Genre.*;

/**
 * Created by michal on 21.10.2016.
 */
public class MoviesTest {

    @Test
    public void buildMovie() throws Exception {

        Movie movie = Movie.builder()
                .imdbID("tt1320253")
                .title("The Expendables")
                .year(Year.of(2010))
                .rated("R")
                .released(LocalDate.parse("2010-08-13"))
                .runtime(Duration.parse("PT103M"))
                .genre(EnumSet.of(Action, Adventure, Thriller))
                .director(singletonList(new Person("Sylvester Stallone")))
                .writer(asList(new Person("Dave Callaham", "screenplay"), new Person("Sylvester Stallone", "screenplay"), new Person("Dave Callaham", "story")))
                .actors(asList(new Person("Sylvester Stallone"), new Person("Jason Statham"), new Person("Jet Li, Dolph Lundgren")))
                .plot("A CIA operative hires a team of mercenaries to eliminate a Latin dictator and a renegade CIA agent.")
                .language("English, Spanish")
                .country("USA")
                .awards("3 wins & 5 nominations.")
                .poster(URI.create("https://images-na.ssl-images-amazon.com/images/M/MV5BNTUwODQyNjM0NF5BMl5BanBnXkFtZTcwNDMwMTU1Mw@@._V1_SX300.jpg"))
                .metascore(45.)
                .imdbRating(6.5)
                .imdbVotes(272846.)
                .build();

        assertThat(movie)
                .isNotNull();
    }

    // ObjectMother + (TestData)Builder test patterns
    // make tests extremely simple and expressive
    @Test
    public void shouldPresentDefaultLabelForNotRatedMovie() throws Exception {
        Movie notRated = ExampleMovies.tt0266697()
                .rated(null)
                .build();

        // fancy logic under test
        String rateLabel = Optional.ofNullable(notRated.getRated())
                .orElse("[rate it as first]");

        assertThat(notRated.getRated())
                .isNull();
        assertThat(rateLabel)
                .isNotNull()
                .isEqualTo("[rate it as first]");
    }
}
