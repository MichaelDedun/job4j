package ru.job4j.tracker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlTracker implements Store {
    private Connection connection;

    @Override
    public void init() {
        try {
            String url = "jdbc:postgresql://localhost:5432/tracker";
            String username = "postgres";
            String password = "123321";
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Item add(Item item) {
        try (final PreparedStatement statement = this.connection.prepareStatement("INSERT INTO item (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.execute();
            return item;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean replace(String id, Item item) {
        boolean result = true;
        try (final PreparedStatement statement = this.connection.prepareStatement("UPDATE item SET name = \'" + item.getName() + "\'" + "WHERE id = \'" + id + "\'")) {
            result = checkQuery(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = true;
        try (final PreparedStatement statement = this.connection.prepareStatement("DELETE FROM item WHERE id = \'" + id + "\'")) {
            result = checkQuery(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        try (final PreparedStatement statement = this.connection.prepareStatement("select * FROM item")) {
            ResultSet resultSet = statement.executeQuery();
            createResultList(resultSet, result);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        try (final PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM item WHERE name = \'" + key + "\'")) {
            ResultSet resultSet = statement.executeQuery();
            createResultList(resultSet, result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Item findById(String id) {
        try (final PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM item WHERE id = " + id + ";")) {
            ResultSet resultSet = statement.executeQuery();
            Item result = null;
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Item item = new Item(name);
                item.setId(id);
                result = item;
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Item> createResultList(ResultSet set, List<Item> items) throws SQLException {
        while (set.next()) {
            String id = set.getString("id");
            String name = set.getString("name");
            Item item = new Item(name);
            item.setId(id);
            items.add(item);
        }
        return items;
    }

    private boolean checkQuery(PreparedStatement statement) throws SQLException {
        int row = statement.executeUpdate();
        return row != 0;
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

}
