package application.usecase;

import application.dto.CreateSalaRequest;
import application.dto.SalaResponse;
import application.gateway.SalaGateway;
import application.mapper.SalaMapper;
import domain.entity.Assento;
import domain.entity.CategoriaSala;
import domain.entity.Sala;

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
