package com.cinema.application.gateway;

import com.cinema.domain.entity.Sala;

import java.util.List;
import java.util.Optional;

public interface SalaGateway {
    Sala saveSala(Sala sala);

    Optional<Sala> findSalaByNumero(Long numero);

    List<Sala> findAllSalas();
}
