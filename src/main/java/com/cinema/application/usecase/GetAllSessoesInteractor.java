package com.cinema.application.usecase;

import com.cinema.application.dto.SessaoResponse;
import com.cinema.application.gateway.SessaoGateway;
import com.cinema.application.mapper.SessaoMapper;

import java.util.List;

public class GetAllSessoesInteractor {
    private final SessaoGateway sessaoGateway;
    private final SessaoMapper sessaoMapper;

    public GetAllSessoesInteractor(SessaoGateway sessaoGateway, SessaoMapper sessaoMapper) {
        this.sessaoGateway = sessaoGateway;
        this.sessaoMapper = sessaoMapper;
    }

    public List<SessaoResponse> getAllSessoes(){
        return sessaoGateway.findAllSessoes()
                .stream()
                .map(sessaoMapper::toResponse)
                .toList();
    }
}
