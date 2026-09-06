package com.cinema;

import com.cinema.application.mapper.*;
import com.cinema.application.usecase.*;
import com.cinema.infrastructure.console.ConsoleController;
import com.cinema.infrastructure.persistence.InMemoryRepository;
import com.cinema.infrastructure.ui.App;
import javafx.application.Application;


public class Main {
    public static void main(String[] args) {
        launchUIApp(args);
    }

    private static void launchUIApp(String[] args){
        Application.launch(App.class, args);
    }

    private static void launchConsoleApp(){
        var repository = new InMemoryRepository();
        var usuarioMapper = new UsuarioMapper();
        var filmeMapper = new FilmeMapper();
        var salaMapper = new SalaMapper();
        var sessaoMapper = new SessaoMapper();
        var ingressoMapper = new IngressoMapper();

        new ConsoleController(
                new GetAllClientesInteractor(repository, usuarioMapper),
                new CreateClienteInteractor(repository, usuarioMapper),
                new GetAllFuncionariosInteractor(repository, usuarioMapper),
                new CreateFuncionarioInteractor(repository, usuarioMapper),
                new CreateFilmeInteractor(repository, filmeMapper),
                new GetAllFilmesInteractor(repository, filmeMapper),
                new GetAllSalasInteractor(repository, salaMapper),
                new CreateSalaInteractor(repository, salaMapper),
                new GetAllSessoesInteractor(repository, sessaoMapper),
                new CreateSessaoInteractor(repository, repository, repository, sessaoMapper),
                new GetAllIngressosInteractor(repository, ingressoMapper),
                new ComprarIngressoInteractor(repository, repository, repository, repository, ingressoMapper)
        ).run();
    }
}
