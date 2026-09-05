package com.cinema.application.usecase;

import com.cinema.application.dto.SessaoResponse;
import com.cinema.application.gateway.SessaoGateway;
import com.cinema.application.mapper.SessaoMapper;

import java.util.List;

public class GelAllSessoesByFilmeIdInteractor {
    public SessaoGateway sessaoGateway;
    public SessaoMapper sessaoMapper;

    public GelAllSessoesByFilmeIdInteractor(SessaoGateway sessaoGateway) {
        this.sessaoGateway = sessaoGateway;
    }

    public List<SessaoResponse> getAllSessoesByFilmeId(long id){
        return sessaoGateway.findAllSessoesByFilmeId(id)
                .stream()
                .map(sessaoMapper::toResponse)
                .toList();
    }
}
