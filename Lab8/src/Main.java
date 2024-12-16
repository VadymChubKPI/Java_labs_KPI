import java.util.*;

class Actor {
    private String name;
    private Set<Movie> movies;

    public Actor(String name) {
        this.name = name;
        this.movies = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }
}

class Movie {
    private String title;
    private Set<Actor> actors;

    public Movie(String title) {
        this.title = title;
        this.actors = new HashSet<>();
    }

    public String getTitle() {
        return title;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }
}

class MovieDatabase {
    private Set<Movie> movies;
    private Set<Actor> actors;
    private Map<String, Movie> movieMap; // Карта для пошуку фільмів за назвою

    public MovieDatabase() {
        movies = new HashSet<>();
        actors = new HashSet<>();
        movieMap = new HashMap<>();
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
        movieMap.put(movie.getTitle(), movie);
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public Movie findMovieByTitle(String title) {
        return movieMap.get(title);
    }
}

public class Main {
    public static void main(String[] args) {
        MovieDatabase db = new MovieDatabase();

        // Створюємо акторів
        Actor actor1 = new Actor("John Doe");
        Actor actor2 = new Actor("Jane Smith");
        Actor actor3 = new Actor("Tom Brown");

        // Створюємо фільми
        Movie movie1 = new Movie("Action Movie");
        Movie movie2 = new Movie("Drama Movie");

        // Додаємо акторів до фільмів
        movie1.addActor(actor1);
        movie1.addActor(actor2);
        movie1.addActor(actor3);

        movie2.addActor(actor2);
        movie2.addActor(actor3);

        // Додаємо фільми до акторів
        actor1.addMovie(movie1);
        actor2.addMovie(movie1);
        actor2.addMovie(movie2);
        actor3.addMovie(movie2);

        // Додаємо до бази даних
        db.addMovie(movie1);
        db.addMovie(movie2);
        db.addActor(actor1);
        db.addActor(actor2);
        db.addActor(actor3);

        // Використання Map
        String[] moviesList = {"Spider-Man 1", "Spider-Man 2", "Drama Movie", "Action Movie"};

        for (String movie : moviesList) {
            Movie searchedMovie = db.findMovieByTitle(movie);
            System.out.println("Фільм: " + movie + (searchedMovie != null ? "\t\033[32mЗнайдено\033[0m" : "\t\033[31mНе Знайдено\033[0m"));
        }
        System.out.println("-".repeat(50));

        // Задача 1
        System.out.println("Актор без фільмів: " + hasActorWithoutMovies(db));
        System.out.println("-".repeat(50));

        // Задача 2
        System.out.println("Актори, що грали з Jane Smith:");
        Set<Actor> coActors = findCoActors(db, actor2);
        for (Actor actor : coActors) {
            System.out.println(actor.getName());
        }
        System.out.println("-".repeat(50));


        // Задача 3
        Movie mostActorsMovie = findMovieWithMostActors(db);
        System.out.println("Фільм із найбільшою кількістю акторів: " + mostActorsMovie.getTitle());
    }

    public static String hasActorWithoutMovies(MovieDatabase db) {
        for (Actor actor : db.getActors()) {
            if (actor.getMovies().isEmpty()) {
                return actor.getName();
            }
        }
        return "None";
    }

    public static Set<Actor> findCoActors(MovieDatabase db, Actor targetActor) {
        Set<Actor> coActors = new HashSet<>();
        for (Movie movie : db.getMovies()) {
            if (movie.getActors().contains(targetActor)) {
                for (Actor actor : movie.getActors()) {
                    if (!actor.equals(targetActor)) {
                        coActors.add(actor);
                    }
                }
            }
        }
        return coActors;
    }

    public static Movie findMovieWithMostActors(MovieDatabase db) {
        Movie movieWithMostActors = null;
        int maxActors = 0;

        for (Movie movie : db.getMovies()) {
            if (movie.getActors().size() > maxActors) {
                maxActors = movie.getActors().size();
                movieWithMostActors = movie;
            }
        }
        return movieWithMostActors;
    }
}
