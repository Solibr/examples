package org.example.desktopfx;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import org.springframework.stereotype.Component;

//@Component
public class MyVBox extends VBox {

    public MyVBox() {
        super();
        this.getChildren().add(new Button("SHIT"));
    }
}
