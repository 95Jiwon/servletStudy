package com.korai.servletstudy02.controller;

import com.korai.servletstudy02.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users")
public class UserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(1, "user1", "1q2w3e4r", "황지원");
        req.setAttribute("user", user);
        req.setAttribute("id", user);
        req.setAttribute("username", user.getUsername());
        req.setAttribute("password", user.getPassword());

        req.getRequestDispatcher("/user2.jsp").forward(req,resp);
    }
}
