package application.gateway;

import domain.entity.Sessao;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface SessaoGateway {
    Sessao saveSessao(Sessao sessao);

    Optional<Sessao> findSessaoById(long id);

    List<Sessao> findAllSessaoByFilmeId(long id);

    List<Sessao> findAllSessao();
}
