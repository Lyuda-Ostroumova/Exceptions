package ru.netology.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.exceptions.exception.NotFoundException;
import ru.netology.exceptions.products.Book;
import ru.netology.exceptions.products.Product;
import ru.netology.exceptions.products.TShirt;

import java.io.UncheckedIOException;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    Repository repository = new Repository();
    Product one = new Book(1, "Гарри Поттер и Философский камень", 674, "Джоан Роулинг");
    Product two = new Book(2, "Гарри Поттер и Тайная комната", 700, "Джоан Роулинг");
    Product three = new Book(3, "Гарри Поттер и Орден феникса", 800, "Джоан Роулинг");
    Product four = new TShirt(6, "Футболка женская", 850, "Красная", 42);
    Product five = new TShirt(12, "Футболка мужская", 800, "Желтая", 50);

    @BeforeEach
    public void setUp() {
        repository.add(one);
        repository.add(two);
        repository.add(three);
        repository.add(four);
        repository.add(five);
    }

    @Test
    public void shouldRemoveByIdIfExists() {
        int idToRemove = 6;
        repository.removeById(idToRemove);

        Product[] expected = new Product[]{one, two, three, five};
        Product[] actual = repository.getAll();

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldAssertThrows() {

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(7);
        });


    }
}
