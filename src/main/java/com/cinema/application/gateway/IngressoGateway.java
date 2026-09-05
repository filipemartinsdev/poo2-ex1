package com.cinema.application.gateway;

import com.cinema.domain.entity.Ingresso;

import java.util.List;

public interface IngressoGateway {
    Ingresso saveIngresso(Ingresso ingresso);

    List<Ingresso> findAllIngressos();
}
