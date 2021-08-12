package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД
    private final String userName = "root";
    private final String password = "Salam228!";
    private final String connectionUrl = "jdbc:mysql://localhost:3306/test";

    public  Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
