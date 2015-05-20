package demo.redview;

import demo.mainwindow.MainWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
public class RedViewLoader {
    private static final Logger LOG = LoggerFactory
            .getLogger(RedViewLoader.class);

    @Autowired
    private RedViewController redViewController;

    public Parent redView() throws IOException {

        Resource resourceViaSpringLoader = new DefaultResourceLoader()
                .getResource("classpath:fxml/redview/RedView.fxml");
        URL resourceUrlViaSpringLoader = resourceViaSpringLoader.getURL();
        LOG.info("resourceUrlViaSpringLoader: "+ resourceUrlViaSpringLoader);

        FXMLLoader loader = new FXMLLoader(resourceUrlViaSpringLoader);
        try {
            loader.setControllerFactory(new Callback<Class<?>, Object>() {
                @Override public Object call(Class<?> aClass) {
                    return redViewController;
                }
            });
            return loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
