package ru.netology.manager;


import org.junit.jupiter.api.Test;
import ru.netology.domain.*;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    Book first = new Book(1, "Книга", 200, "Тарас Бульба", "Гоголь");
    Smartphone second = new Smartphone(2, "Смартфон", 20000, "S30", "Samsung");
    Book third = new Book(3, "Книга", 250, "Война и мир", "Толстой");
    Smartphone fourth = new Smartphone(4, "Смартфон", 20000, "Redmi", "Xiaomi");
    Book fifth = new Book(5, "Книга", 220, "Мертвые души", "Гоголь");
    Smartphone sixth = new Smartphone(6, "Смартфон", 18000, "Blade 20", "ZTE");

    @Test
    void getAll() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);


        Product[] expected = new Product[]{first, second, third, fourth, fifth, sixth};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

    }


    @Test
    void add() {

        manager.add(first);
        manager.add(second);

        Product[] expected = new Product[]{first, second};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    void searchByNameProductBook() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        Product[] expected = new Product[]{first, third, fifth};
        assertArrayEquals(expected, manager.searchBy("Книга"));
    }
    @Test
    void searchByNameProductSmartphone() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        Product[] expected = new Product[]{second, fourth, sixth};
        assertArrayEquals(expected, manager.searchBy("Смартфон"));
    }

}