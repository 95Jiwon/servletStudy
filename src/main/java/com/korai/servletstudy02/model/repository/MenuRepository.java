package com.korai.servletstudy02.model.repository;

import com.korai.servletstudy02.database.DatabaseProvider;
import com.korai.servletstudy02.entity.Menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MenuRepository implements Repository<Menu>{
    private static MenuRepository instance;

    private DatabaseProvider databaseProvider;

    public MenuRepository() {
        this.databaseProvider = DatabaseProvider.getInstance();
    }

    public static MenuRepository getInstance() {
        if (instance == null) instance = new MenuRepository();
        return instance;
    }

    @Override
    public List<Menu> findAll() {

        String sql = """
                SELECT
                    *
                FROM
                
                    menus""";

        try {
            return select(databaseProvider.getConnection(), sql, null)
                    .stream()
                    .map(Menu::new)
                    .toList();
            } catch(SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public Menu findById(int id) {
        String sql = """
                SELECT
                    *
                FROM
                    menus
                WEHRE
                    menu_id =
                """;
        try{
            Map<String, Object> row = selectOne(databaseProvider.getConnection(), sql, List.of(id));
            return new Menu(row);
        } catch (SQLExecption e) {
            e.printStackTrace();
        }
        return null;
}

public static void main(String[] args) {
    System.out.println(MenuRepository.getInstance().findAll());
    System.out.println(MenuRepository.getInstance().findById(1));
    }
}
