package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД

    private static final String URL = "jdbc:mysql://localhost:3306/new_schema";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection OK");
        } catch (SQLException e) {
            System.out.println("Connection FAILED");
            e.printStackTrace();
        }
    }

    private Util() {

    }

    public static Connection getConnection() {
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection CLOSED");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
