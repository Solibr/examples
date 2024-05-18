package ru.arvoglade.desktopfx.window.scene2.mainPane.shadowMenuStackPane.buttonsAnchorPane;

import jakarta.annotation.PostConstruct;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import org.springframework.stereotype.Component;
import ru.arvoglade.desktopfx.window.scene2.mainPane.shadowMenuStackPane.buttonsAnchorPane.buttonsVBox.ButtonsVBox;

@Component
public class ButtonsAnchorPane extends AnchorPane {

    public ButtonsAnchorPane(ButtonsVBox buttonsVBox) {

        this.getChildren().add(buttonsVBox);
    }


}
