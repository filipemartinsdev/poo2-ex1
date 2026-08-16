package infrastructure.persistence;

import domain.entity.*;
import application.gateway.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Repository implements
        FuncionarioGateway,
        ClienteGateway,
        SalaGateway,
        FilmeGateway,
        SessaoGateway,
        IngressoGateway
{
    private final List<Filme> filmes = new ArrayList<>();
    private final List<Ingresso> ingressos = new ArrayList<>();
    private final List<Sala> salas = new ArrayList<>();
    private final List<Sessao> sessoes = new ArrayList<>();
    private final List<Cliente> clientes = new ArrayList<>();
    private final List<Funcionario> funcionarios = new ArrayList<>();


    @Override
    public Cliente saveCliente(Cliente cliente) {
        clientes.add(cliente);
        return cliente;
    }

    @Override
    public Optional<Cliente> findClienteByCpf(String cpf) {
        return clientes.stream()
                .filter(c -> c.getCpf().equals(cpf))
                .findFirst();
    }

    @Override
    public List<Cliente> findAllClientes() {
        return clientes;
    }

    @Override
    public Filme saveFilme(Filme filme) {
        if (filmes.isEmpty())
            filme.setId(0L);
        else
            filme.setId(filmes.getLast().getId() + 1);

        filmes.add(filme);
        return filme;
    }

    @Override
    public Optional<Filme> findFilmeById(Long id) {
        return filmes.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Filme> findAllFilmes() {
        return filmes;
    }

    @Override
    public List<Funcionario> findAllFuncionarios() {
        return funcionarios;
    }

    @Override
    public Funcionario saveFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        return funcionario;
    }

    @Override
    public Optional<Funcionario> findFuncionarioByCpf(String cpf) {
        return funcionarios.stream()
                .filter(f -> f.getCpf().equals(cpf))
                .findFirst();
    }

    @Override
    public Ingresso saveIngresso(Ingresso ingresso) {
        if (ingressos.isEmpty())
            ingresso.setId(0L);
        else
            ingresso.setId(ingressos.getLast().getId() + 1);

        ingressos.add(ingresso);
        return ingresso;
    }

    @Override
    public List<Ingresso> findAllIngresso() {
        return ingressos;
    }

    @Override
    public Sala saveSala(Sala sala) {
        if (salas.isEmpty())
            sala.setNumero(0L);
        else
            sala.setNumero(sala.getNumero() + 1);

        salas.add(sala);
        return sala;
    }

    @Override
    public Optional<Sala> findSalaByNumero(Long numero) {
        return salas.stream()
                .filter(s -> s.getNumero().equals(numero))
                .findFirst();
    }

    @Override
    public List<Sala> findAllSalas() {
        return salas;
    }

    @Override
    public Sessao saveSessao(Sessao sessao) {
        if (sessoes.isEmpty())
            sessao.setId(0L);
        else
            sessao.setId(sessoes.getLast().getId() + 1);

        sessoes.add(sessao);
        return sessao;
    }

    @Override
    public Optional<Sessao> findSessaoById(long id) {
        return sessoes.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
    }

    @Override
    public List<Sessao> findAllSessaoByFilmeId(long id) {
        return sessoes.stream()
                .filter(s -> s.getFilme().getId() == id)
                .toList();
    }

    @Override
    public List<Sessao> findAllSessao() {
        return sessoes;
    }
}
