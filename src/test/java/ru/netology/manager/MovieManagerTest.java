package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    private MovieManager manager = new MovieManager();
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
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(four);
        manager.save(five);
        manager.save(six);
        manager.save(seven);
        manager.save(eight);
        manager.save(nine);
        manager.save(ten);
        manager.save(eleven);
        manager.save(twelve);
    }


    @Test
    public void shouldSave() {
        Movie[] actual = manager.save(thirteen);
        Movie[] expected = new Movie[]{first, second, third, four, five, six, seven, eight, nine, ten,
                eleven, twelve, thirteen};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAll() {
        Movie[] actual = manager.findAll();
        Movie[] expected = new Movie[]{twelve, eleven, ten, nine, eight, seven, six, five, four, third,
                second, first};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById() {
        manager.removeById(2);
        Movie[] actual = manager.findAll();
        Movie[] expected = new Movie[]{twelve, eleven, ten, nine, eight, seven, six, five, four, second, first};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        Movie[] actual = manager.findById(10);
        Movie[] expected = new Movie[]{eleven};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdNull() {
        Movie[] actual = manager.findById(50);
        Movie[] expected = new Movie[]{null};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {
        Movie[] actual = manager.removeAll();
        Movie[] expected = new Movie[]{null, null, null, null, null, null, null, null, null, null, null, null};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMovieLimit() {
        Movie[] actual = manager.movieLimit();
        Movie[] expected = new Movie[]{twelve, eleven, ten, nine, eight, seven, six, five, four, third};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMovieLimitOver() {
        MovieManager manager = new MovieManager(30);
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(four);
        manager.save(five);
        manager.save(six);
        manager.save(seven);
        manager.save(eight);
        manager.save(nine);
        manager.save(ten);
        manager.save(eleven);
        manager.save(twelve);
        Movie[] actual = manager.movieLimit();
        Movie[] expected = new Movie[]{twelve, eleven, ten, nine, eight, seven, six, five, four,
                third, second, first};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetSetMovieLimit() {
        manager.setMovieLimit(5);
        Assertions.assertEquals(5, manager.getMovieLimit());
    }
}