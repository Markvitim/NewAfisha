package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryTest {
    private MovieRepository repository = new MovieRepository();
    private Movie first = new Movie();
    private Movie second = new Movie();
    private Movie third = new Movie();
    private Movie four = new Movie();
    private Movie five = new Movie();
    private Movie six = new Movie();
    private Movie seven = new Movie();
    private Movie eight = new Movie();
    private Movie nine = new Movie();
    private Movie ten = new Movie();
    private Movie eleven = new Movie();
    private Movie twelve = new Movie();
    private Movie thirteen = new Movie();

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(four);
        repository.save(five);
        repository.save(six);
        repository.save(seven);
        repository.save(eight);
        repository.save(nine);
        repository.save(ten);
        repository.save(eleven);
        repository.save(twelve);
    }


    @Test
    public void shouldSave() {
        Movie[] actual = repository.save(thirteen);
        Movie[] expected = new Movie[]{first, second, third, four, five, six, seven, eight, nine, ten,
                eleven, twelve, thirteen};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAll() {
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{twelve, eleven, ten, nine, eight, seven, six, five, four, third,
                second, first};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById() {
        repository.removeById(2);
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{twelve, eleven, ten, nine, eight, seven, six, five, four, second, first};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        Movie[] actual = repository.findById(10);
        Movie[] expected = new Movie[]{eleven};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdNull() {
        Movie[] actual = repository.findById(50);
        Movie[] expected = new Movie[]{null};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {
        Movie[] actual = repository.removeAll();
        Movie[] expected = new Movie[]{null, null, null, null, null, null, null, null, null, null, null, null};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMovieLimit() {
        Movie[] actual = repository.movieLimit();
        Movie[] expected = new Movie[]{twelve, eleven, ten, nine, eight, seven, six, five, four, third};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMovieLimitOver() {
        MovieRepository repository = new MovieRepository(30);
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(four);
        repository.save(five);
        repository.save(six);
        repository.save(seven);
        repository.save(eight);
        repository.save(nine);
        repository.save(ten);
        repository.save(eleven);
        repository.save(twelve);
        Movie[] actual = repository.movieLimit();
        Movie[] expected = new Movie[]{twelve, eleven, ten, nine, eight, seven, six, five, four,
                third, second, first};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetSetMovieLimit() {
        repository.setMovieLimit(5);
        Assertions.assertEquals(5, repository.getMovieLimit());
    }

}