package main.lesson9_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection("jdbc:postgresql:mydatabase",
                    "postgres", "testtest");
        } catch (SQLException e) {
            throw new SQLException(e);

            /*
            pw.println("connection failed");
            pw.println(e.getMessage());
            log(e.getMessage());
            StackTraceElement[] stack = e.getStackTrace();
            for (StackTraceElement element: stack) {
                log(element.toString());
            }
            */
        }
        return connection;
    }

}
