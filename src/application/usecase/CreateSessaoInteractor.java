package application.usecase;

import application.dto.CreateSessaoRequest;
import application.dto.SessaoResponse;
import application.gateway.FilmeGateway;
import application.gateway.SalaGateway;
import application.gateway.SessaoGateway;
import application.mapper.SessaoMapper;
import domain.entity.Assento;
import domain.entity.CategoriaSala;
import domain.entity.Sessao;
import domain.entity.Vaga;

import java.util.ArrayList;
import java.util.List;

public class CreateSessaoInteractor {
    private final SessaoGateway sessaoGateway;
    private final FilmeGateway filmeGateway;
    private final SalaGateway salaGateway;
    private final SessaoMapper sessaoMapper;

    public CreateSessaoInteractor(SessaoGateway sessaoGateway, FilmeGateway filmeGateway, SalaGateway salaGateway, SessaoMapper sessaoMapper) {
        this.sessaoGateway = sessaoGateway;
        this.filmeGateway = filmeGateway;
        this.salaGateway = salaGateway;
        this.sessaoMapper = sessaoMapper;
    }

    public SessaoResponse createSessao(CreateSessaoRequest request){
        var filme = filmeGateway.findFilmeById(request.filmeId())
                .orElseThrow(() -> new RuntimeException("Filme inválido"));

        var sala = salaGateway.findSalaByNumero(request.salaNumero())
                .orElseThrow(() -> new RuntimeException("Sala inválida"));

        List<Vaga> vagas = createVagas(sala.getCategoria(), sala.getAssentos());

        var sessao = new Sessao(
                request.horario(),
                request.valor(),
                filme,
                sala,
                vagas
        );

        Sessao created = sessaoGateway.saveSessao(sessao);

        return sessaoMapper.toResponse(created);
    }

    private List<Vaga> createVagas(CategoriaSala categoriaSala, List<Assento> assentos) {
        if (categoriaSala.equals(CategoriaSala.PREMIUM))
            return vagasPremium(assentos);
        else
            return vagasComum(assentos);
    }

    private List<Vaga> vagasPremium(List<Assento> assentos) {
        List<Vaga> vagas = new ArrayList<>();

        for (int i = 0; i < assentos.size(); i++) {
            vagas.add(new Vaga(i, assentos.get(i)));
        }

        return vagas;
    }

    private List<Vaga> vagasComum(List<Assento> assentos) {
        List<Vaga> vagas = new ArrayList<>();

        for (int i = 0; i < assentos.size(); i++) {
            vagas.add(new Vaga(i, assentos.get(i)));
        }

        return vagas;
    }
}
