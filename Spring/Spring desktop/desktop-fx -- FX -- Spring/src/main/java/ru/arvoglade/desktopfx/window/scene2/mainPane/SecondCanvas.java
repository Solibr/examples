package ru.arvoglade.desktopfx.window.scene2.mainPane;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import org.springframework.stereotype.Component;

@Component
public class SecondCanvas extends Canvas {

    public GraphicsContext gc;

    {
        this.gc = this.getGraphicsContext2D();

        double width = 400;
        double height = 300;

        resize(width, height);
        draw(width, height);
    }

    public void resize(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
        draw(width, height);
    }

    public void draw(double width, double height) {
        gc.setFill(javafx.scene.paint.Paint.valueOf("994499"));
        gc.fillRect(0, 0, width, height);
        gc.setFill(Paint.valueOf("220533"));
        gc.fillRect(width / 2  - 10, height / 2 - 10, 20, 20);
    }

}
