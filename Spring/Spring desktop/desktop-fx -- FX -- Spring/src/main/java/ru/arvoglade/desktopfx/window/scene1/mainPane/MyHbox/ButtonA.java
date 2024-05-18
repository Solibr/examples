package ru.arvoglade.desktopfx.window.scene1.mainPane.MyHbox;

import jakarta.annotation.PostConstruct;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import ru.arvoglade.desktopfx.window.scene2.Scene2Config;
import ru.arvoglade.desktopfx.window.templates.BigSizedButton;

@Component
public class ButtonA extends BigSizedButton implements ApplicationContextAware {

    private ApplicationContext context;


    {
        this.setText("A");
        this.setOnAction((event) -> {
            Stage stage = context.getBean(Stage.class);
            Scene scene2 = context.getBean("scene2", Scene.class);
            stage.setScene(scene2);
        });
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
