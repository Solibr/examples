package org.example;

public class HibernateFirstApplication {
    public static void main(String[] args) {
        System.out.println("Hello world");
        HibernateTest.hibernateTest();
        JDBCDirectConnection.testConnection();

    }


}
