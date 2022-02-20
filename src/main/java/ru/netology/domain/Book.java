package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class Book extends Product {
    private String nameBook;
    private String author;

    public Book(int id, String nameProduct, int price, String nameBook, String author) {
        super(id, nameProduct, price);
        this.nameBook = nameBook;
        this.author = author;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(nameBook, book.nameBook) && Objects.equals(author, book.author);
    }
}
