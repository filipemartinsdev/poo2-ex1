package application.gateway;

import domain.entity.Filme;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface FilmeGateway {
    Filme saveFilme(Filme filme);

    Optional<Filme> findFilmeById(Long id);

    List<Filme> findAllFilmes();
}
