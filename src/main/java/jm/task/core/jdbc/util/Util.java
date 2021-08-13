package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД
    private final String userName = "root";
    private final String password = "Salam228!";
    private final String connectionUrl = "jdbc:mysql://localhost:3306/test";

    private Connection connection;

    public Util() {
        try { Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(connectionUrl, userName, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return connection;
    }

}
