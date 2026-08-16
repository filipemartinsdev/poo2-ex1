import application.mapper.*;
import application.usecase.*;
import infrastructure.console.ConsoleController;
import infrastructure.persistence.InMemoryRepository;


public class Main {
    public static void main(String[] args) {
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
