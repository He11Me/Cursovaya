package ru.mai.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBase {

    private static DataBase instance;

    private final DatabaseProperties properties = PropertiesFactory.getProperties();

    public DataBase() {
        init();
    }

    public synchronized static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }

    public List<Map<String, String>> selectAll(String table, String... columnNames) {
        List<Map<String, String>> result = new ArrayList<>();

        String sql = """
                select %s
                from cursach.%s
                """;
        String winners = String.join(", ", columnNames);
        String select = String.format(sql, winners, table);

        try(Connection connection = connect();
            Statement statement = connection.createStatement()) {
            ResultSet set = statement.executeQuery(select);
            while (set.next()) {
                Map<String, String> fields = new HashMap<>();
                for (String columnName : columnNames) {
                    fields.put(columnName, set.getString(columnName));
                }
                result.add(fields);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public void init() {
        createSchema();
        createTableGame();
    }

    private void createSchema() {
        String sql = """
                create schema if not exists cursach;
                """;
        execute(sql);
    }

    public void execute(String sql) {
        try (Connection connection = connect();
             Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void createTableGame() {

        String sql = """
                create table if not exists cursach.games (
                    numberId serial PRIMARY KEY,
                    gameWinner Text not null
                )
                """;
        execute(sql);
    }

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(
                properties.getUrl(),
                properties.getLogin(),
                properties.getPassword()
        );
    }
}

