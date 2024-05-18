package ru.arvoglade.desktopfx.window.scene1;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SceneConfig {

    @Bean("scene1")
    public Scene getScene(MainPaneI pane) {

        Pane paneNode = (Pane) pane;

        Scene scene = new Scene(paneNode);
        return scene;
    }

    public interface MainPaneI {
    }

}
