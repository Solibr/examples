package org.example.desktopfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


//@SpringBootApplication
//@Configuration
//@Component
//@RequiredArgsConstructor
public class MyApp extends Application {

    private static Stage stage;

    public static Stage getStage() {

        Thread javaFxLaunchThread = new Thread(() -> launch(), "javaFxLaunchThread");
        javaFxLaunchThread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return stage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
    }

}
