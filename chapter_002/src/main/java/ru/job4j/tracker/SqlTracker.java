package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {
    private Connection connection;

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
        try (final PreparedStatement statement = this.connection.prepareStatement("insert into item (name) values (?)")) {
            statement.setString(1, item.getName());
            statement.executeUpdate();
            try (ResultSet key = statement.getGeneratedKeys()) {
                while (key.next()) {
                    item.setId(key.getString("id"));
                    item.setName(key.getString("name"));
                }
            }
            return item;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean replace(String id, Item item) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<Item> findAll() {
        return null;
    }

    @Override
    public List<Item> findByName(String key) {
        return null;
    }

    @Override
    public Item findById(String id) {
        return null;
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

}
