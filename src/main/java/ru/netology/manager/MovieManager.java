package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

public class MovieManager {
    private MovieRepository repository;

    public MovieManager() {
    }

    public MovieManager(MovieRepository repository) {
        this.repository = repository;
    }

    public void add(Movie movie) {
        repository.save(movie);
    }

    public Movie[] getAll() {
        Movie[] movies = repository.findAll();
        Movie[] result = new Movie[movies.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = movies[movies.length - i - 1];
        }
        return movies;
    }

    public void removeById(int idRemove) {
        repository.removeById(idRemove);
    }

    public void findByID(int idToFind) {
        repository.findById(idToFind);
    }

    public void removeAll() {
        repository.removeAll();
    }
    public int shouldSumId(){
        int result = 0;
        for (Movie movie: getAll()){
            result = result + movie.getId();
        }
        return result;
    }
}
