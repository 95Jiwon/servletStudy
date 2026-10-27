package com.korai.servletstudy02.model.service;

import com.korai.servletstudy02.exception.DuplicatedException;
import com.korai.servletstudy02.model.Book;
import com.korai.servletstudy02.model.repository.BookRepository;

import java.util.List;

public class BookService {
    private static BookService instance;
    private BookRepository bookRepository;

    private BookService(BookRepository bookRepository) {this.bookRepository = bookRepository;
    }

    public static BookService getInstance() {
        if( instance == null){
            instance = new BookService(BookRepository.getInstance());
        }
        return instance;
    }

    public void register(Book book) throws DuplicatedException {
        if(isDuplicatedBookname(book.getBookName())){
            throw new DuplicatedException("이미 존재하는 책 입니다.");
        }
        bookRepository.insert(book);
    }

    public boolean isDuplicatedBookname(String bookname) {
        return bookRepository.findByBookName(bookname) != null;
    }

    public List<Book> getBookAll() {
        return bookRepository.findAll();
    }
}
