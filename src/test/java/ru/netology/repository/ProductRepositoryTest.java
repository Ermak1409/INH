package ru.netology.repository;


import org.junit.jupiter.api.Test;
import ru.netology.domain.*;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();


    private Book first = new Book(1, "Книга Тарас Бульба", 200, "Гоголь");
    private Smartphone second = new Smartphone(2, "Смартфон S30", 20000, "Samsung");
    private Book third = new Book(3, "Книга Война и мир", 250, "Толстой");
    private Smartphone fourth = new Smartphone(4, "Смартфон Redmi", 20000, "Xiaomi");
    private Book fifth = new Book(5, "Книга Мертвые души", 220, "Гоголь");
    private Smartphone sixth = new Smartphone(6, "Смартфон Blade 20", 18000, "ZTE");

    @Test
    void save2() {
        repository.save(first);
        repository.save(second);

        Product[] expected = new Product[]{first, second};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void saveAll() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);

        Product[] expected = new Product[]{first, second, third, fourth, fifth, sixth};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void saveBook() {
        repository.save(first);
        repository.save(third);
        repository.save(fourth);
        repository.save(sixth);

        Product[] expected = new Product[]{first, third, fourth, sixth};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    void saveSmartphone() {

        repository.save(second);
        repository.save(fourth);
        repository.save(sixth);

        Product[] expected = new Product[]{second, fourth, sixth};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeByIdBook() {

        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.removeById(1);
        repository.removeById(3);
        repository.removeById(5);

        Product[] expected = new Product[]{second, fourth, sixth};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    void removeById1() {

        repository.save(first);
        repository.save(second);
        repository.removeById(1);

        Product[] expected = new Product[]{second};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    void removeById2() {

        repository.save(first);
        repository.removeById(1);

        Product[] expected = new Product[]{};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }


}