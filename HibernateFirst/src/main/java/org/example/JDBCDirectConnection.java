package org.example;

import java.sql.*;

public class JDBCDirectConnection {

    public static String url = "jdbc:h2:./db/test";
    public static String user = "sa";
    public static String pass = "";

    public static Connection connection;

    public static void testConnection() {

        System.out.println("=== JDBC Connection test ===");
        try {
            connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from cats;");
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnsCount = metaData.getColumnCount();

            while (resultSet.next()) {
                System.out.print(resultSet.getLong(1));
                System.out.print("\t");
                System.out.print(resultSet.getString(2));
                System.out.println();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
