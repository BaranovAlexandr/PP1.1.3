package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.*;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService clerk = new UserServiceImpl();
        clerk.createUsersTable();
        clerk.saveUser("Alexandr", "Baranov", (byte) 23);
        clerk.saveUser("Slava", "Ukraincev", (byte) 16);
        clerk.saveUser("Ivan", "Ivanov", (byte) 40);
        clerk.saveUser("Genadiy", "Bookin", (byte) 35);
        List<User> users = clerk.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
        clerk.cleanUsersTable();
        clerk.dropUsersTable();
    }
}
