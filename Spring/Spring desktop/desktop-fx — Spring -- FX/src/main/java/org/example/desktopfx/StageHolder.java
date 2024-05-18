package org.example.desktopfx;

import javafx.stage.Stage;
import org.springframework.stereotype.Component;

//@Configuration
@Component
public class StageHolder {

    private Stage stage;

    public StageHolder() {
        this.stage = getStagePrivate();
    }

    public Stage getStage() {
        return this.stage;
    }

    private Stage getStagePrivate() {
        return MyApp.getStage();
    }



}
