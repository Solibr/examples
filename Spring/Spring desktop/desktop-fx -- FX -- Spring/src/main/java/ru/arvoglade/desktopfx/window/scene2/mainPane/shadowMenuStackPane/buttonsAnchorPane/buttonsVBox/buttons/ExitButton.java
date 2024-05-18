package ru.arvoglade.desktopfx.window.scene2.mainPane.shadowMenuStackPane.buttonsAnchorPane.buttonsVBox.buttons;

import javafx.scene.control.Button;
import org.springframework.stereotype.Component;

@Component
public class ExitButton extends Button {

    {
        this.setText("Exit");
        this.setOnAction(e -> {
            System.exit(0);
        });
    }

}
