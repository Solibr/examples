package org.example.desktopfx;

import jakarta.annotation.PostConstruct;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;


@Configuration
public class Runner extends Application implements CommandLineRunner {

    @Autowired
    private Some some;

    @Getter
    private Stage stage;


    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setTitle("MyApplication");

        Button button = new Button("Exit");
        //StackPane
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        StackPane pane = new StackPane(button);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void run(String... args) throws Exception {
        new Thread(() -> launch()).start();

        System.out.println("Before Some call");
        Thread.sleep(200);
        some.foo();
    }
}
