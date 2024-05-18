package ru.arvoglade.desktopfx.window.scene1.mainPane.MyHbox;

import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import ru.arvoglade.desktopfx.window.templates.BigSizedButton;

@Component
public class ButtonB extends BigSizedButton {

    {
        this.setText("B");
        this.setOnAction(event -> {
            Stage stage = new Stage();
            stage.show();
        });
    }
}
