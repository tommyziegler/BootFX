/*
 * Copyright 2014-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package demo;

import demo.mainwindow.MainWindowViewLoader;
import javafx.application.Preloader;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;

@Lazy
@SpringBootApplication
public class App extends AbstractJavaFxApplicationSupport {
    private static final Logger LOG = LoggerFactory
            .getLogger(App.class);

    @Autowired
    private MainWindowViewLoader mainWindowViewLoader;

    @Override
    public void start(Stage stage) throws Exception {

        notifyPreloader(new Preloader.StateChangeNotification(
                Preloader.StateChangeNotification.Type.BEFORE_START));

        mainWindowViewLoader.mainWindowView(stage).show();
    }

    public static void main(String[] args) {
        launchApp(App.class, args);
    }

}
