package com.cinema.application.gateway;

import com.cinema.domain.entity.Ingresso;

import java.util.List;
import java.util.Optional;

public interface IngressoGateway {
    Ingresso saveIngresso(Ingresso ingresso);

    List<Ingresso> findAllIngressos();

    Optional<Ingresso> findIngressoById(long id);
}
