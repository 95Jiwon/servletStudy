package com.korai.servletstudy02.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectionTest03 {
    public static void main(String[] args) {

        try (Connection conn = DatabaseProvider.getInstance().getConnection()) {
            String sql = """
                    SELECT 
                        *
                    FROM
                        customers""";
            PreparedStatement pstmt = conn.prepareStatement();
            ResultSet rs = pstmt.executeQuery();
        } catch (SQLException e) {

        }
    }
}
