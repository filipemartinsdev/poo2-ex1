import application.mapper.*;
import application.usecase.*;
import infrastructure.console.ConsoleController;
import infrastructure.persistence.Repository;


public class Main {
    public static void main(String[] args) {
        var repository = new Repository();

        new ConsoleController(
                new GetAllClientesInteractor(repository, new UsuarioMapper()),
                new CreateClienteInteractor(repository, new UsuarioMapper()),
                new GetAllFuncionariosInteractor(repository, new UsuarioMapper()),
                new CreateFuncionarioInteractor(repository, new UsuarioMapper()),
                new CreateFilmeInteractor(repository, new FilmeMapper()),
                new GetAllFilmesInteractor(repository, new FilmeMapper()),
                new GetAllSalasInteractor(repository, new SalaMapper()),
                new CreateSalaInteractor(repository, new SalaMapper()),
                new GetAllSessoesInteractor(repository, new SessaoMapper()),
                new CreateSessaoInteractor(repository, repository, repository, new SessaoMapper()),
                new GetAllIngressosInteractor(repository, new IngressoMapper()),
                new ComprarIngressoInteractor(repository, repository, repository, repository, new IngressoMapper())
        ).run();
    }
}
