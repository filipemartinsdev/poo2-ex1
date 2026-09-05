package com.cinema.application.usecase;

import com.cinema.application.dto.CreateFilmeRequest;
import com.cinema.application.dto.FilmeResponse;
import com.cinema.application.gateway.FilmeGateway;
import com.cinema.application.mapper.FilmeMapper;
import com.cinema.domain.entity.ClassificacaoFilme;
import com.cinema.domain.entity.Filme;
import com.cinema.domain.entity.GeneroFilme;

public class CreateFilmeInteractor {
    private final FilmeGateway filmeGateway;
    private final FilmeMapper filmeMapper;

    public CreateFilmeInteractor(FilmeGateway filmeGateway, FilmeMapper filmeMapper) {
        this.filmeGateway = filmeGateway;
        this.filmeMapper = filmeMapper;
    }

    public FilmeResponse createFilme(CreateFilmeRequest request){
        var filme = new Filme(
                request.nome(),
                request.descricao(),
                request.duracao(),
                GeneroFilme.getById(request.generoId()),
                ClassificacaoFilme.getById(request.classificacaoId())
        );

        Filme created = filmeGateway.saveFilme(filme);

        return filmeMapper.toResponse(created);
    }
}
