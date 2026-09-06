package com.cinema.infrastructure.ui;

import com.cinema.application.dto.*;
import com.cinema.application.mapper.*;
import com.cinema.application.usecase.*;
import com.cinema.domain.entity.*;
import com.cinema.infrastructure.persistence.InMemoryRepository;
import com.cinema.infrastructure.ui.model.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;

import java.math.BigDecimal;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class CinemaController {
    private final InMemoryRepository repository = new InMemoryRepository();
    private final UsuarioMapper usuarioMapper = new UsuarioMapper();
    private final FilmeMapper filmeMapper = new FilmeMapper();
    private final SalaMapper salaMapper = new SalaMapper();
    private final SessaoMapper sessaoMapper = new SessaoMapper();
    private final IngressoMapper ingressoMapper = new IngressoMapper();

    private final GetAllClientesInteractor getAllClientesInteractor = new GetAllClientesInteractor(repository, usuarioMapper);
    private final GetClienteByCpfInteractor getClienteByCpfInteractor = new GetClienteByCpfInteractor(repository, usuarioMapper);
    private final CreateClienteInteractor createClienteInteractor = new CreateClienteInteractor(repository, usuarioMapper);
    private final GetAllFuncionariosInteractor getAllFuncionariosInteractor = new GetAllFuncionariosInteractor(repository, usuarioMapper);
    private final GetFuncionarioByCpfInteractor getFuncionarioByCpfInteractor = new GetFuncionarioByCpfInteractor(repository, usuarioMapper);
    private final CreateFuncionarioInteractor createFuncionarioInteractor = new CreateFuncionarioInteractor(repository, usuarioMapper);
    private final CreateFilmeInteractor createFilmeInteractor = new CreateFilmeInteractor(repository, filmeMapper);
    private final GetAllFilmesInteractor getAllFilmesInteractor = new GetAllFilmesInteractor(repository, filmeMapper);
    private final GetFilmeByIdInteractor getFilmeByIdInteractor = new GetFilmeByIdInteractor(repository, filmeMapper);
    private final GetAllSalasInteractor getAllSalasInteractor = new GetAllSalasInteractor(repository, salaMapper);
    private final GetSalaByNumeroInteractor getSalaByNumeroInteractor = new GetSalaByNumeroInteractor(repository, salaMapper);
    private final CreateSalaInteractor createSalaInteractor = new CreateSalaInteractor(repository, salaMapper);
    private final GetAllSessoesInteractor getAllSessoesInteractor = new GetAllSessoesInteractor(repository, sessaoMapper);
    private final GetSessaoByIdInteractor getSessaoByIdInteractor = new GetSessaoByIdInteractor(repository, sessaoMapper);
    private final CreateSessaoInteractor createSessaoInteractor = new CreateSessaoInteractor(repository, repository, repository, sessaoMapper);
    private final GetAllIngressosInteractor getAllIngressosInteractor = new GetAllIngressosInteractor(repository, ingressoMapper);
    private final GetIngressoByIdInteractor getIngressoByIdInteractor = new GetIngressoByIdInteractor(repository, ingressoMapper);
    private final ComprarIngressoInteractor comprarIngressoInteractor = new ComprarIngressoInteractor(repository, repository, repository, repository, ingressoMapper);

    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private StringConverter<BigDecimal> moneyStringConverter = new StringConverter<BigDecimal>() {
        @Override
        public String toString(BigDecimal object) {
            return "R$ %.2f".formatted(object);
        }

        @Override
        public BigDecimal fromString(String string) {
            return null;
        }
    };

    @FXML
    private Button btnBuscarFilme;

    @FXML
    private Button btnBuscarSala;

    @FXML
    private Button btnBuscarUsuario;

    @FXML
    private Button btnComprarIngresso;

    @FXML
    private Button btnCriarFilme;

    @FXML
    private Button btnCriarSala;

    @FXML
    private Button btnCriarSessao;

    @FXML
    private Button btnCriarUsuario;


    @FXML
    private ChoiceBox<TipoIngresso> choiceComprarIngressoTipo;

    @FXML
    private TextField inputComprarIngressoCliente;

    @FXML
    private TextField inputComprarIngressoFuncionario;

    @FXML
    private TextField inputComprarIngressoSessao;

    @FXML
    private TextField inputComprarIngressoAssento;


    @FXML
    private ChoiceBox<CargoUsuario> choiceBuscarUsuarioCargo;

    @FXML
    private ChoiceBox<CargoUsuario> choiceRegistrarUsuarioCargo;

    @FXML
    private ChoiceBox<ClassificacaoFilme> choiceCriarFilmeClassificacao;

    @FXML
    private ChoiceBox<GeneroFilme> choiceCriarFilmeGenero;

    @FXML
    private ChoiceBox<CategoriaSala> choiceCriarSalaCategoria;

    @FXML
    private DatePicker dateCriarSessao;

    @FXML
    private TextField inputBuscarSalaNumero;

    @FXML
    private TextField inputBuscarSessaoId;

    @FXML
    private TextField inputBuscarUsuarioCpf;

    @FXML
    private TextField inputRegistrarUsuarioCpf;

    @FXML
    private TextField inputRegistrarUsuarioNome;

    @FXML
    private TextField inputCriarFilmeNome;

    @FXML
    private TextField inputBuscarIngressoId;

    @FXML
    private TextField inputCriarSessaoFilmeId;

    @FXML
    private TextField inputCriarSessaoHorario;

    @FXML
    private TextField inputCriarSessaoSalaId;

    @FXML
    private TextField inputIngressoAssentoNumero;

    @FXML
    private TextField inputIngressoClienteId;

    @FXML
    private TextField inputIngressoFuncionarioId;

    @FXML
    private TextField inputIngressoSessaoId;

    @FXML TextField inputBuscarFilmeId;

    @FXML
    private Spinner<Integer> spinCriarSalaAssentos;

    @FXML
    private Spinner<Integer> spinCriarFilmeDuracao;

    @FXML
    private Spinner<Double> spinCriarSessaoValor;

    @FXML
    private Tab tabFilmes;

    @FXML
    private Tab tabFilmesBuscar;

    @FXML
    private Tab tabFilmesCriar;

    @FXML
    private Tab tabIngresso;

    @FXML
    private Tab tabIngressoBuscar;

    @FXML
    private Tab tabIngressoComprar;

    @FXML
    private Tab tabSalas;

    @FXML
    private Tab tabSalasBuscar;

    @FXML
    private Tab tabSalasCriar;

    @FXML
    private Tab tabSessoes;

    @FXML
    private Tab tabSessoesBuscar;

    @FXML
    private Tab tabSessoesCriar;

    @FXML
    private Tab tabUsuario;

    @FXML
    private Tab tabUsuarioBuscar;

    @FXML
    private Tab tabUsuarioCriar;


    @FXML
    private TableView<TableUsuarioItem> tableUsuario;

    @FXML
    private TableColumn<TableUsuarioItem, Integer> colUsuarioId;

    @FXML
    private TableColumn<TableUsuarioItem, String> colUsuarioNome;

    @FXML
    private TableColumn<TableUsuarioItem, String> colUsuarioCargo;

    @FXML
    private TableColumn<TableUsuarioItem, String> colUsuarioCpf;

    private final ObservableList<TableUsuarioItem> tableUsuarioItems = FXCollections.observableArrayList();


    @FXML
    private TableView<TableIngressoItem> tableIngresso;

    @FXML
    private TableColumn<TableIngressoItem, Integer> colIngressoId;

    @FXML
    private TableColumn<TableIngressoItem, String> colIngressoTipo;

    @FXML
    private TableColumn<TableIngressoItem, Integer> colIngressoSessao;

    @FXML
    private TableColumn<TableIngressoItem, Integer> colIngressoAssento;

    @FXML
    private TableColumn<TableIngressoItem, String> colIngressoCliente;

    @FXML
    private TableColumn<TableIngressoItem, String> colIngressoVendedor;

    private final ObservableList<TableIngressoItem> tableIngressoItems = FXCollections.observableArrayList();


    @FXML
    private TableView<TableSessaoItem> tableSessao;

    @FXML
    private TableColumn<TableSessaoItem, Integer> colSessaoId;

    @FXML
    private TableColumn<TableSessaoItem, String> colSessaoFilme;

    @FXML
    private TableColumn<TableSessaoItem, LocalDate> colSessaoData;

    @FXML
    private TableColumn<TableSessaoItem, Instant> colSessaoHorario;

    @FXML
    private TableColumn<TableSessaoItem, BigDecimal> colSessaoValor;

    @FXML
    private TableColumn<TableSessaoItem, Integer> colSessaoSala;

    @FXML
    private TableColumn<TableSessaoItem, Integer> colSessaoVagas;

    private final ObservableList<TableSessaoItem> tableSessaoItems = FXCollections.observableArrayList();


    @FXML
    private TableView<TableFilmeItem> tableFilme;

    @FXML
    private TableColumn<TableFilmeItem, Integer> colFilmeId;

    @FXML
    private TableColumn<TableFilmeItem, String> colFilmeNome;

    @FXML
    private TableColumn<TableFilmeItem, GeneroFilme> colFilmeGenero;

    @FXML
    private TableColumn<TableFilmeItem, ClassificacaoFilme> colFilmeClassificacao;

    @FXML
    private TableColumn<TableFilmeItem, Integer> colFilmeDuracao;

    private final ObservableList<TableFilmeItem> tableFilmeItems = FXCollections.observableArrayList();


    @FXML
    private TableView<TableSalaItem> tableSala;

    @FXML
    private TableColumn<TableSalaItem, Integer> colSalaNumero;

    @FXML
    private TableColumn<TableSalaItem, CategoriaSala> colSalaCategoria;

    @FXML
    private TableColumn<TableSalaItem, Integer> colSalaAssentos;


    private final ObservableList<TableSalaItem> tableSalaItems = FXCollections.observableArrayList();


    @FXML
    void initialize() {
        Platform.runLater(this::setupChoiceBuscarUsuarioCargo);
        Platform.runLater(this::setupChoiceRegistrarUsuarioCargo);

        Platform.runLater(this::setupDataCriarSessao);
        Platform.runLater(this::setupSpinCriarSessaoValor);

        Platform.runLater(this::setupSpinCriarSessaoDuracao);
        Platform.runLater(this::setupChoiceCriarFilmeGenero);
        Platform.runLater(this::setupChoiceCriarFilmeClassificacao);

        Platform.runLater(this::setupChoiceCriarSalaCategoria);
        Platform.runLater(this::setupSpinCriarSalaAssentos);

        Platform.runLater(this::setupChoiceComprarIngressoTipo);

        Platform.runLater(this::setupTableUsuario);
        Platform.runLater(this::setupTableIngresso);
        Platform.runLater(this::setupTableSessao);
        Platform.runLater(this::setupTableFilme);
        Platform.runLater(this::setupTableSala);
    }

    private void setupChoiceBuscarUsuarioCargo(){
        choiceBuscarUsuarioCargo.getItems().addAll(CargoUsuario.values());

        choiceBuscarUsuarioCargo.setConverter(new StringConverter<CargoUsuario>() {
            @Override
            public String toString(CargoUsuario object) {
                return object != null ? object.description : "";
            }

            @Override
            public CargoUsuario fromString(String string) {
                return null;
            }
        });

        choiceBuscarUsuarioCargo.setValue(CargoUsuario.CLIENTE);
    }

    private void setupChoiceRegistrarUsuarioCargo(){
        choiceRegistrarUsuarioCargo.getItems().addAll(CargoUsuario.values());

        choiceRegistrarUsuarioCargo.setConverter(new StringConverter<CargoUsuario>() {
            @Override
            public String toString(CargoUsuario object) {
                return object != null ? object.description : "";
            }

            @Override
            public CargoUsuario fromString(String string) {
                return null;
            }
        });

        choiceRegistrarUsuarioCargo.setValue(CargoUsuario.CLIENTE);
    }


    private void setupChoiceComprarIngressoTipo(){
        choiceComprarIngressoTipo.setConverter(new StringConverter<TipoIngresso>() {
            @Override
            public String toString(TipoIngresso object) {
                return object != null ? object.description : "";
            }

            @Override
            public TipoIngresso fromString(String string) {
                return null;
            }
        });

        for (var tipo : TipoIngresso.values())
            choiceComprarIngressoTipo.getItems().add(tipo);

        choiceComprarIngressoTipo.setValue(TipoIngresso.INTEIRO);
    }


    private void setupDataCriarSessao(){
        dateCriarSessao.setConverter(new StringConverter<LocalDate>() {
            @Override
            public String toString(LocalDate object) {
                return object != null ? dateFormatter.format(object) : "";
            }

            @Override
            public LocalDate fromString(String string) {
                try {
                    return string != null && !string.isEmpty()
                            ? LocalDate.parse(string, dateFormatter)
                            : null;
                } catch (Exception e){
                    return null;
                }
            }
        });
    }

    private void setupSpinCriarSessaoValor(){
        spinCriarSessaoValor.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, Double.MAX_VALUE, 0.0));
        spinCriarSessaoValor.setEditable(true);
    }

    private void setupSpinCriarSessaoDuracao(){
        spinCriarFilmeDuracao.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE, 0));
        spinCriarFilmeDuracao.setEditable(true);
    }


    private void setupChoiceCriarFilmeGenero(){
        choiceCriarFilmeGenero.setConverter(new StringConverter<GeneroFilme>() {
            @Override
            public String toString(GeneroFilme object) {
                return object != null ? object.description : "";
            }

            @Override
            public GeneroFilme fromString(String string) {
                return null;
            }
        });

        for (var genero : GeneroFilme.values())
            choiceCriarFilmeGenero.getItems().add(genero);
    }

    private void setupChoiceCriarFilmeClassificacao(){
        choiceCriarFilmeClassificacao.setConverter(new StringConverter<ClassificacaoFilme>() {
            @Override
            public String toString(ClassificacaoFilme object) {
                return object != null ? object.description : "";
            }

            @Override
            public ClassificacaoFilme fromString(String string) {
                return null;
            }
        });

        for (var classificacao : ClassificacaoFilme.values())
            choiceCriarFilmeClassificacao.getItems().add(classificacao);

        choiceCriarFilmeClassificacao.setValue(ClassificacaoFilme.LIVRE);
    }


    private void setupChoiceCriarSalaCategoria(){
        choiceCriarSalaCategoria.setConverter(new StringConverter<CategoriaSala>() {
            @Override
            public String toString(CategoriaSala object) {
                return object != null ? object.description : "";
            }

            @Override
            public CategoriaSala fromString(String string) {
                return null;
            }
        });

        for (var categoria : CategoriaSala.values())
            choiceCriarSalaCategoria.getItems().add(categoria);

        choiceCriarSalaCategoria.setValue(CategoriaSala.COMUM);
    }

    private void setupSpinCriarSalaAssentos(){
        spinCriarSalaAssentos.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE, 0));
        spinCriarSalaAssentos.setEditable(true);
    }


    private void setupTableUsuario(){
        tableUsuario.setItems(tableUsuarioItems);

        setupColUsuarioCpf();
        setupColUsuarioNome();
        setupColUsuarioCargo();
    }

    private void setupColUsuarioNome(){
        colUsuarioNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    }

    private void setupColUsuarioCargo(){
        colUsuarioCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
    }

    private void setupColUsuarioCpf(){
        colUsuarioCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
    }


    private void setupTableIngresso(){
        tableIngresso.setItems(tableIngressoItems);

        setupColIngressoId();
        setupColIngressoTipo();
        setupColIngressoSessao();
        setupColIngressoAssento();
        setupColIngressoCliente();
        setupColIngressoVendedor();
    }

    private void setupColIngressoId(){
        colIngressoId.setCellValueFactory(new PropertyValueFactory<>("id"));
    }

    private void setupColIngressoTipo(){
        colIngressoTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));

        colIngressoTipo.setCellFactory(column -> new TableCell<>(){
            @Override
            protected void updateItem(String item, boolean empty){
                setText(item != null ? item : "");
            }
        });
    }

    private void setupColIngressoSessao(){
        colIngressoSessao.setCellValueFactory(new PropertyValueFactory<>("sessao"));
    }

    private void setupColIngressoAssento(){
        colIngressoAssento.setCellValueFactory(new PropertyValueFactory<>("assento"));
    }

    private void setupColIngressoCliente(){
        colIngressoCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
    }

    private void setupColIngressoVendedor(){
        colIngressoVendedor.setCellValueFactory(new PropertyValueFactory<>("vendedor"));
    }


    private void setupTableSessao(){
        tableSessao.setItems(tableSessaoItems);

        setupColSessaoId();
        setupColSessaoFilme();
        setupColSessaoData();
        setupColSessaoHorario();
        setupColSessaoValor();
        setupColSessaoSala();
        setupColSessaoVagas();
    }

    private void setupColSessaoId(){
        colSessaoId.setCellValueFactory(new PropertyValueFactory<>("id"));
    }

    private void setupColSessaoFilme(){
        colSessaoFilme.setCellValueFactory(new PropertyValueFactory<>("filme"));
    }

    private void setupColSessaoData(){
        colSessaoData.setCellValueFactory(new PropertyValueFactory<>("data"));

        colSessaoData.setCellFactory(column -> new TableCell<>(){
            @Override
            protected void updateItem(LocalDate item, boolean empty){
                setText(item != null ? dateFormatter.format(item) : "");
            }
        });
    }

    private void setupColSessaoHorario(){
        colSessaoHorario.setCellValueFactory(new PropertyValueFactory<>("horario"));

        colSessaoHorario.setCellFactory(column -> new TableCell<>(){
            @Override
            protected void updateItem(Instant item, boolean empty){
                if (item != null) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm")
                            .withZone(ZoneOffset.UTC);
                    setText(formatter.format(item));
                }
                else {
                    setText("");
                }
            }
        });
    }

    private void setupColSessaoValor(){
        colSessaoValor.setCellValueFactory(new PropertyValueFactory<>("valor"));

        colSessaoValor.setCellFactory(column -> new TableCell<>(){
            @Override
            protected void updateItem(BigDecimal item, boolean empty){
                setText(item != null ? "R$ %.2f".formatted(item.floatValue()) : "");
            }
        });
    }

    private void setupColSessaoSala(){
        colSessaoSala.setCellValueFactory(new PropertyValueFactory<>("sala"));
    }

    private void setupColSessaoVagas(){
        colSessaoVagas.setCellValueFactory(new PropertyValueFactory<>("vagas"));
    }


    private void setupTableFilme(){
        tableFilme.setItems(tableFilmeItems);

        setupColFilmeId();
        setupColFilmeNome();
        setupColFilmeGenero();
        setupColFilmeClassificacao();
        setupColFilmeDuracao();
    }

    private void setupColFilmeId() {
        colFilmeId.setCellValueFactory(new PropertyValueFactory<>("id"));
    }

    private void setupColFilmeNome() {
        colFilmeNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    }

    private void setupColFilmeGenero() {
        colFilmeGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));

        colFilmeGenero.setCellFactory(column -> new TableCell<>(){
            @Override
            protected void updateItem(GeneroFilme item, boolean empty){
                setText(item != null ? item.description : "");
            }
        });
    }

    private void setupColFilmeClassificacao() {
        colFilmeClassificacao.setCellValueFactory(new PropertyValueFactory<>("classificacao"));

        colFilmeClassificacao.setCellFactory(column -> new TableCell<>(){
            @Override
            protected void updateItem(ClassificacaoFilme item, boolean empty){
                setText(item != null ? item.description : "");
            }
        });
    }

    private void setupColFilmeDuracao() {
        colFilmeDuracao.setCellValueFactory(new PropertyValueFactory<>("duracao"));
    }


    private void setupTableSala(){
        tableSala.setItems(tableSalaItems);

        setupColSalaNumero();
        setupColSalaCategoria();
        setupColSalaAssentos();
    }

    private void setupColSalaNumero(){
        colSalaNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
    }

    private void setupColSalaCategoria(){
        colSalaCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));

        colSalaCategoria.setCellFactory(column -> new TableCell<>(){
            @Override
            protected void updateItem(CategoriaSala item, boolean empty){
                setText(item != null ? item.description : "");
            }
        });
    }

    private void setupColSalaAssentos(){
        colSalaAssentos.setCellValueFactory(new PropertyValueFactory<>("assentos"));
    }


    @FXML
    void buscarUsuario(ActionEvent event) {
        String input = inputBuscarUsuarioCpf.getText();

        if (input == null || input.isEmpty())
            buscarTodosUsuarios();
        else
            buscarUsuarioPorCpf(input);
    }

    private void buscarTodosUsuarios(){
        CargoUsuario cargo = choiceBuscarUsuarioCargo.getValue();

        if (cargo == null) {
            showErrorAlert("Cargo inválido");
            return;
        }

        if (cargo.equals(CargoUsuario.CLIENTE)) {
            var result = getAllClientesInteractor.getAllClientes();

            tableUsuarioItems.clear();
            tableUsuarioItems.addAll(
                    result.stream().map(cliente ->
                            new TableUsuarioItem(
                                    cliente.cpf(),
                                    cliente.nome(),
                                    CargoUsuario.CLIENTE.description
                            )
                    ).toList()
            );
        }

        else {
            var result = getAllFuncionariosInteractor.getAllFuncionarios();

            tableUsuarioItems.clear();
            tableUsuarioItems.addAll(
                    result.stream().map(funcionario ->
                            new TableUsuarioItem(
                                    funcionario.cpf(),
                                    funcionario.nome(),
                                    CargoUsuario.FUNCIONARIO.description
                            )
                    ).toList()
            );
        }
    }

    private void buscarUsuarioPorCpf(String cpf){
        CargoUsuario cargo = choiceBuscarUsuarioCargo.getValue();

        if (cargo == null) {
            showErrorAlert("Cargo inválido");
            return;
        }

        if (cargo.equals(CargoUsuario.CLIENTE)) {
            tableUsuarioItems.clear();

            Optional<ClienteResponse> result = getClienteByCpfInteractor.getByCpf(cpf);

            if (result.isEmpty()){
                showErrorAlert("Cliente não encontrado");
                return;
            }

            tableUsuarioItems.add(
                new TableUsuarioItem(
                        result.get().cpf(),
                        result.get().nome(),
                        CargoUsuario.CLIENTE.description
                )
            );
        }

        else {
            tableUsuarioItems.clear();

            Optional<FuncionarioResponse> result = getFuncionarioByCpfInteractor.getByCpf(cpf);

            if (result.isEmpty()){
                showErrorAlert("Funcionário não encontrado");
                return;
            }

            tableUsuarioItems.add(
                    new TableUsuarioItem(
                            result.get().cpf(),
                            result.get().nome(),
                            CargoUsuario.FUNCIONARIO.description
                    )
            );
        }
    }


    @FXML
    void criarUsuario(ActionEvent event) {
        CargoUsuario cargo = choiceRegistrarUsuarioCargo.getValue();

        if (cargo == null){
            showErrorAlert("Cargo inválido");
            return;
        }

        String cpf = inputRegistrarUsuarioCpf.getText();
        String nome = inputRegistrarUsuarioNome.getText();

        if (nome == null || nome.isEmpty()){
            showErrorAlert("Nome inválido");
            return;
        }

        if (cpf == null || cpf.isEmpty()){
            showErrorAlert("CPF inválido");
            return;
        }

        if (cargo.equals(CargoUsuario.CLIENTE))
            criarCliente(cpf, nome);

        else
            criarFuncionario(cpf, nome);
    }

    private void criarCliente(String cpf, String nome){
        createClienteInteractor.createCliente(new CreateClienteRequest(
                cpf, nome
        ));

        limparRegistrarUsuarioForms();

        showInfoAlert("Cliente registrado!");
    }

    private void criarFuncionario(String cpf, String nome){
        createFuncionarioInteractor.createFuncionario(new CreateFuncionarioRequest(
                cpf, nome
        ));

        limparRegistrarUsuarioForms();

        showInfoAlert("Funcionário registrado!");
    }

    private void limparRegistrarUsuarioForms(){
        inputRegistrarUsuarioCpf.clear();
        inputRegistrarUsuarioNome.clear();
    }


    @FXML
    void buscarSala(ActionEvent event) {
        String numeroInput = inputBuscarSalaNumero.getText();

        if (numeroInput == null || numeroInput.isEmpty()){
            buscarTodasSalas();
            return;
        }

        else {
            long numero;

            try {
                numero = Long.parseLong(numeroInput);
            } catch (Exception e){
                showErrorAlert("Número inválido");
                return;
            }

            buscarSalaPorNumero(numero);
        }
    }

    private void buscarTodasSalas(){
        tableSalaItems.clear();

        tableSalaItems.addAll(
                getAllSalasInteractor.getAllSalas().stream()
                        .map(sala -> new TableSalaItem(
                                sala.numero(),
                                CategoriaSala.getById(sala.categoria().id()),
                                sala.assentos()
                        ))
                        .toList()
        );
    }

    private void buscarSalaPorNumero(long numero){
        tableSalaItems.clear();

        Optional<SalaResponse> result = getSalaByNumeroInteractor.getByNumero(numero);

        if (result.isEmpty()){
            showErrorAlert("Sala não encontrada");
            return;
        }

        tableSalaItems.add(
                new TableSalaItem(
                        result.get().numero(),
                        CategoriaSala.getById(result.get().categoria().id()),
                        result.get().assentos()
                )
        );
    }


    @FXML
    void criarSala(ActionEvent event) {
        CategoriaSala categoria = choiceCriarSalaCategoria.getValue();
        Integer assentos = spinCriarSalaAssentos.getValue();

        if (categoria == null){
            showErrorAlert("Categoria inválida");
            return;
        }

        if (assentos == null || assentos <= 0){
            showErrorAlert("Assentos inválidos");
            return;
        }

        createSalaInteractor.createSala(new CreateSalaRequest(
            categoria.id, assentos
        ));

        showInfoAlert("Sala criada!");
    }

    @FXML
    void buscarIngresso(ActionEvent event) {
        String idInput = inputBuscarIngressoId.getText();

        if (idInput == null || idInput.isEmpty()){
            buscarTodosIngressos();
            return;
        }

        long id;

        try {
            id = Long.parseLong(idInput);
        } catch (Exception e){
            showErrorAlert("ID inválido");
            return;
        }

        buscarIngressoPorId(id);
    }

    private void buscarTodosIngressos(){
        tableIngressoItems.clear();

        tableIngressoItems.addAll(getAllIngressosInteractor.getAllIngressos().stream()
                .map(ingresso -> new TableIngressoItem(
                        ingresso.id(),
                        ingresso.tipo(),
                        ingresso.sessaoId(),
                        ingresso.assento(),
                        ingresso.cliente(),
                        ingresso.funcionario()
                ))
                .toList()
        );
    }

    private void buscarIngressoPorId(long id){
        tableIngressoItems.clear();

        Optional<IngressoResponse> result = getIngressoByIdInteractor.getById(id);

        if (result.isEmpty()){
            showErrorAlert("Ingresso não encontrado");
            return;
        }

        tableIngressoItems.add(
                new TableIngressoItem(
                        result.get().id(),
                        result.get().tipo(),
                        result.get().sessaoId(),
                        result.get().assento(),
                        result.get().cliente(),
                        result.get().funcionario()
                )
        );
    }

    @FXML
    void comprarIngresso(ActionEvent event) {
        TipoIngresso tipo = choiceComprarIngressoTipo.getValue();
        String clienteCpfInput = inputComprarIngressoCliente.getText();
        String funcionarioCpfInput = inputComprarIngressoFuncionario.getText();
        String sessaoIdInput = inputComprarIngressoSessao.getText();
        String assentoInput = inputComprarIngressoAssento.getText();

        if (!isComprarIngressoInputsValid(tipo, clienteCpfInput, funcionarioCpfInput, sessaoIdInput, assentoInput)) {
            return;
        }

        long sessao;
        int assento;

        try {
            sessao = Long.parseLong(sessaoIdInput);
        } catch (Exception e){
            showErrorAlert("Sessão inválida");
            return;
        }

        try {
            assento = Integer.parseInt(assentoInput);
        } catch (Exception e){
            showErrorAlert("Assento inválido");
            return;
        }

        comprarIngressoInteractor.comprarIngresso(new CreateIngressoRequest(
                tipo.id, sessao, assento, funcionarioCpfInput, clienteCpfInput
        ));

        showInfoAlert("Ingresso comprado!");
    }

    private boolean isComprarIngressoInputsValid(
            TipoIngresso tipo, String clienteCpfInput, String funcionarioCpfInput, String sessaoIdInput, String assentoInput
    ) {
        if (tipo == null){
            showErrorAlert("Tipo inválido");
            return false;
        }

        if (clienteCpfInput == null || clienteCpfInput.isEmpty()){
            showErrorAlert("Cliente inválido");
            return false;
        }

        if (funcionarioCpfInput == null || funcionarioCpfInput.isEmpty()){
            showErrorAlert("Funcionário inválido");
            return false;
        }

        if (sessaoIdInput == null || sessaoIdInput.isEmpty()){
            showErrorAlert("Sessão inválida");
            return false;
        }

        if (assentoInput == null || assentoInput.isEmpty()){
            showErrorAlert("Assento inválido");
            return false;
        }
        return true;
    }


    @FXML
    void buscarFilme(ActionEvent event) {
        String idInput = inputBuscarFilmeId.getText();

        if (idInput == null || idInput.isEmpty()){
            buscarTodosFilmes();
            return;
        }

        else {
            long id;

            try {
                id = Long.parseLong(idInput);
            } catch (Exception e){
                showErrorAlert("ID inválido");
                return;
            }

            buscarFilmePorId(id);
        }
    }

    private void buscarTodosFilmes(){
        tableFilmeItems.clear();
        tableFilmeItems.addAll(
                getAllFilmesInteractor.getAllFilmes().stream()
                        .map(filme ->
                                new TableFilmeItem(
                                        filme.id(),
                                        filme.nome(),
                                        GeneroFilme.getById(filme.genero().id()),
                                        ClassificacaoFilme.getById(filme.classificacao().id()),
                                        filme.duracao().toMinutes()
                                )
                        )
                        .toList()
        );
    }

    private void buscarFilmePorId(long id){
        tableFilmeItems.clear();

        Optional<FilmeResponse> result = getFilmeByIdInteractor.getById(id);

        if (result.isEmpty()){
            showErrorAlert("Filme não encontrado");
            return;
        }

        tableFilmeItems.add(
                new TableFilmeItem(
                        result.get().id(),
                        result.get().nome(),
                        GeneroFilme.getById(result.get().genero().id()),
                        ClassificacaoFilme.getById(result.get().classificacao().id()),
                        result.get().duracao().toMinutes()
                )
        );
    }


    @FXML
    void criarFilme(ActionEvent event) {
        String nome = inputCriarFilmeNome.getText();
        String descricao = "";
        Integer duracao = spinCriarFilmeDuracao.getValue();
        GeneroFilme genero = choiceCriarFilmeGenero.getValue();
        ClassificacaoFilme classificacao = choiceCriarFilmeClassificacao.getValue();

        if (nome == null || nome.isEmpty()){
            showErrorAlert("Nome inválido");
            return;
        }

        if (duracao == null || duracao <= 0){
            showErrorAlert("Duração inválida");
            return;
        }

        if (genero == null){
            showErrorAlert("Gênero inválido");
            return;
        }

        if (classificacao == null){
            showErrorAlert("Classificação inválida");
            return;
        }

        createFilmeInteractor.createFilme(new CreateFilmeRequest(
                nome, descricao, Duration.ofMinutes(duracao), genero.id, classificacao.id
        ));

        limparCriarFilmeForms();

        showInfoAlert("Filme criado!");
    }

    private void limparCriarFilmeForms() {
        inputCriarFilmeNome.clear();

        int d = spinCriarFilmeDuracao.getValue();
        while (d > 0) {
            spinCriarFilmeDuracao.decrement();
            d = spinCriarFilmeDuracao.getValue();
        }

        choiceCriarFilmeClassificacao.setValue(ClassificacaoFilme.LIVRE);
        choiceCriarFilmeGenero.setValue(null);
    }

    @FXML
    void criarSessao(ActionEvent event) {
        String filmeIdInput = inputCriarSessaoFilmeId.getText();
        LocalDate dataInput = dateCriarSessao.getValue();
        String horarioInput = inputCriarSessaoHorario.getText();
        Double valorInput = spinCriarSessaoValor.getValue();
        String salaIdInput = inputCriarSessaoSalaId.getText();

        long filme;
        long sala;
        Instant horario;
        BigDecimal valor;

        try {
            filme = Long.parseLong(filmeIdInput);
        } catch (Exception e){
            showErrorAlert("ID de filme inválido");
            return;
        }

        try {
            sala = Long.parseLong(salaIdInput);
        } catch (Exception e){
            showErrorAlert("ID de sala inválido");
            return;
        }

        String horarioStr = dataInput + "T" + horarioInput + ":00Z";

        try {
            horario = Instant.parse(horarioStr);
        } catch (Exception e) {
            showErrorAlert("Data ou Horário inválido");
            return;
        }

        if (valorInput <= 0){
            showErrorAlert("Valor inválido");
            return;
        }

        try {
            valor = BigDecimal.valueOf(valorInput);
        } catch (Exception e) {
            showErrorAlert("Valor inválido");
            return;
        }

        try {
            createSessaoInteractor.createSessao(new CreateSessaoRequest(
                    horario, valor, filme, sala
            ));

            limparCriarSessaoForms();

            showInfoAlert("Sessão criada!");
        } catch (Exception e){
            showErrorAlert(e.getMessage());
        }
    }

    private void limparCriarSessaoForms() {
        inputCriarSessaoFilmeId.clear();
        dateCriarSessao.setValue(null);
        inputCriarSessaoHorario.clear();

        while (spinCriarSessaoValor.getValue() > 0){
            spinCriarSessaoValor.decrement();
        }

        inputCriarSessaoSalaId.clear();
    }

    @FXML
    void buscarSessao(ActionEvent event) {
        String idInput = inputBuscarSessaoId.getText();

        if (idInput == null || idInput.isEmpty()){
            buscarTodasSessoes();
            return;
        }

        else {
            long id;

            try {
                id = Long.parseLong(idInput);
            } catch (Exception e) {
                showErrorAlert("ID inválido");
                return;
            }

            buscarSessaoPorId(id);
        }
    }

    private void buscarTodasSessoes(){
        tableSessaoItems.clear();

        tableSessaoItems.addAll(getAllSessoesInteractor.getAllSessoes().stream()
                .map(sessao -> new TableSessaoItem(
                        sessao.id(),
                        sessao.filme().nome(),
                        LocalDate.ofInstant(sessao.horario(), ZoneOffset.UTC),
                        sessao.horario(),
                        sessao.valor(),
                        sessao.sala().numero(),
                        sessao.vagas().size()
                ))
                .toList()
        );
    }

    private void buscarSessaoPorId(long id){
        tableSessaoItems.clear();

        Optional<SessaoResponse> result = getSessaoByIdInteractor.getById(id);

        if (result.isEmpty()){
            showErrorAlert("Sessão não encontrada");
            return;
        }

        tableSessaoItems.add(
                new TableSessaoItem(
                        result.get().id(),
                        result.get().filme().nome(),
                        LocalDate.from(result.get().horario()),
                        result.get().horario(),
                        result.get().valor(),
                        result.get().sala().numero(),
                        result.get().vagas().size()
                )
        );
    }


    private void showErrorAlert(String content){
        new Alert(Alert.AlertType.ERROR, content).show();
    }

    private void showInfoAlert(String content){
        new Alert(Alert.AlertType.INFORMATION, content).show();
    }
}
