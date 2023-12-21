package com.example.accessingdatajpa;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
@Component
public class TestJdbc {

    public static Logger log = LoggerFactory.getLogger(TestJdbc.class);

    @Value("${spring.datasource.url}")
    private String dataUrl;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    private Connection connection;

    @PostConstruct
    public void init() throws Exception {
        this.connection = DriverManager.getConnection(dataUrl, username, password);
    }

    public void jdbcLevelTest() throws Exception {

        log.info("Driver test");
        System.out.println(dataUrl);
//        Connection connection =
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from customer");
        while (resultSet.next()) {
            log.info(resultSet.getString(1) + " " + resultSet.getString(2));
        }
    }

    public void prepareTableIfNotExists() throws Exception {
        Statement statement = connection.createStatement();
        //statement.execute("create table if not exists customer (id bigint primary key, firstname varchar, lastname varchar);create sequence customer_seq increment by 50;");
        statement.execute("create table if not exists customer (id bigint primary key, firstname varchar, lastname varchar);");
        statement.execute("create sequence if not exists customer_seq increment by 50");
    }

}
