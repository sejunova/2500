package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.Movie;
import academy.pocu.comp2500.lab10.pocuflix.NotFoundResult;
import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

import java.util.ArrayList;

public class MovieStore implements IRequestHandler {
    private ArrayList<Movie> movies = new ArrayList<>();

    public void add(Movie movie) {
        this.movies.add(movie);
    }

    public boolean remove(int index) {
        if (0 <= index && index < this.movies.size()) {
            this.movies.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public ResultBase handle(Request request) {
        for (Movie movie : movies) {
            if (movie.getTitle().equals(request.getTitle())) {
                return new OkResult(movie);
            }
        }
        return new NotFoundResult();
    }
}
