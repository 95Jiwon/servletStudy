package com.korai.servletstudy02.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/api/*")
public class CorsFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("전처리");
        System.out.println("11");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String method = req.getMethod(); // HttpServletRequest안의 req를 사용하고 싶으면
        //다운캐스팅을 하여야 한다.
        System.out.println(method);

        resp.setHeader("access-control-Allow-Origin", "*");
        resp.setHeader("access-control-Allow-Methods", "GET, POST, OPTIONS");
        resp.setHeader("access-control-Allow-Headers", "Content-Type");

        if("OPTIONS".equals(method)){
            resp.setStatus(200);
            return;
        }
        chain.doFilter(request, response);
        System.out.println("22");
        System.out.println("후처리");
    }
}
