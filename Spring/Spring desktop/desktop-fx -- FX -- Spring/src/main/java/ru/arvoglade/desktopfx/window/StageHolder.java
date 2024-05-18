package ru.arvoglade.desktopfx.window;

import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StageHolder {
    public static Stage stage;

    @Bean
    public Stage getStage(@Qualifier("scene2") Scene scene) {

        stage.setWidth(540);
        stage.setHeight(350);

        stage.setFullScreen(true);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

        stage.setOnCloseRequest(event -> {
            System.exit(0);
        });
        stage.setScene(scene);
        return stage;
    }
}
