package com.korai.servletstudy02.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("book/list")
public class BookListController extends HttpServlet {
    private BookService bookService;

    public init(ServletConfig config) throws ServletException {
        bookService = BookSerivce.GetInstance();
    }
}
