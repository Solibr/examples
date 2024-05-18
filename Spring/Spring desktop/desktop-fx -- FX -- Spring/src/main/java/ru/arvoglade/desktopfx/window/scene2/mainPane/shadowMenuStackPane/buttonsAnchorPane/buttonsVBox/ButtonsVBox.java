package ru.arvoglade.desktopfx.window.scene2.mainPane.shadowMenuStackPane.buttonsAnchorPane.buttonsVBox;

import javafx.scene.layout.VBox;
import org.springframework.stereotype.Component;
import ru.arvoglade.desktopfx.window.scene2.mainPane.shadowMenuStackPane.buttonsAnchorPane.buttonsVBox.buttons.BackButton;
import ru.arvoglade.desktopfx.window.scene2.mainPane.shadowMenuStackPane.buttonsAnchorPane.buttonsVBox.buttons.ExitButton;

@Component
public class ButtonsVBox extends VBox {

    public ButtonsVBox(ExitButton exitButton, BackButton backButton) {
        this.getChildren().add(exitButton);
        this.getChildren().add(backButton);

    }
}
