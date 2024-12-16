import java.util.*;

class Actor {
    private String name;
    private List<Movie> movies;

    public Actor(String name) {
        this.name = name;
        this.movies = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }
}

class Movie {
    private String title;
    private List<Actor> actors;

    public Movie(String title) {
        this.title = title;
        this.actors = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }
}

class MovieDatabase {
    private List<Movie> movies;
    private List<Actor> actors;

    public MovieDatabase() {
        movies = new ArrayList<>();
        actors = new ArrayList<>();
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void addActor(Actor actor) {
        actors.add(actor);
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


        //////////////////////////////////////////////////////////
        Actor actor4 = new Actor("Чуб Вадим");
        Movie movie4 = new Movie("Example Movie");

        actor4.addMovie(movie4);
        db.addActor(actor4);
        /////////////////////////////////////////////////////////


        // Задача 1
        System.out.println("Актор без фільмів: " + hasActorWithoutMovies(db));

        // Задача 2
        System.out.println("Актори, що грали з Jane Smith:");
        List<Actor> coActors = findCoActors(db, actor2);
        for (Actor actor : coActors) {
            System.out.println(actor.getName());
        }

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

    public static List<Actor> findCoActors(MovieDatabase db, Actor targetActor) {
        List<Actor> coActors = new ArrayList<>();
        List movies = db.getMovies();
        Iterator movieIterator = movies.iterator();

        while (movieIterator.hasNext()) {
            Object obj = movieIterator.next(); // Повертає Object
            Movie movie = (Movie) obj; // Приведення до Movie

            if (movie.getActors().contains(targetActor)) {
                for (Actor actor : movie.getActors()) {
                    if (!actor.equals(targetActor) && !coActors.contains(actor)) {
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

        for (Iterator<Movie> it = db.getMovies().iterator(); it.hasNext(); ) {
            Movie movie = it.next();
            if (movie.getActors().size() > maxActors) {
                maxActors = movie.getActors().size();
                movieWithMostActors = movie;
            }
        }
        return movieWithMostActors;
    }
}
