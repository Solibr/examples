package ru.arvoglade.desktopfx.window.scene1.mainPane.MyHbox2;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.springframework.stereotype.Component;
import ru.arvoglade.desktopfx.window.templates.BigSizedButton;
import ru.arvoglade.desktopfx.window.scene1.mainPane.MainPaneConfig;

@Component
public class MyHBox2 extends HBox implements MainPaneConfig.MainPaneChildNodesI {


    public MyHBox2(MyCanvas canvas) {

        Button buttonC = new BigSizedButton();
        Button buttonD = new BigSizedButton();


        buttonC.setText("C");
        buttonD.setText("D");
        this.getChildren().add(buttonC);

        VBox vBox = new VBox();
        vBox.setPrefSize(400, 200);

        vBox.getChildren().add(canvas);
        //vBox.getChildren().add(buttonD);


/*        buttonC.widthProperty().addListener((observable, oldValue, newValue) -> {
            canvas.resize(newValue.doubleValue(), buttonC.getHeight());
        });*/

/*        buttonC.setOnAction(event -> {
            canvas.resize(buttonC.getWidth(), buttonC.getHeight());
        });*/

        vBox.heightProperty().addListener((observable, oldValue, newValue) -> {
            canvas.resize(vBox.getWidth() - 3, newValue.doubleValue() - 3);
            //canvas.resize(newValue.doubleValue() - 1, buttonC.getHeight());
        });

        vBox.widthProperty().addListener((observable, oldValue, newValue) -> {
            canvas.resize(newValue.doubleValue() -3, vBox.getHeight() - 3);
            //canvas.resize(newValue.doubleValue() - 1, buttonC.getHeight());
        });

        this.getChildren().add(vBox);
        //this.getChildren().add(buttonD);


    }
}
