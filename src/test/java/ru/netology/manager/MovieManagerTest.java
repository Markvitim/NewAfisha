package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;


@ExtendWith(MockitoExtension.class)
class MovieManagerTest {
    @Mock
    private MovieRepository repository = Mockito.mock(MovieRepository.class);
    @InjectMocks
    private MovieManager manager = new MovieManager(repository);
    private Movie first = new Movie(0, "url", "name", "genre", true);
    private Movie second = new Movie(1, "url", "name", "genre", true);
    private Movie third = new Movie(2, "url", "name", "genre", true);


    @Test
    public void add() {

    }

    @Test
    public void getAll() {
        Movie[] returned = {first, second, third};
        Mockito.doReturn(returned).when(repository).findAll();

        Assertions.assertEquals(3, manager.shouldSumId());
        Mockito.verify(repository).findAll();
    }

    @Test
    public void removeById() {
    }

    @Test
    public void findByID() {
    }

    @Test
    public void removeAll() {
    }

    @Test
    public void movieLimit() {
    }
}