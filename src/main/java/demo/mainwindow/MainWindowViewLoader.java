package demo.mainwindow;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component
public class MainWindowViewLoader {
    private static final Logger LOG = LoggerFactory
            .getLogger(MainWindowViewLoader.class);

    @Autowired
    private MainWindowController mainWindowController;

    public Stage mainWindowView(Stage stage) throws IOException {

        Resource resourceViaSpringLoader = new DefaultResourceLoader()
                .getResource("classpath:fxml/mainwindow/MainWindow.fxml");
        URL resourceUrlViaSpringLoader = resourceViaSpringLoader.getURL();
        LOG.info("resourceUrlViaSpringLoader: "+ resourceUrlViaSpringLoader);


        FXMLLoader loader = new FXMLLoader(resourceUrlViaSpringLoader);
        try {
            loader.setControllerFactory(new Callback<Class<?>, Object>() {
                @Override public Object call(Class<?> aClass) {
                    return mainWindowController;
                }
            });
            stage.setScene(new Scene(loader.load()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return stage;
    }
}
