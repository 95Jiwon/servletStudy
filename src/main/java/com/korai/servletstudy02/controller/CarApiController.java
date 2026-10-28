package com.korai.servletstudy02.controller;

import com.korai.servletstudy02.model.Car;
import tools.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/api/cars")
public class CarApiController extends HttpServlet {
    public static final List<Car> cars = new ArrayList<>();

//    static{
//        cars.add(new Car(1, "모델명1", "색상1", 1000));
//        cars.add(new Car(2, "모델명2", "색상2", 1000));
//        cars.add(new Car(3, "모델명3", "색상3", 1000));
//    }


    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");

        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(cars);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");

        ObjectMapper om = new ObjectMapper();
        Car c = om.readValue(req.getInputStream(), Car.class);

        c.setId(cars.size() +1);
        cars.add(c);

        resp.setStatus(HttpServletResponse.SC_OK);
        System.out.println("등록된 차" + c);
    }
}
