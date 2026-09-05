package com.cinema.application.mapper;

import com.cinema.application.dto.FilmeResponse;
import com.cinema.domain.entity.Filme;

public class FilmeMapper {
    public FilmeResponse toResponse(Filme domain){
        return new FilmeResponse(
                domain.getId(),
                domain.getNome(),
                domain.getDescricao(),
                domain.getDuracao(),
                new FilmeResponse.Genero(
                        domain.getGenero().id, domain.getGenero().description
                ),
                new FilmeResponse.Classificacao(
                        domain.getClassificacao().id, domain.getClassificacao().description
                )
        );
    }
}
