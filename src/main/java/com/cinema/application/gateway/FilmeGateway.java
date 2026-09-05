package com.cinema.application.gateway;

import com.cinema.domain.entity.Filme;

import java.util.List;
import java.util.Optional;

public interface FilmeGateway {
    Filme saveFilme(Filme filme);

    Optional<Filme> findFilmeById(Long id);

    List<Filme> findAllFilmes();
}
