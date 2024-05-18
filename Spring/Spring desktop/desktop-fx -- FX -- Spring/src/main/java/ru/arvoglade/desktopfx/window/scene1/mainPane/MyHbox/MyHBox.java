package ru.arvoglade.desktopfx.window.scene1.mainPane.MyHbox;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import org.springframework.stereotype.Component;
import ru.arvoglade.desktopfx.window.templates.BigSizedButton;
import ru.arvoglade.desktopfx.window.scene1.mainPane.MainPaneConfig;

@Component
public class MyHBox extends HBox implements MainPaneConfig.MainPaneChildNodesI {

    public MyHBox(ButtonA buttonA, ButtonB buttonB) {
        this.getChildren().add(buttonA);
        this.getChildren().add(buttonB);
    }

}
