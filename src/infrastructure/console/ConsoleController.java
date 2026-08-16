package infrastructure.console;

import application.dto.*;
import application.usecase.*;
import domain.entity.CategoriaSala;
import domain.entity.ClassificacaoFilme;
import domain.entity.GeneroFilme;
import domain.entity.TipoIngresso;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConsoleController {
    private final Scanner scanner = new Scanner(System.in);

    private final GetAllClientesInteractor getAllClientesInteractor;
    private final CreateClienteInteractor createClienteInteractor;
    private final GetAllFuncionariosInteractor getAllFuncionariosInteractor;
    private final CreateFuncionarioInteractor createFuncionarioInteractor;
    private final CreateFilmeInteractor createFilmeInteractor;
    private final GetAllFilmesInteractor getAllFilmesInteractor;
    private final GetAllSalasInteractor getAllSalasInteractor;
    private final CreateSalaInteractor createSalaInteractor;
    private final GetAllSessoesInteractor getAllSessoesInteractor;
    private final CreateSessaoInteractor createSessaoInteractor;
    private final GetAllIngressosInteractor getAllIngressosInteractor;
    private final ComprarIngressoInteractor comprarIngressoInteractor;


    public ConsoleController(GetAllClientesInteractor getAllClientesInteractor, CreateClienteInteractor createClienteInteractor, GetAllFuncionariosInteractor getAllFuncionariosInteractor, CreateFuncionarioInteractor createFuncionarioInteractor, CreateFilmeInteractor createFilmeInteractor, GetAllFilmesInteractor getAllFilmesInteractor, GetAllSalasInteractor getAllSalasInteractor, CreateSalaInteractor createSalaInteractor, GetAllSessoesInteractor getAllSessoesInteractor, CreateSessaoInteractor createSessaoInteractor, GetAllIngressosInteractor getAllIngressosInteractor, ComprarIngressoInteractor comprarIngressoInteractor) {
        this.getAllClientesInteractor = getAllClientesInteractor;
        this.createClienteInteractor = createClienteInteractor;
        this.getAllFuncionariosInteractor = getAllFuncionariosInteractor;
        this.createFuncionarioInteractor = createFuncionarioInteractor;
        this.createFilmeInteractor = createFilmeInteractor;
        this.getAllFilmesInteractor = getAllFilmesInteractor;
        this.getAllSalasInteractor = getAllSalasInteractor;
        this.createSalaInteractor = createSalaInteractor;
        this.getAllSessoesInteractor = getAllSessoesInteractor;
        this.createSessaoInteractor = createSessaoInteractor;
        this.getAllIngressosInteractor = getAllIngressosInteractor;
        this.comprarIngressoInteractor = comprarIngressoInteractor;
    }

    public void run(){
        while (true){
            try {
                mostrarMenu();
                MenuOpcao opcao = lerOpcao();

                switch (opcao) {
                    case VER_FUNCIONARIOS -> verFuncionarios();
                    case CADASTRAR_FUNCIONARIO -> cadastrarFuncionario();
                    case VER_CLIENTES -> verClientes();
                    case CADASTRAR_CLIENTE -> cadastrarCliente();
                    case VER_SALAS -> verSalas();
                    case CADASTRAR_SALA -> cadastrarSala();
                    case VER_FILMES -> verFilmes();
                    case CADASTRAR_FILME -> cadastrarFilme();
                    case VER_SESSOES -> verSessoes();
                    case CADASTRAR_SESSAO -> cadastrarSessao();
                    case VER_INGRESSOS -> verIngressos();
                    case COMPRAR_INGRESSO -> comprarIngresso();
                }
            } catch (Throwable throwable){}
        }
    }

    public void mostrarMenu(){
        for (MenuOpcao opcao : MenuOpcao.values()) {
            System.out.println("["+ opcao.id + "] " + opcao.descricao);
        }
    }

    private MenuOpcao lerOpcao() {
        System.out.print("> ");
        int entrada = scanner.nextInt();
        scanner.nextLine();
        return MenuOpcao.getById(entrada);
    }


    private void verFuncionarios(){
        for (FuncionarioResponse funcionario : getAllFuncionariosInteractor.getAllFuncionarios())
            System.out.println(funcionario);
        System.out.println();
    }

    private void cadastrarFuncionario(){
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        createFuncionarioInteractor.createFuncionario(new CreateFuncionarioRequest(cpf, nome));
    }

    private void verClientes() {
        for (ClienteResponse cliente : getAllClientesInteractor.getAllClientes())
            System.out.println(cliente);
        System.out.println();
    }

    private void verSalas(){
        for (SalaResponse sala : getAllSalasInteractor.getAllSalas())
            System.out.println(sala);
        System.out.println();
    }

    private void cadastrarCliente(){
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        createClienteInteractor.createCliente(new CreateClienteRequest(cpf, nome));
    }

    private void cadastrarSala(){
        for (CategoriaSala categoria : CategoriaSala.values())
            System.out.println("["+categoria.id+"] " + categoria.description);

        System.out.print("Categoria: ");
        int categoriaId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Assentos: ");
        int assentosCount = scanner.nextInt();
        scanner.nextLine();

        createSalaInteractor.createSala(new CreateSalaRequest(categoriaId, assentosCount));
    }

    private void verFilmes(){
        for (FilmeResponse filme : getAllFilmesInteractor.getAllFilmes())
            System.out.println(filme);
        System.out.println();
    }

    private void cadastrarFilme(){
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Duração (minutos): ");
        int duracaoMinutos = scanner.nextInt();
        scanner.nextLine();

        for (GeneroFilme genero : GeneroFilme.values())
            System.out.println("["+genero.id+"] " + genero.description);

        System.out.print("Gênero: ");
        int generoId = scanner.nextInt();
        scanner.nextLine();

        for (ClassificacaoFilme classificacao : ClassificacaoFilme.values())
            System.out.println("["+classificacao.id+"] " + classificacao.description);

        System.out.print("Classificação: ");
        int classificacaoId = scanner.nextInt();
        scanner.nextLine();

        createFilmeInteractor.createFilme(new CreateFilmeRequest(
                nome, descricao, Duration.ofMinutes(duracaoMinutos), generoId, classificacaoId
        ));
    }

    private void verSessoes(){
        for (SessaoResponse sessao : getAllSessoesInteractor.getAllSessoes())
            System.out.println(sessao);
        System.out.println();
    }

    private void cadastrarSessao() {
        System.out.print("Horário: ");
        Instant horario = Instant.parse(
                scanner.nextLine()
        );

        System.out.print("Valor: ");
        BigDecimal valor = new BigDecimal(scanner.nextFloat());
        scanner.nextLine();

        System.out.print("Filme (ID): ");
        long filmeId = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Sala: ");
        long salaNumero = scanner.nextLong();
        scanner.nextLine();

        createSessaoInteractor.createSessao(new CreateSessaoRequest(
                horario, valor, filmeId, salaNumero
        ));
    }

    private void verIngressos(){
        for (IngressoResponse ingresso : getAllIngressosInteractor.getAllIngressos())
            System.out.println(ingresso);
        System.out.println();
    }

    private void comprarIngresso(){
        for (TipoIngresso tipo : TipoIngresso.values())
            System.out.println("["+tipo.id+"] " + tipo.description);

        System.out.print("Tipo: ");
        int tipoId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Sessão (ID): ");
        long sessaoId = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Assento: ");
        int assentoNumero = scanner.nextInt();
        scanner.nextLine();

        System.out.print("CPF Funcionário: ");
        String funcionarioCpf = scanner.nextLine();

        System.out.print("CPF Cliente: ");
        String clienteCpf = scanner.nextLine();

        comprarIngressoInteractor.comprarIngresso(new CreateIngressoRequest(
                tipoId, sessaoId, assentoNumero, funcionarioCpf, clienteCpf
        ));
    }


    private static enum MenuOpcao {
        VER_CLIENTES(1, "Ver Clientes"),
        CADASTRAR_CLIENTE(2, "Cadastrar Cliente"),
        VER_FUNCIONARIOS(3, "Ver Funcionários"),
        CADASTRAR_FUNCIONARIO(4, "Cadastrar Funcionário"),
        VER_SALAS(5, "Ver Salas"),
        CADASTRAR_SALA(6, "Cadastrar Sala"),
        VER_FILMES(7, "Ver filmes"),
        CADASTRAR_FILME(8, "Cadastrar Filme"),
        VER_SESSOES(9, "Ver sessões"),
        CADASTRAR_SESSAO(10, "Cadastrar Sessão"),
        VER_INGRESSOS(11, "Ver Ingressos"),
        COMPRAR_INGRESSO(12, "Comprar Ingresso");

        public final int id;
        public final String descricao;

        MenuOpcao(int id, String descricao) {
            this.id = id;
            this.descricao = descricao;
        }

        public static MenuOpcao getById(int id){
            for (MenuOpcao opcao : MenuOpcao.values())
                if (opcao.id == id) return opcao;

            throw new RuntimeException("Opcao invalida");
        }
    }
}
