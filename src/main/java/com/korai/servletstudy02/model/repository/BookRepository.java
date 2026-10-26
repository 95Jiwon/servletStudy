package com.korai.servletstudy02.model.repository;

import com.korai.servletstudy02.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private static BookRepository instance;
    private int lastId;
    private List<Book> books;

    public BookRepository() {
        lastId = 1;
        books = new ArrayList<>();
    }

    public static BookRepository getInstance() {
        if (instance == null) {
            instance = new BookRepository();
        }
        return instance;
    }

    public void insert(Book book) {
        book.setId(lastId++);
        books.add(book);
    }

    public Book findByBookName(String bookname) {
        for (Book book : books) {
            if (book.getBookName().equals(bookname)) {
                return book;
            }
        }
        return null;
    }

    public Book findById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public List<Book> findAll() {
        return books.stream().map(book -> new Book(book)).toList();
    }
}

