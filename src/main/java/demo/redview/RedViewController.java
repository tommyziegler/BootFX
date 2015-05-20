package demo.redview;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class RedViewController implements Initializable {
    private static final Logger LOG = LoggerFactory
            .getLogger(RedViewController.class);

    @FXML
    private Button button3;


    @FXML
    private Button button2;

    @FXML
    private Button button1;


    private void handleButtonAction(ActionEvent event) {
        LOG.info("Button Action");
    }

    @Override public void initialize(URL location, ResourceBundle resources) {
        LOG.info("initialize location: " + location + ", ResourceBundle:"
                + resources);
    }
}
