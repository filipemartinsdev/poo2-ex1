package com.cinema;

import com.cinema.application.mapper.*;
import com.cinema.application.usecase.*;
import com.cinema.infrastructure.console.ConsoleController;
import com.cinema.infrastructure.persistence.InMemoryRepository;
import com.cinema.infrastructure.ui.App;
import javafx.application.Application;


public class Main {
    private static DependencyRegistry dependencyRegistry;

    public static void main(String[] args) {
        configureDependencies();
        launchUIApp(args);
    }

    private static void launchUIApp(String[] args){
        App.setDependencyRegistry(dependencyRegistry);
        Application.launch(App.class, args);
    }

    private static void launchConsoleApp(){
        new ConsoleController(
                dependencyRegistry.getAllClientesInteractor,
                dependencyRegistry.createClienteInteractor,
                dependencyRegistry.getAllFuncionariosInteractor,
                dependencyRegistry.createFuncionarioInteractor,
                dependencyRegistry.createFilmeInteractor,
                dependencyRegistry.getAllFilmesInteractor,
                dependencyRegistry.getAllSalasInteractor,
                dependencyRegistry.createSalaInteractor,
                dependencyRegistry.getAllSessoesInteractor,
                dependencyRegistry.createSessaoInteractor,
                dependencyRegistry.getAllIngressosInteractor,
                dependencyRegistry.comprarIngressoInteractor
        ).run();
    }

    private static void configureDependencies(){
        var repository = new InMemoryRepository();
        var usuarioMapper = new UsuarioMapper();
        var filmeMapper = new FilmeMapper();
        var salaMapper = new SalaMapper();
        var sessaoMapper = new SessaoMapper();
        var ingressoMapper = new IngressoMapper();

        dependencyRegistry = new DependencyRegistry(
                repository,
                usuarioMapper,
                filmeMapper,
                salaMapper,
                sessaoMapper,
                ingressoMapper,
                new GetAllClientesInteractor(repository, usuarioMapper),
                new GetClienteByCpfInteractor(repository, usuarioMapper),
                new CreateClienteInteractor(repository, usuarioMapper),
                new GetAllFuncionariosInteractor(repository, usuarioMapper),
                new GetFuncionarioByCpfInteractor(repository, usuarioMapper),
                new CreateFuncionarioInteractor(repository, usuarioMapper),
                new CreateFilmeInteractor(repository, filmeMapper),
                new GetAllFilmesInteractor(repository, filmeMapper),
                new GetFilmeByIdInteractor(repository, filmeMapper),
                new GetAllSalasInteractor(repository, salaMapper),
                new GetSalaByNumeroInteractor(repository, salaMapper),
                new CreateSalaInteractor(repository, salaMapper),
                new GetAllSessoesInteractor(repository, sessaoMapper),
                new GetSessaoByIdInteractor(repository, sessaoMapper),
                new CreateSessaoInteractor(repository, repository, repository, sessaoMapper),
                new GetAllIngressosInteractor(repository, ingressoMapper),
                new GetIngressoByIdInteractor(repository, ingressoMapper),
                new ComprarIngressoInteractor(repository, repository, repository, repository, ingressoMapper)
        );
    }
}
