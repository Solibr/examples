package ru.arvoglade.desktopfx.window.scene2.mainPane.shadowMenuStackPane;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import org.springframework.stereotype.Component;
import ru.arvoglade.desktopfx.window.scene2.mainPane.shadowMenuStackPane.buttonsAnchorPane.ButtonsAnchorPane;
import ru.arvoglade.desktopfx.window.scene2.mainPane.shadowMenuStackPane.buttonsAnchorPane.buttonsVBox.ButtonsVBox;

@Component
public class ShadowMenuStackPane extends StackPane {

    private ButtonsVBox buttonsVBox;
    private Canvas shadowCanvas;

    public ShadowMenuStackPane(ButtonsAnchorPane buttonsAnchorPane, ButtonsVBox buttonsVBox) {
        this.buttonsVBox = buttonsVBox;
        this.shadowCanvas = new Canvas();

        this.getChildren().add(shadowCanvas);
        this.getChildren().add(buttonsAnchorPane);


        this.setVisible(false);
    }

    public void showOrHide(double sceneWidth, double sceneHeight) {
        AnchorPane.setLeftAnchor(buttonsVBox, sceneWidth / 2 - buttonsVBox.getWidth() / 2);
        AnchorPane.setTopAnchor(buttonsVBox, sceneHeight / 2 - buttonsVBox.getHeight() / 2);
        drawShadow(sceneWidth, sceneHeight);
        this.setVisible(!this.isVisible());
    }

    private void drawShadow(double sceneWidth, double sceneHeight) {
        shadowCanvas.setWidth(sceneWidth);
        shadowCanvas.setHeight(sceneHeight);
        GraphicsContext gc = shadowCanvas.getGraphicsContext2D();
        gc.setFill(Paint.valueOf("33333355"));
        gc.clearRect(0, 0, sceneWidth, sceneHeight);
        gc.fillRect(0, 0, sceneWidth, sceneHeight);
    }


}
