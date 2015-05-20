package demo.mainwindow;

import demo.redview.RedViewController;
import demo.redview.RedViewLoader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class MainWindowController implements Initializable {
    private static final Logger LOG = LoggerFactory
            .getLogger(MainWindowController.class);

    private final MainWindowService mainWindowService;
    private final RedViewController redViewController;
    private final RedViewLoader redViewLoader;

    @FXML
    private Pane redViewPane;

    @Autowired MainWindowController(MainWindowService mainWindowService,
            RedViewController redViewController, RedViewLoader redViewLoader) {

        this.mainWindowService = mainWindowService;
        this.redViewController = redViewController;
        this.redViewLoader = redViewLoader;
    }

    @Override public void initialize(URL location, ResourceBundle resources) {
        LOG.info("initialize location: " + location + ", ResourceBundle:"
                + resources);

        LOG.info("redViewPane: "+redViewPane);

        try {
            redViewPane.getChildren().add(redViewLoader.redView());
            redViewPane = (Pane) redViewLoader.redView();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
