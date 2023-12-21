package demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class DatabaseConnection {

    private static Connection connection;

    @Value("${database.url}")
    private String url;
    @Value("${database.username}")
    private String username;
    @Value("${database.password}")
    private String password;


    @PostConstruct
    public void init() {

        try {
            connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
            statement.execute("create table if not exists test(id int primary key, message varchar);");
            statement.executeUpdate("insert into test(id, message) values(1, '') on conflict do nothing;");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return connection;
    }


}
