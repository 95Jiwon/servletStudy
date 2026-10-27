package com.korai.servletstudy02.controller;

import com.korai.servletstudy02.model.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Book book = new Book(1, "book1", 10000);
    req.setAttribute("id", book);
    req.setAttribute("bookName", book.getBookName());
    req.setAttribute("price", book.getPrice());
    }
}
