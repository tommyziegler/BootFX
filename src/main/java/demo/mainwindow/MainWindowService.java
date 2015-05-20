package demo.mainwindow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MainWindowService {
    private static final Logger LOG = LoggerFactory
            .getLogger(MainWindowService.class);

    public MainWindowService() {
        LOG.info("MainWindowService");
    }

    @Value("${app.ui.title:Example}")//
    private String windowTitle;

    public String getWindowTitle() {
        return windowTitle;
    }

}
