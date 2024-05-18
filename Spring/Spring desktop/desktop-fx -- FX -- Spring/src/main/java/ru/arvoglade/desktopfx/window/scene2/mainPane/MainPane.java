package ru.arvoglade.desktopfx.window.scene2.mainPane;

import javafx.scene.layout.StackPane;
import org.springframework.stereotype.Component;
import ru.arvoglade.desktopfx.window.scene2.Scene2Config;
import ru.arvoglade.desktopfx.window.scene2.mainPane.shadowMenuStackPane.ShadowMenuStackPane;

@Component
public class MainPane extends StackPane implements Scene2Config.MainPaneI {

    public MainPane(ShadowMenuStackPane shadowMenuStackPane, SecondCanvas secondCanvas) {
        this.getChildren().add(secondCanvas);
        this.getChildren().add(shadowMenuStackPane);
    }
}
