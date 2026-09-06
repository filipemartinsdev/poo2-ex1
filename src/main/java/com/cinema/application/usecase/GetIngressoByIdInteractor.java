package com.cinema.application.usecase;

import com.cinema.application.dto.IngressoResponse;
import com.cinema.application.gateway.IngressoGateway;
import com.cinema.application.mapper.IngressoMapper;

import java.util.Optional;

public class GetIngressoByIdInteractor {
    private final IngressoGateway ingressoGateway;
    private final IngressoMapper ingressoMapper;

    public GetIngressoByIdInteractor(IngressoGateway ingressoGateway, IngressoMapper ingressoMapper) {
        this.ingressoGateway = ingressoGateway;
        this.ingressoMapper = ingressoMapper;
    }

    public Optional<IngressoResponse> getById(long id){
        return ingressoGateway.findIngressoById(id).map(ingressoMapper::toResponse);
    }
}
