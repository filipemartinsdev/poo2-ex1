package com.cinema.application.usecase;

import com.cinema.application.dto.SessaoResponse;
import com.cinema.application.gateway.SessaoGateway;
import com.cinema.application.mapper.SessaoMapper;

import java.util.Optional;

public class GetSessaoByIdInteractor {
    private final SessaoGateway sessaoGateway;
    private final SessaoMapper sessaoMapper;

    public GetSessaoByIdInteractor(SessaoGateway sessaoGateway, SessaoMapper sessaoMapper) {
        this.sessaoGateway = sessaoGateway;
        this.sessaoMapper = sessaoMapper;
    }

    public Optional<SessaoResponse> getById(long id){
        return sessaoGateway.findSessaoById(id).map(sessaoMapper::toResponse);
    }
}
