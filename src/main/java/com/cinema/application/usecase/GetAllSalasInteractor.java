package com.cinema.application.usecase;

import com.cinema.application.dto.SalaResponse;
import com.cinema.application.gateway.SalaGateway;
import com.cinema.application.mapper.SalaMapper;

import java.util.List;

public class GetAllSalasInteractor {
    private final SalaGateway salaGateway;
    private final SalaMapper salaMapper;

    public GetAllSalasInteractor(SalaGateway salaGateway, SalaMapper salaMapper) {
        this.salaGateway = salaGateway;
        this.salaMapper = salaMapper;
    }

    public List<SalaResponse> getAllSalas(){
        return salaGateway.findAllSalas()
                .stream()
                .map(salaMapper::toResponse)
                .toList();
    }
}
