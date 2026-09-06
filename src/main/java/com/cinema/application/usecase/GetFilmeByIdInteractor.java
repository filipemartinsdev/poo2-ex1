package com.cinema.application.usecase;

import com.cinema.application.dto.FilmeResponse;
import com.cinema.application.gateway.FilmeGateway;
import com.cinema.application.mapper.FilmeMapper;
import com.cinema.domain.entity.Filme;

import java.util.Optional;

public class GetFilmeByIdInteractor {
    private final FilmeGateway filmeGateway;
    private final FilmeMapper filmeMapper;

    public GetFilmeByIdInteractor(FilmeGateway filmeGateway, FilmeMapper filmeMapper) {
        this.filmeGateway = filmeGateway;
        this.filmeMapper = filmeMapper;
    }

    public Optional<FilmeResponse> getById(long id){
        Optional<Filme> filme = filmeGateway.findFilmeById(id);
        return filme.map(filmeMapper::toResponse);
    }
}
