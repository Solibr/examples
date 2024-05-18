package ru.arvoglade.desktopfx.window.scene1.mainPane;

import javafx.scene.Node;
import javafx.scene.layout.VBox;
import org.springframework.stereotype.Component;
import ru.arvoglade.desktopfx.window.scene1.SceneConfig;

import java.util.ArrayList;
import java.util.List;

@Component
public class MainPaneConfig extends VBox implements SceneConfig.MainPaneI {

    public MainPaneConfig(List<MainPaneChildNodesI> nodes) {
        List<Node> nodesList = new ArrayList<>(nodes.stream().map(Node.class::cast).toList());
        this.getChildren().addAll(nodesList);
    }

    public interface MainPaneChildNodesI {
    }

}
