package org.example;

import org.example.entities.Author;
import org.example.entities.Book;
import org.example.entities.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;


public class HibernateTest {

    public static SessionFactory sessionFactory;

    public static void hibernateTest() {
        initSessionFactory();
        //postAndPostCommentTest();
        populateAuthorsAndBooks();

    }

    private static void populateAuthorsAndBooks() {
        // cascade

        sessionFactory.inTransaction(session -> {
            Author author1 = new Author("a1");
            Book book1 = new Book("b1");
            Author author2 = new Author("a2");
            Book book2 = new Book("b2");
            Author author3 = new Author("a3");
            Book book3 = new Book("b3");

            book1.addAuthor(author1);
            book1.addAuthor(author2);
            book1.addAuthor(author3);

            book2.addAuthor(author1);
            book2.addAuthor(author2);

            book3.addAuthor(author1);

            session.persist(book1);
            session.persist(book2);
            session.persist(book3);

            // --------------

            Book abc = new Book("ABC");
            Book abc2 = new Book("ABC");

            abc.addAuthor(author1);
            abc.addAuthor(author2);

            abc2.addAuthor(author1);

            session.persist(abc);
            session.persist(abc2);

        });

    }

    private static void postAndPostCommentTest() {

        /*System.out.println("============ Writing ============");

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Post post1 = new Post("Shit");
*//*        Post post2 = new Post("Shit2");
        Post post3 = new Post("Shit3");
        Post post4 = new Post("Shit4");*//*

        PostComment comment1 = new PostComment("shit", null);

        session.persist(post1);
        session.persist(comment1);

        session.flush();

        session.evict(comment1);
        post1.setTitle("AAAAAA");
        comment1.setPost(post1);
        session.merge(comment1);


        // TODO continue... https://habr.com/ru/companies/otus/articles/529692/

        session.getTransaction().commit();
        session.close();

        System.out.println("============ Reading ============");
        System.out.println("Posts");
        Session session1 = sessionFactory.openSession();
        session1.createSelectionQuery("from Post", Post.class)
                .getResultList()
                .forEach(System.out::println);

        System.out.println("Comments");
        session1.createSelectionQuery("from PostComment", PostComment.class)
                .getResultList()
                .forEach(System.out::println);

        session1.close();*/

    }

    private static void catTest() {
        sessionFactory.inTransaction(session -> {
            session.persist(new Cat("Tom"));
        });

        sessionFactory.inTransaction(session -> {
            session.createSelectionQuery("from Cat", Cat.class)
                    .getResultList()
                    .forEach(System.out::println);
        });

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Cat cat = new Cat( "John");
        session.persist(cat);
        //session.flush();
        //session.getTransaction().commit();
        

        session.close();
    }

    private static void initSessionFactory() {
        StandardServiceRegistry registry
                = new StandardServiceRegistryBuilder()
                .build();

        try {
            sessionFactory = new MetadataSources(registry)
                    //.addAnnotatedClass(Cat.class)
                    .addAnnotatedClass(Author.class)
                    .addAnnotatedClass(Book.class)
                    .buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
