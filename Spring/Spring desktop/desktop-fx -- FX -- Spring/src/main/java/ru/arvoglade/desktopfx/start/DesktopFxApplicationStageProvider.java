package ru.arvoglade.desktopfx.start;

import javafx.application.Application;
import javafx.stage.Stage;
import ru.arvoglade.desktopfx.window.StageHolder;


public class DesktopFxApplicationStageProvider extends Application {

    public static void run() {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        StageHolder.stage = stage;
        SpringStarter.main(new String[0]);
        stage.show();
    }

}
