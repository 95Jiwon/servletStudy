package com.korai.servletstudy02.database;

import com.korai.servletstudy02.entity.Menu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnectionTest {
    public static void main(String[] args) {
        String protocol = "jdbc:mysql"; //http와 같은 개념
        String host = "localhost";
        String port = "3308";
        String username = "root";
        String password = "1q2w3e4r!";
        String databaseName = "hanip_delivery02";

        String url = String.format("%s://%s:%s/%s", protocol, host, port, databaseName);
        // jdbc:mysql://localhost:3308/hanip_delivery02

        List<Menu> menus = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, username, password)){
            //1번째는 url(주소), 2번째는 username(유저명), 3번째는 password(비밀번호) 넣는다.
            //Connection은 데이터베이스와 연결 해주는 역할을 한다.
            //Connectoin을 하고나면 끊어줘야 한다. 객체 자체가 끝나면 자동적으로 close를 해주는 문법이다.
            PreparedStatement pstmt = connection.prepareStatement("""
SELECT    
    *
FROM
    menus""");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Menu menu = new Menu(
                        rs.getInt("menu_id"),
                        rs.getInt("restaurant_id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("description"),
                        rs.getBoolean("is_signature"),
                        rs.getBoolean("is_sold_out")
                );
                        menus.add(menu);
//                System.out.println(rs.getString("menu_id"));
//                System.out.println(rs.getString("restaurant_id"));
//                System.out.println(rs.getString("name"));
//                System.out.println(rs.getString("price"));
//                System.out.println(rs.getString("description"));
//                System.out.println(rs.getBoolean("is_signature"));
//                System.out.println(rs.getBoolean("is_sold_out"));
            }
        }catch (SQLException e){
            System.out.println("데이터베이스 연결 실패");
            e.printStackTrace();
        }
        menus.forEach(System.out::println);
    }
}
