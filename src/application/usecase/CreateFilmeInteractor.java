package application.usecase;

import application.dto.CreateFilmeRequest;
import application.dto.FilmeResponse;
import application.gateway.FilmeGateway;
import application.mapper.FilmeMapper;
import domain.entity.ClassificacaoFilme;
import domain.entity.Filme;
import domain.entity.GeneroFilme;

public class CreateFilmeInteractor {
    private final FilmeGateway filmeGateway;
    private final FilmeMapper filmeMapper;

    public CreateFilmeInteractor(FilmeGateway filmeGateway, FilmeMapper filmeMapper) {
        this.filmeGateway = filmeGateway;
        this.filmeMapper = filmeMapper;
    }

    public FilmeResponse createFilme(CreateFilmeRequest request){
        var filme = new Filme(
                request.nome(),
                request.descricao(),
                request.duracao(),
                GeneroFilme.getById(request.generoId()),
                ClassificacaoFilme.getById(request.classificacaoId())
        );

        Filme created = filmeGateway.saveFilme(filme);

        return filmeMapper.toResponse(created);
    }
}
