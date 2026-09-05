package com.cinema.application.usecase;

import com.cinema.application.dto.IngressoResponse;
import com.cinema.application.gateway.IngressoGateway;
import com.cinema.application.mapper.IngressoMapper;

import java.util.List;

public class GetAllIngressosInteractor {
    private final IngressoGateway ingressoGateway;
    private final IngressoMapper ingressoMapper;

    public GetAllIngressosInteractor(IngressoGateway ingressoGateway, IngressoMapper ingressoMapper) {
        this.ingressoGateway = ingressoGateway;
        this.ingressoMapper = ingressoMapper;
    }

    public List<IngressoResponse> getAllIngressos(){
        return ingressoGateway.findAllIngressos()
                .stream()
                .map(ingressoMapper::toResponse)
                .toList();
    }
}
