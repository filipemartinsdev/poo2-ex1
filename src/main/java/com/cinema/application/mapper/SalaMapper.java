package com.cinema.application.mapper;

import com.cinema.application.dto.SalaResponse;
import com.cinema.domain.entity.Sala;

public class SalaMapper {
    public SalaResponse toResponse(Sala domain) {
        return new SalaResponse(
                domain.getNumero(),
                new SalaResponse.Categoria(domain.getCategoria().id, domain.getCategoria().description),
                domain.getAssentos().size()
        );
    }
}
