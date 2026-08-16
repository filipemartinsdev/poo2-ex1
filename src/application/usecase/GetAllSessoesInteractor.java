package application.usecase;

import application.dto.SessaoResponse;
import application.gateway.SessaoGateway;
import application.mapper.SessaoMapper;
import domain.entity.Sessao;

import java.util.List;

public class GetAllSessoesInteractor {
    private final SessaoGateway sessaoGateway;
    private final SessaoMapper sessaoMapper;

    public GetAllSessoesInteractor(SessaoGateway sessaoGateway, SessaoMapper sessaoMapper) {
        this.sessaoGateway = sessaoGateway;
        this.sessaoMapper = sessaoMapper;
    }

    public List<SessaoResponse> getAllSessoes(){
        return sessaoGateway.findAllSessao()
                .stream()
                .map(sessaoMapper::toResponse)
                .toList();
    }
}
