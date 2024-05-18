package org.example.desktopfx;

import javafx.scene.control.Button;
import org.springframework.stereotype.Component;

@Component
public class CatButton extends Button {

    private final Runner runner;

    public CatButton(Runner runner) {
        super("cat");
        this.runner = runner;
    }
}
