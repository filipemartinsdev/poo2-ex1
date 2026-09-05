package com.cinema.application.usecase;

import com.cinema.application.dto.FilmeResponse;
import com.cinema.application.gateway.FilmeGateway;
import com.cinema.application.mapper.FilmeMapper;

import java.util.List;

public class GetAllFilmesInteractor {
    private final FilmeGateway filmeGateway;
    private final FilmeMapper filmeMapper;

    public GetAllFilmesInteractor(FilmeGateway filmeGateway, FilmeMapper filmeMapper) {
        this.filmeGateway = filmeGateway;
        this.filmeMapper = filmeMapper;
    }

    public List<FilmeResponse> getAllFilmes(){
        return filmeGateway.findAllFilmes()
                .stream()
                .map(filmeMapper::toResponse)
                .toList();
    }
}
