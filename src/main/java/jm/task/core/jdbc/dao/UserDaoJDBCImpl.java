package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try {
            Util util = new Util();
            Statement statement = util.getConnection().createStatement();
            statement.executeUpdate("CREATE TABLE  if not exists U1 (id BIGINT not null auto_increment," +
                    " name VARCHAR(30), lastname VARCHAR(30), age TINYINT UNSIGNED, primary key (id))");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void dropUsersTable() {
        try {
            Util util = new Util();
            Statement statement = util.getConnection().createStatement();
            statement.executeUpdate("DROP table if exists U1");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            Util util = new Util();
            PreparedStatement preparedStatement = util.getConnection()
                    .prepareStatement("insert into U1 (name, lastname, age) VALUES (?,?,?)");
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            System.out.printf("User с именем – %s добавлен в базу данных\n", name);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void removeUserById(long id) {
        try {
            Util util = new Util();
            PreparedStatement preparedStatement = util.getConnection()
                    .prepareStatement("DELETE FROM U1 WHERE `ID` = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            Util util = new Util();
            Statement statement = util.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from U1");
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastname"));
                user.setAge(resultSet.getByte("age"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public void cleanUsersTable() {
        try {Util util = new Util();
            Statement statement = util.getConnection().createStatement();
            statement.executeUpdate("truncate U1");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
