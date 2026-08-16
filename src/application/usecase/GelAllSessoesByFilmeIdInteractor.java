package application.usecase;

import application.dto.SessaoResponse;
import application.gateway.SessaoGateway;
import application.mapper.SessaoMapper;

import java.util.List;

public class GelAllSessoesByFilmeIdInteractor {
    public SessaoGateway sessaoGateway;
    public SessaoMapper sessaoMapper;

    public GelAllSessoesByFilmeIdInteractor(SessaoGateway sessaoGateway) {
        this.sessaoGateway = sessaoGateway;
    }

    public List<SessaoResponse> getAllSessoesByFilmeId(long id){
        return sessaoGateway.findAllSessoesByFilmeId(id)
                .stream()
                .map(sessaoMapper::toResponse)
                .toList();
    }
}
