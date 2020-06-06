package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {
    private Connection connection;

    public SqlTracker() {
    }

    public SqlTracker(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Item add(Item item) {
        try (final PreparedStatement statement = this.connection.prepareStatement("INSERT INTO item (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.executeUpdate();
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    item.setId(resultSet.getString(1));
                }
                return item;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean replace(String id, Item item) {
        boolean result = true;
        try (final PreparedStatement statement = this.connection.prepareStatement("UPDATE item SET name = ? WHERE id = ?")) {
            statement.setString(1, item.getName());
            statement.setInt(2, Integer.parseInt(id));
            result = checkQuery(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = true;
        try (final PreparedStatement statement = this.connection.prepareStatement("DELETE FROM item WHERE id = ?")) {
            statement.setInt(1, Integer.parseInt(id));
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
            try (ResultSet resultSet = statement.executeQuery()) {
                createResultList(resultSet, result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        try (final PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM item WHERE name = ?")) {
            statement.setString(1, key);
            try (ResultSet resultSet = statement.executeQuery()) {
                createResultList(resultSet, result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Item findById(String id) {
        try (final PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM item WHERE id = ?")) {
            statement.setInt(1, Integer.parseInt(id));
            Item result = null;
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    Item item = new Item(name);
                    item.setId(id);
                    result = item;
                }
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
