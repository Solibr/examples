package org.example.desktopfx;

import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private Stage stage;

    private StageHolder stageHolder;

    @Autowired
    public Runner(StageHolder stageHolder) {
        this.stageHolder = stageHolder;
    }

    @Override
    public void run(String... args) throws Exception {
        this.stage = stageHolder.getStage();

        Platform.runLater(() -> {
            stage.show();
        });

    }
}
