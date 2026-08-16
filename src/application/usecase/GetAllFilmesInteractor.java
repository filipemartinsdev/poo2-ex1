package application.usecase;

import application.dto.FilmeResponse;
import application.gateway.FilmeGateway;
import application.mapper.FilmeMapper;
import application.mapper.UsuarioMapper;

import java.util.List;

public class GetAllFilmesInteractor {
    private final FilmeGateway filmeGateway;
    private final FilmeMapper filmeMapper;

    public GetAllFilmesInteractor(FilmeGateway filmeGateway, FilmeMapper filmeMapper) {
        this.filmeGateway = filmeGateway;
        this.filmeMapper = filmeMapper;
    }

    public List<FilmeResponse> getAllFilmes(){
        return filmeGateway.findAllFilmes()
                .stream()
                .map(filmeMapper::toResponse)
                .toList();
    }
}
