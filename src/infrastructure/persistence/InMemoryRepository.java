package infrastructure.persistence;

import domain.entity.*;
import application.gateway.*;

import java.util.*;

public class InMemoryRepository implements
        FuncionarioGateway,
        ClienteGateway,
        SalaGateway,
        FilmeGateway,
        SessaoGateway,
        IngressoGateway
{
    private final Map<Long, Filme> filmes = new HashMap<>();
    private long lastIdFilme = 0;

    private final Map<Long, Ingresso> ingressos = new HashMap<>();
    private long lastIdIngresso = 0;

    private final Map<Long, Sala> salas = new HashMap<>();
    private long lastIdSala = 0;

    private final Map<Long, Sessao> sessoes = new HashMap<>();
    private long lastIdSessao = 0;

    private final Map<String, Cliente> clientes = new HashMap<>();

    private final Map<String, Funcionario> funcionarios = new HashMap<>();


    @Override
    public Cliente saveCliente(Cliente cliente) {
        clientes.put(cliente.getCpf(), cliente);
        return cliente;
    }

    @Override
    public Optional<Cliente> findClienteByCpf(String cpf) {
        var cliente = clientes.get(cpf);
        return cliente != null ? Optional.of(cliente) : Optional.empty();
    }

    @Override
    public List<Cliente> findAllClientes() {
        return clientes.values().stream().toList();
    }

    @Override
    public Filme saveFilme(Filme filme) {
        if (filme.getId() == null)
            filme.setId(++lastIdFilme);

        filmes.put(filme.getId(), filme);
        return filme;
    }

    @Override
    public Optional<Filme> findFilmeById(Long id) {
        var filme = filmes.get(id);
        return filme != null ? Optional.of(filme) : Optional.empty();
    }

    @Override
    public List<Filme> findAllFilmes() {
        return filmes.values().stream().toList();
    }

    @Override
    public List<Funcionario> findAllFuncionarios() {
        return funcionarios.values().stream().toList();
    }

    @Override
    public Funcionario saveFuncionario(Funcionario funcionario) {
        funcionarios.put(funcionario.getCpf(), funcionario);
        return funcionario;
    }

    @Override
    public Optional<Funcionario> findFuncionarioByCpf(String cpf) {
        var funcionario = funcionarios.get(cpf);
        return funcionario != null ? Optional.of(funcionario) : Optional.empty();
    }

    @Override
    public Ingresso saveIngresso(Ingresso ingresso) {
        if (ingresso.getId() == null)
            ingresso.setId(++lastIdIngresso);

        ingressos.put(ingresso.getId(), ingresso);
        return ingresso;
    }

    @Override
    public List<Ingresso> findAllIngressos() {
        return ingressos.values().stream().toList();
    }

    @Override
    public Sala saveSala(Sala sala) {
        if (sala.getNumero() == null)
            sala.setNumero(++lastIdSala);

        salas.put(sala.getNumero(), sala);
        return sala;
    }

    @Override
    public Optional<Sala> findSalaByNumero(Long numero) {
        var sala = salas.get(numero);
        return sala != null ? Optional.of(sala) : Optional.empty();
    }

    @Override
    public List<Sala> findAllSalas() {
        return salas.values().stream().toList();
    }

    @Override
    public Sessao saveSessao(Sessao sessao) {
        if (sessao.getId() == null)
            sessao.setId(++lastIdSessao);

        sessoes.put(sessao.getId(), sessao);
        return sessao;
    }

    @Override
    public Optional<Sessao> findSessaoById(long id) {
        return sessoes.values().stream()
                .filter(s -> s.getId() == id)
                .findFirst();
    }

    @Override
    public List<Sessao> findAllSessoesByFilmeId(long id) {
        return sessoes.values().stream()
                .filter(s -> s.getFilme().getId() == id)
                .toList();
    }

    @Override
    public List<Sessao> findAllSessoes() {
        return sessoes.values().stream().toList();
    }
}
