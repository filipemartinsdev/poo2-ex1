package application.gateway;

import domain.entity.Ingresso;

import java.util.List;
import java.util.Optional;

public interface IngressoGateway {
    Ingresso saveIngresso(Ingresso ingresso);

    List<Ingresso> findAllIngresso();
}
