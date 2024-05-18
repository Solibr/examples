package ru.arvoglade.desktopfx.window.scene2;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.arvoglade.desktopfx.window.scene2.mainPane.shadowMenuStackPane.ShadowMenuStackPane;
import ru.arvoglade.desktopfx.window.scene2.mainPane.shadowMenuStackPane.buttonsAnchorPane.ButtonsAnchorPane;
import ru.arvoglade.desktopfx.window.scene2.mainPane.shadowMenuStackPane.buttonsAnchorPane.buttonsVBox.ButtonsVBox;

@Configuration
public class Scene2Config {

    @Bean("scene2")
    public Scene getScene2(MainPaneI pane, ShadowMenuStackPane shadowMenuStackPane) {

        Scene scene = new Scene((Pane) pane);

        scene.setOnKeyPressed(event -> {
            if (event.getCode().getName().equals("Esc")) {
                shadowMenuStackPane.showOrHide(scene.getWidth(), scene.getHeight());
            }
        });

        return scene;
    }

    public interface MainPaneI {}

}
