package com.cinema.infrastructure.ui;

import atlantafx.base.theme.*;
import com.cinema.DependencyRegistry;
import com.cinema.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class App extends Application {
    private static DependencyRegistry dependencyRegistry;

    public static void setDependencyRegistry(DependencyRegistry registry){
        dependencyRegistry = registry;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Application.setUserAgentStylesheet(new NordLight().getUserAgentStylesheet());

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("cinema.fxml"));

        configureControllerDependencies(fxmlLoader);

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Cinemaaaaa");
        stage.setScene(scene);

        stage.setWidth(1240);
        stage.setHeight(720);

        stage.centerOnScreen();

        stage.show();
    }

    private void configureControllerDependencies(FXMLLoader fxmlLoader) {
        fxmlLoader.setControllerFactory(controllerClass -> {
            if (controllerClass == CinemaController.class) {
                return new CinemaController(
                        dependencyRegistry.getAllClientesInteractor,
                        dependencyRegistry.getClienteByCpfInteractor,
                        dependencyRegistry.createClienteInteractor,
                        dependencyRegistry.getAllFuncionariosInteractor,
                        dependencyRegistry.getFuncionarioByCpfInteractor,
                        dependencyRegistry.createFuncionarioInteractor,
                        dependencyRegistry.createFilmeInteractor,
                        dependencyRegistry.getAllFilmesInteractor,
                        dependencyRegistry.getFilmeByIdInteractor,
                        dependencyRegistry.getAllSalasInteractor,
                        dependencyRegistry.getSalaByNumeroInteractor,
                        dependencyRegistry.createSalaInteractor,
                        dependencyRegistry.getAllSessoesInteractor,
                        dependencyRegistry.getSessaoByIdInteractor,
                        dependencyRegistry.createSessaoInteractor,
                        dependencyRegistry.getAllIngressosInteractor,
                        dependencyRegistry.getIngressoByIdInteractor,
                        dependencyRegistry.comprarIngressoInteractor
                );
            }

            else
                throw new RuntimeException("Invalid controller class: " + controllerClass.getName());
        });
    }
}
