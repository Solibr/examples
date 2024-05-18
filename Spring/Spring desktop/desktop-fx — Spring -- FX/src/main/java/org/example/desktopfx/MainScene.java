package org.example.desktopfx;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import lombok.RequiredArgsConstructor;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainScene extends Scene {

    @Autowired
    public MainScene(StageHolder stageHolder, MyVBox vBox) {
        super(vBox);

        Platform.runLater(() -> {
            stageHolder.getStage().setScene(this);
        });

    }

    public MainScene(VBox vBox) {
        super(vBox);
    }

    public MainScene(Parent root, double width, double height) {
        super(root, width, height);
    }

    public MainScene(Parent root, Paint fill) {
        super(root, fill);
    }

    public MainScene(Parent root, double width, double height, Paint fill) {
        super(root, width, height, fill);
    }

    public MainScene(Parent root, double width, double height, boolean depthBuffer) {
        super(root, width, height, depthBuffer);
    }

    public MainScene(Parent root, double width, double height, boolean depthBuffer, SceneAntialiasing antiAliasing) {
        super(root, width, height, depthBuffer, antiAliasing);
    }
}
