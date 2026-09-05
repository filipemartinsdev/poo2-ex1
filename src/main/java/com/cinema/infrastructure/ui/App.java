package com.cinema.infrastructure.ui;

import atlantafx.base.theme.*;
import com.cinema.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Application.setUserAgentStylesheet(new NordLight().getUserAgentStylesheet());

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("cinema.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Cinemaaaaa");
        stage.setScene(scene);

        stage.setWidth(1240);
        stage.setHeight(720);

        stage.centerOnScreen();

        stage.show();
    }
}
