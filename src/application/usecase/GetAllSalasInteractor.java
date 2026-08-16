package application.usecase;

import application.dto.SalaResponse;
import application.gateway.SalaGateway;
import application.mapper.SalaMapper;

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
