package application.mapper;

import application.dto.FilmeResponse;
import application.dto.SalaResponse;
import application.dto.SessaoResponse;
import domain.entity.Sessao;

public class SessaoMapper {
    public SessaoResponse toResponse(Sessao domain){
        return new SessaoResponse(
                domain.getId(),
                domain.getHorario(),
                new FilmeResponse(
                        domain.getFilme().getId(),
                        domain.getFilme().getNome(),
                        domain.getFilme().getDescricao(),
                        domain.getFilme().getDuracao(),
                        new FilmeResponse.Genero(
                                domain.getFilme().getGenero().id,
                                domain.getFilme().getGenero().description
                        ),
                        new FilmeResponse.Classificacao(
                                domain.getFilme().getClassificacao().id,
                                domain.getFilme().getClassificacao().description
                        )
                ),
                new SalaResponse(
                        domain.getSala().getNumero(),
                        new SalaResponse.Categoria(
                                domain.getSala().getCategoria().id,
                                domain.getSala().getCategoria().description
                        ),
                        domain.getSala().getAssentos().size()
                ),
                domain.getValor(),
                domain.getVagas().stream()
                        .map(v -> new SessaoResponse.VagaResponse(
                                new SessaoResponse.AssentoResponse(
                                        v.getAssento().getNumero(),
                                        v.getAssento().getReclinavel()
                                ),
                                v.getLivre()
                        ))
                        .toList()
        );
    }
}
