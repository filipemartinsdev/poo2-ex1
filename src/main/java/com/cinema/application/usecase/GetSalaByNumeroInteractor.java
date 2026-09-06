package com.cinema.application.usecase;

import com.cinema.application.dto.SalaResponse;
import com.cinema.application.gateway.SalaGateway;
import com.cinema.application.mapper.SalaMapper;

import java.util.Optional;

public class GetSalaByNumeroInteractor {
    private final SalaGateway salaGateway;
    private final SalaMapper salaMapper;

    public GetSalaByNumeroInteractor(SalaGateway salaGateway, SalaMapper salaMapper) {
        this.salaGateway = salaGateway;
        this.salaMapper = salaMapper;
    }

    public Optional<SalaResponse> getByNumero(long numero){
        return salaGateway.findSalaByNumero(numero).map(salaMapper::toResponse);
    }
}
