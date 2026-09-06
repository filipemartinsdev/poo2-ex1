package com.cinema;

import com.cinema.application.mapper.*;
import com.cinema.application.usecase.*;
import com.cinema.infrastructure.persistence.InMemoryRepository;

public class DependencyRegistry {
    public final InMemoryRepository repository;
    public final UsuarioMapper usuarioMapper;
    public final FilmeMapper filmeMapper;
    public final SalaMapper salaMapper;
    public final SessaoMapper sessaoMapper;
    public final IngressoMapper ingressoMapper;

    public final GetAllClientesInteractor getAllClientesInteractor;
    public final GetClienteByCpfInteractor getClienteByCpfInteractor;
    public final CreateClienteInteractor createClienteInteractor;
    public final GetAllFuncionariosInteractor getAllFuncionariosInteractor;
    public final GetFuncionarioByCpfInteractor getFuncionarioByCpfInteractor;
    public final CreateFuncionarioInteractor createFuncionarioInteractor;
    public final CreateFilmeInteractor createFilmeInteractor;
    public final GetAllFilmesInteractor getAllFilmesInteractor;
    public final GetFilmeByIdInteractor getFilmeByIdInteractor;
    public final GetAllSalasInteractor getAllSalasInteractor;
    public final GetSalaByNumeroInteractor getSalaByNumeroInteractor;
    public final CreateSalaInteractor createSalaInteractor;
    public final GetAllSessoesInteractor getAllSessoesInteractor;
    public final GetSessaoByIdInteractor getSessaoByIdInteractor;
    public final CreateSessaoInteractor createSessaoInteractor;
    public final GetAllIngressosInteractor getAllIngressosInteractor;
    public final GetIngressoByIdInteractor getIngressoByIdInteractor;
    public final ComprarIngressoInteractor comprarIngressoInteractor;

    public DependencyRegistry(
            InMemoryRepository repository,
            UsuarioMapper usuarioMapper,
            FilmeMapper filmeMapper,
            SalaMapper salaMapper,
            SessaoMapper sessaoMapper,
            IngressoMapper ingressoMapper,
            GetAllClientesInteractor getAllClientesInteractor,
            GetClienteByCpfInteractor getClienteByCpfInteractor,
            CreateClienteInteractor createClienteInteractor,
            GetAllFuncionariosInteractor getAllFuncionariosInteractor,
            GetFuncionarioByCpfInteractor getFuncionarioByCpfInteractor,
            CreateFuncionarioInteractor createFuncionarioInteractor,
            CreateFilmeInteractor createFilmeInteractor,
            GetAllFilmesInteractor getAllFilmesInteractor,
            GetFilmeByIdInteractor getFilmeByIdInteractor,
            GetAllSalasInteractor getAllSalasInteractor,
            GetSalaByNumeroInteractor getSalaByNumeroInteractor,
            CreateSalaInteractor createSalaInteractor,
            GetAllSessoesInteractor getAllSessoesInteractor,
            GetSessaoByIdInteractor getSessaoByIdInteractor,
            CreateSessaoInteractor createSessaoInteractor,
            GetAllIngressosInteractor getAllIngressosInteractor,
            GetIngressoByIdInteractor getIngressoByIdInteractor,
            ComprarIngressoInteractor comprarIngressoInteractor
    ) {
        this.repository = repository;
        this.usuarioMapper = usuarioMapper;
        this.filmeMapper = filmeMapper;
        this.salaMapper = salaMapper;
        this.sessaoMapper = sessaoMapper;
        this.ingressoMapper = ingressoMapper;
        this.getAllClientesInteractor = getAllClientesInteractor;
        this.getClienteByCpfInteractor = getClienteByCpfInteractor;
        this.createClienteInteractor = createClienteInteractor;
        this.getAllFuncionariosInteractor = getAllFuncionariosInteractor;
        this.getFuncionarioByCpfInteractor = getFuncionarioByCpfInteractor;
        this.createFuncionarioInteractor = createFuncionarioInteractor;
        this.createFilmeInteractor = createFilmeInteractor;
        this.getAllFilmesInteractor = getAllFilmesInteractor;
        this.getFilmeByIdInteractor = getFilmeByIdInteractor;
        this.getAllSalasInteractor = getAllSalasInteractor;
        this.getSalaByNumeroInteractor = getSalaByNumeroInteractor;
        this.createSalaInteractor = createSalaInteractor;
        this.getAllSessoesInteractor = getAllSessoesInteractor;
        this.getSessaoByIdInteractor = getSessaoByIdInteractor;
        this.createSessaoInteractor = createSessaoInteractor;
        this.getAllIngressosInteractor = getAllIngressosInteractor;
        this.getIngressoByIdInteractor = getIngressoByIdInteractor;
        this.comprarIngressoInteractor = comprarIngressoInteractor;
    }
}
