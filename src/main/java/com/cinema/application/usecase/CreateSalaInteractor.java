package com.cinema.application.usecase;

import com.cinema.application.dto.CreateSalaRequest;
import com.cinema.application.dto.SalaResponse;
import com.cinema.application.gateway.SalaGateway;
import com.cinema.application.mapper.SalaMapper;
import com.cinema.domain.entity.Assento;
import com.cinema.domain.entity.CategoriaSala;
import com.cinema.domain.entity.Sala;

import java.util.ArrayList;

public class CreateSalaInteractor {
    private final SalaGateway salaGateway;
    private final SalaMapper salaMapper;

    public CreateSalaInteractor(SalaGateway salaGateway, SalaMapper salaMapper) {
        this.salaGateway = salaGateway;
        this.salaMapper = salaMapper;
    }

    public SalaResponse createSala(CreateSalaRequest request){
        var sala = new Sala(
                CategoriaSala.getById(request.categoriaId()),
                new ArrayList<>()
        );

        if (sala.getCategoria().equals(CategoriaSala.PREMIUM))
            fillAssentosReclinaveis(sala, request.assentosCount());

        else
            fillAssentos(sala, request.assentosCount());

        Sala created = salaGateway.saveSala(sala);

        return salaMapper.toResponse(created);
    }

    private void fillAssentosReclinaveis(Sala sala, int assentosCount) {
        for (int i = 0; i < assentosCount; i++)
            sala.getAssentos().add(new Assento(i, true));
    }

    private void fillAssentos(Sala sala, int assentosCount) {
        for (int i = 0; i < assentosCount; i++)
            sala.getAssentos().add(new Assento(i, false));
    }
}
