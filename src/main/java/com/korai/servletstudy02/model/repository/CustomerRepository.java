package com.korai.servletstudy02.model.repository;

import com.korai.servletstudy02.database.DatabaseProvider;
import com.korai.servletstudy02.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepository {
}

public Customer findById2(int id) {
    String sql = """
            select * from customers where customer_id = ? and name =?
            """;

    try (Connection conn = DatabaseProvider.getInstance().getConnection()) {
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Customer(
                      rs.getInt(1),
                      rs.getString(2),
                      rs.getString(3),
                      rs.getString(4),
                      rs.getString(5),
                      rs.getString(6),
                      rs.getString(7),
                      rs.getString(8),
                      rs.getInt(9),
                      rs.getString(10)

                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}