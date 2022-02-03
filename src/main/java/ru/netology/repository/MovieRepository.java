package ru.netology.repository;

import ru.netology.domain.Movie;

public class MovieRepository {
    private Movie[] movies = new Movie[0];
    private int movieLimit = 10;

    public MovieRepository() {
    }

    public MovieRepository(int movieLimit) {
        this.movieLimit = movieLimit;
    }

    public int getMovieLimit() {
        return movieLimit;
    }

    public void setMovieLimit(int movieLimit) {
        this.movieLimit = movieLimit;
    }

    public Movie[] save(Movie movie) {
        Movie[] tmp = new Movie[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
        return movies;
    }

    public Movie[] findAll() {
        Movie[] result = new Movie[movies.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = movies[movies.length - i - 1];
        }
        return result;
    }

    public void removeById(int idToRemove) {
        Movie[] tmp = new Movie[movies.length - 1];
        int copyTo = 0;
        for (int i = 0; i < movies.length; i++) {
            if (i != idToRemove) {
                tmp[copyTo] = movies[i];
                copyTo++;
            }
        }
        movies = tmp;
    }

    public Movie[] findById(int idToFind) {
        Movie[] tmp = new Movie[1];
        for (int i = 0; i < movies.length; i++) {
            if (i == idToFind) {
                tmp[0] = movies[i];
            }
        }
        movies = tmp;
        return movies;
    }

    public Movie[] removeAll() {
        Movie[] tmp = new Movie[movies.length];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = null;
            movies = tmp;
        }
        return movies;
    }

    public Movie[] movieLimit() {
        int newLength = movieLimit;
        if (movieLimit > movies.length) {
            newLength = movies.length;
        }

        Movie[] tmp = new Movie[newLength];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = movies[movies.length - i - 1];
        }
        movies = tmp;
        return movies;
    }
}
