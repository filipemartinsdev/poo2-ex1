package application.usecase;

import application.dto.IngressoResponse;
import application.gateway.IngressoGateway;
import application.mapper.IngressoMapper;

import java.util.List;

public class GetAllIngressosInteractor {
    private final IngressoGateway ingressoGateway;
    private final IngressoMapper ingressoMapper;

    public GetAllIngressosInteractor(IngressoGateway ingressoGateway, IngressoMapper ingressoMapper) {
        this.ingressoGateway = ingressoGateway;
        this.ingressoMapper = ingressoMapper;
    }

    public List<IngressoResponse> getAllIngressos(){
        return ingressoGateway.findAllIngresso()
                .stream()
                .map(ingressoMapper::toResponse)
                .toList();
    }
}
