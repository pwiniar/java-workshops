package workshop.java.intermediate.boilerplatefree;

import java.net.URI;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Year;
import java.util.EnumSet;
import java.util.List;

/**
 * Created by michal on 21.10.2016.
 */
public class Movie {

    private final String imdbID;
    private final String title;
    private final Year year;
    private final String rated;
    private final LocalDate released;
    private final Duration runtime;
    private final EnumSet<Genre> genre;
    private final List<Person> director;
    private final List<Person> writer;
    private final List<Person> actors;
    private final String plot;
    private final String language;
    private final String country;
    private final String awards;
    private final URI poster;
    private final Double metascore;
    private final Double imdbRating;
    private final Double imdbVotes;

    public Movie(String imdbID, String title, Year year, String rated, LocalDate released, Duration runtime, EnumSet<Genre> genre, List<Person> director, List<Person> writer, List<Person> actors, String plot, String language, String country, String awards, URI poster, Double metascore, Double imdbRating, Double imdbVotes) {
        this.imdbID = imdbID;
        this.title = title;
        this.year = year;
        this.rated = rated;
        this.released = released;
        this.runtime = runtime;
        this.genre = genre;
        this.director = director;
        this.writer = writer;
        this.actors = actors;
        this.plot = plot;
        this.language = language;
        this.country = country;
        this.awards = awards;
        this.poster = poster;
        this.metascore = metascore;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
    }

    public enum Genre {
        Action,
        Biography,
        Animated,
        Adventure,
        ChickFlicks,
        Comedy,
        Detective,
        Mystery,
        Children,
        Animation,
        Family,
        Gangster,
        Disaster,
        Classic,
        Drama,
        Fantasy,
        Cult,
        Epics,
        History,
        FilmNoir,
        Documentary,
        Horror,
        Guy,
        Serial,
        Musicals,
        Dance,
        Melodramas,
        Sexual,
        Erotic,
        ScienceFiction,
        Road,
        Silent,
        WarAntiWar,
        Romance,
        Westerns,
        Sports,
        Supernatural,
        Thriller;
    }
}
