package com.korai.servletstudy02.controller;

import com.korai.servletstudy02.model.Book;
import com.korai.servletstudy02.model.User;
import com.korai.servletstudy02.model.service.BookService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book/list")
public class BookListController extends HttpServlet {

    private BookService bookService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        bookService = BookService.getInstance();
        bookService.register(new Book(0, "book1", 10000));
        bookService.register(new Book(0, "book2", 20000));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("bookList", bookService.getBookAll());
        req.getRequestDispatcher("/WEB-INF/views/book-list.jsp").forward(req,resp);
    }
}
