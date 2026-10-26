package com.korai.servletstudy02.model.service;

import com.korai.servletstudy02.exception.DuplicatedException;
import com.korai.servletstudy02.model.User;
import com.korai.servletstudy02.model.repository.BookRepository;
import com.korai.servletstudy02.model.repository.UserRepository;

import java.util.List;

public class BookService {
    private static BookService instance;
    private BookRepository BookRepository;

    private BookService(BookRepository bookRepository) {
        this.BookRepository = bookRepository;
    }

    public static BookService getInstance() {
        if( instance == null){
            instance = new BookService(BookRepository.getInstance());
        }
        return instance;
    }

    public void register(User user) throws DuplicatedException {
        if(isDuplicatedUsername(user.getUsername())){
            throw new DuplicatedException("이미 존재하는 사용자이름 입니다.");
        }
        userRepository.insert(user);
    }

    public boolean isDuplicatedUsername(String username) {
        return userRepository.findByUsername(username) != null;
    }

    public List<User> getUserAll() {
        return userRepository.findAll();
    }
}
