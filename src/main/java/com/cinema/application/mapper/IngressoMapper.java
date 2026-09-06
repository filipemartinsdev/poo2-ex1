package com.cinema.application.mapper;

import com.cinema.application.dto.IngressoResponse;
import com.cinema.domain.entity.Ingresso;

public class IngressoMapper {
    public IngressoResponse toResponse(Ingresso domain){
        return new IngressoResponse(
                domain.getId(),
                domain.getTipo().description,
                domain.getSessao().getId(),
                domain.getSessao().getHorario(),
                domain.getSessao().getSala().getNumero(),
                domain.getAssento().getNumero(),
                domain.getCliente().getNome(),
                domain.getVendedor().getNome()
        );
    }
}
