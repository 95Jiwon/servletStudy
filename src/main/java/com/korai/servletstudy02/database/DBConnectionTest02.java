package com.korai.servletstudy02.database;

import com.korai.servletstudy02.entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnectionTest02 {
    public static void main(String[] args) {
        String protocol = "jdbc:mysql"; //http와 같은 개념
        String host = "localhost";
        String port = "3308";
        String username = "root";
        String password = "1q2w3e4r!";
        String databaseName = "hanip_delivery02";

        String url = String.format("%s://%s:%s/%s", protocol, host, port, databaseName);

        List<Customer> customers = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection(url, username, password)){
            PreparedStatement pstmt = connection.prepareStatement("""
SELECT    
    *
FROM
    customers
    """);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Customer customer = new Customer(
                    rs.getInt("customer_id"),
                    rs.getString("name"),
                    rs.getString("phone"),
                    rs.getString("email"),
                    rs.getString("birth_date"),
                    rs.getString("district"),
                    rs.getString("address"),
                    rs.getString("grade"),
                    rs.getBoolean("marketing_agreed"),
                    rs.getString("joined_at")
                );
                customers.add(customer);
            }
        }catch (SQLException e){
            System.out.println("데이터베이스 연결 실패");
            e.printStackTrace();
        }
            customers.forEach(System.out::println);
    }
}
