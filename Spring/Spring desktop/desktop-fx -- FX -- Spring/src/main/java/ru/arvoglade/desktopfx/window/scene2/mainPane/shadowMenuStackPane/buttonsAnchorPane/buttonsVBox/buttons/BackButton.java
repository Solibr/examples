package ru.arvoglade.desktopfx.window.scene2.mainPane.shadowMenuStackPane.buttonsAnchorPane.buttonsVBox.buttons;


import jakarta.annotation.PostConstruct;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BackButton extends Button implements ApplicationContextAware {

    private ApplicationContext context;

    {
        this.setText("Back");
        /*this.setMaxSize(50, 25);
        this.setMinSize(50, 25);*/

        this.setOnAction((event) -> {

            Stage stage = context.getBean(Stage.class);
            Scene scene = context.getBean("scene1", Scene.class);
            stage.setScene(scene);
        });
    }

    @PostConstruct
    public void init() {
        /*this.stage = context.getBean(Stage.class);
        this.scene = context.getBean("scene1", Scene.class);*/
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
