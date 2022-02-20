package ru.netology.repository;


import org.junit.jupiter.api.Test;
import ru.netology.domain.*;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();


    Book first = new Book(1, "Книга", 200, "Алиса", "Керрол");
    Smartphone second = new Smartphone(2, "Смартфон", 20000, "S30", "Samsung");
    Book third = new Book(3, "Книга", 250, "Война и мир", "Толстой");
    Smartphone fourth = new Smartphone(4, "Смартфон", 15000, "Redmi", "Xiaomi");
    Book fifth = new Book(5, "Книга", 220, "Мертвые души", "Гоголь");
    Smartphone sixth = new Smartphone(6, "Смартфон", 18000, "Blade 20", "ZTE");

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