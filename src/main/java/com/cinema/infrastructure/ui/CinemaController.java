package com.cinema.infrastructure.ui;

import com.cinema.application.mapper.*;
import com.cinema.application.usecase.*;
import com.cinema.domain.entity.CategoriaSala;
import com.cinema.domain.entity.ClassificacaoFilme;
import com.cinema.domain.entity.GeneroFilme;
import com.cinema.domain.entity.TipoIngresso;
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

public class CinemaController {
    private final InMemoryRepository repository = new InMemoryRepository();
    private final UsuarioMapper usuarioMapper = new UsuarioMapper();
    private final FilmeMapper filmeMapper = new FilmeMapper();
    private final SalaMapper salaMapper = new SalaMapper();
    private final SessaoMapper sessaoMapper = new SessaoMapper();
    private final IngressoMapper ingressoMapper = new IngressoMapper();

    private final GetAllClientesInteractor getAllClientesInteractor = new GetAllClientesInteractor(repository, usuarioMapper);
    private final CreateClienteInteractor createClienteInteractor = new CreateClienteInteractor(repository, usuarioMapper);
    private final GetAllFuncionariosInteractor getAllFuncionariosInteractor = new GetAllFuncionariosInteractor(repository, usuarioMapper);
    private final CreateFuncionarioInteractor createFuncionarioInteractor = new CreateFuncionarioInteractor(repository, usuarioMapper);
    private final CreateFilmeInteractor createFilmeInteractor = new CreateFilmeInteractor(repository, filmeMapper);
    private final GetAllFilmesInteractor getAllFilmesInteractor = new GetAllFilmesInteractor(repository, filmeMapper);
    private final GetAllSalasInteractor getAllSalasInteractor = new GetAllSalasInteractor(repository, salaMapper);
    private final CreateSalaInteractor createSalaInteractor = new CreateSalaInteractor(repository, salaMapper);
    private final GetAllSessoesInteractor getAllSessoesInteractor = new GetAllSessoesInteractor(repository, sessaoMapper);
    private final CreateSessaoInteractor createSessaoInteractor = new CreateSessaoInteractor(repository, repository, repository, sessaoMapper);
    private final GetAllIngressosInteractor getAllIngressosInteractor = new GetAllIngressosInteractor(repository, ingressoMapper);
    private final ComprarIngressoInteractor comprarIngressoInteractor = new ComprarIngressoInteractor(repository, repository, repository, repository, ingressoMapper);

    private DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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
    private ChoiceBox<TipoIngresso> choiceTipoIngresso;

    @FXML
    private ChoiceBox<String> choiceCargoUsuario;

    @FXML
    private ChoiceBox<ClassificacaoFilme> choiceCriarFilmeClassificacao;

    @FXML
    private ChoiceBox<GeneroFilme> choiceCriarFilmeGenero;

    @FXML
    private ChoiceBox<CategoriaSala> choiceCriarSalaCategoria;

    @FXML
    private DatePicker dataCriarSessao;

    @FXML
    private TextField inputBuscarSalaNumero;

    @FXML
    private TextField inputBuscarSessaoId;

    @FXML
    private TextField inputBuscarUsuario;

    @FXML
    private TextField inputCPFUsuario;

    @FXML
    private TextField inputCriarFilmeNome;

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

    @FXML
    private TextField inputNomeUsuario;

    @FXML
    private Spinner<Integer> spinCriarSalaAssentos;

    @FXML
    private Spinner<Integer> spinCriarSessaoDuracao;

    @FXML
    private CheckBox checkCriarSessaoTodosAssentos;

    @FXML
    private Spinner<Integer> spinCriarSessaoVagas;

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
    private TableColumn<TableIngressoItem, TipoIngresso> colIngressoTipo;

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
        Platform.runLater(this::setupChoiceCargoUsuario);
        Platform.runLater(this::setupChoiceTipoIngresso);

        Platform.runLater(this::setupDataCriarSessao);
        Platform.runLater(this::setupSpinCriarSessaoValor);
        Platform.runLater(this::setupSpinCriarSessaoVagas);
        Platform.runLater(this::setupCheckCriarSessaoTodosAssentos);

        Platform.runLater(this::setupSpinCriarSessaoDuracao);
        Platform.runLater(this::setupChoiceCriarFilmeGenero);
        Platform.runLater(this::setupChoiceCriarFilmeClassificacao);

        Platform.runLater(this::setupChoiceCriarSalaCategoria);
        Platform.runLater(this::setupSpinCriarSalaAssentos);

        Platform.runLater(this::setupTableUsuario);
        Platform.runLater(this::setupTableIngresso);
        Platform.runLater(this::setupTableSessao);
        Platform.runLater(this::setupTableFilme);
        Platform.runLater(this::setupTableSala);
    }

    private void setupChoiceCargoUsuario(){
        choiceCargoUsuario.getItems().add("Cliente");
        choiceCargoUsuario.getItems().add("Funcionário");
    }


    private void setupChoiceTipoIngresso(){
        choiceTipoIngresso.setConverter(new StringConverter<TipoIngresso>() {
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
            choiceTipoIngresso.getItems().add(tipo);
    }


    private void setupDataCriarSessao(){
        dataCriarSessao.setConverter(new StringConverter<LocalDate>() {
            @Override
            public String toString(LocalDate object) {
                return object != null ? dataFormatter.format(object) : "";
            }

            @Override
            public LocalDate fromString(String string) {
                try {
                    return string != null && !string.isEmpty()
                            ? LocalDate.parse(string, dataFormatter)
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

    private void setupSpinCriarSessaoVagas(){
        spinCriarSessaoVagas.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE, 0));
        spinCriarSessaoVagas.setEditable(true);
    }

    private void setupCheckCriarSessaoTodosAssentos(){
        checkCriarSessaoTodosAssentos.setOnAction(event -> {
            spinCriarSessaoVagas.setDisable(checkCriarSessaoTodosAssentos.isSelected());
        });
    }

    private void setupSpinCriarSessaoDuracao(){
        spinCriarSessaoDuracao.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE, 0));
        spinCriarSessaoDuracao.setEditable(true);
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
    }

    private void setupSpinCriarSalaAssentos(){
        spinCriarSalaAssentos.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE, 0));
        spinCriarSalaAssentos.setEditable(true);
    }


    private void setupTableUsuario(){
        tableUsuario.setItems(tableUsuarioItems);

        setupColUsuarioId();
        setupColUsuarioNome();
        setupColUsuarioCargo();
        setupColUsuarioCpf();
    }

    private void setupColUsuarioId(){
        colUsuarioId.setCellValueFactory(new PropertyValueFactory<>("id"));
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
            protected void updateItem(TipoIngresso item, boolean empty){
                setText(item.description);
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

    private void setupColSessaoHorario(){
        colSessaoHorario.setCellValueFactory(new PropertyValueFactory<>("horario"));

        colSessaoHorario.setCellFactory(column -> new TableCell<>(){
            @Override
            protected void updateItem(Instant item, boolean empty){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm")
                        .withZone(ZoneOffset.UTC);

                setText(formatter.format(item));
            }
        });
    }

    private void setupColSessaoValor(){
        colSessaoValor.setCellValueFactory(new PropertyValueFactory<>("valor"));

        colSessaoValor.setCellFactory(column -> new TableCell<>(){
            @Override
            protected void updateItem(BigDecimal item, boolean empty){
                setText("R$ %.2f".formatted(item.floatValue()));
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
                setText(item.description);
            }
        });
    }

    private void setupColFilmeClassificacao() {
        colFilmeClassificacao.setCellValueFactory(new PropertyValueFactory<>("classificacao"));

        colFilmeClassificacao.setCellFactory(column -> new TableCell<>(){
            @Override
            protected void updateItem(ClassificacaoFilme item, boolean empty){
                setText(item.description);
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
                setText(item.description);
            }
        });
    }

    private void setupColSalaAssentos(){
        colSalaAssentos.setCellValueFactory(new PropertyValueFactory<>("assentos"));
    }


    @FXML
    void buscarFilme(ActionEvent event) {
        new Alert(Alert.AlertType.INFORMATION, "Filme encontrado!").show();
    }

    @FXML
    void buscarSala(ActionEvent event) {
        new Alert(Alert.AlertType.INFORMATION, "Sala encontrada!").show();
    }

    @FXML
    void buscarUsuario(ActionEvent event) {
        new Alert(Alert.AlertType.INFORMATION, "Usuário encontrado!").show();
    }

    @FXML
    void buscarIngresso(ActionEvent event) {
        new Alert(Alert.AlertType.INFORMATION, "Ingresso encontrado!").show();
    }

    @FXML
    void comprarIngresso(ActionEvent event) {
        new Alert(Alert.AlertType.INFORMATION, "Ingresso comprado!").show();
    }

    @FXML
    void criarFilme(ActionEvent event) {
        new Alert(Alert.AlertType.INFORMATION, "Filme criado!").show();
    }

    @FXML
    void criarSala(ActionEvent event) {
        new Alert(Alert.AlertType.INFORMATION, "Sala criada!").show();
    }

    @FXML
    void criarSessao(ActionEvent event) {
        new Alert(Alert.AlertType.INFORMATION, "Sessão criada!").show();
    }

    @FXML
    void buscarSessao(ActionEvent event) {
        new Alert(Alert.AlertType.INFORMATION, "Sessão encontrada!").show();
    }

    @FXML
    void criarUsuario(ActionEvent event) {
        new Alert(Alert.AlertType.INFORMATION, "Usuário criado!").show();
    }
}
