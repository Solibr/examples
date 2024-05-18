package org.example.desktopfx;

import javafx.scene.control.Button;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    @Bean
    public MyVBox getMyVBox() {
        MyVBox b = new MyVBox();
        b.getChildren().clear();
        b.getChildren().add(new Button("CAT BUTTON"));
        return b;
    }
}
