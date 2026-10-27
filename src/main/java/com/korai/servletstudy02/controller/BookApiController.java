package com.korai.servletstudy02.controller;

import com.korai.servletstudy02.exception.DuplicatedException;
import com.korai.servletstudy02.model.Book;
import com.korai.servletstudy02.model.service.BookService;
import tools.jackson.databind.ObjectMapper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class BookApiController extends HttpServlet {
    private BookService bookService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        bookService = BookService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        ObjectMapper objectMapper = new ObjectMapper();
        Book book = objectMapper.readValue(req.getInputStream(), Book.class);
        System.out.println("사용자 요청 들어옴");
        System.out.println(book);

        try {
            bookService.register(book);
            resp.setContentType("applicatoin/json");
            resp.setCharacterEncoding("UTF-8");
            resp.setStatus(200);
            resp.getWriter().println(objectMapper.writeValueAsString(Map.of(
                    "message", "사용자 등록 성공"
            )));
        } catch (DuplicatedException e){
        resp.setContentType("applicatoin/json");
        resp.setCharacterEncoding("UTF-8");
        resp.setStatus(400);
        resp.getWriter().println(objectMapper.writeValueAsString(Map.of(
                "message", e.getMessage()
        )));
            return;
        }
    }
}
