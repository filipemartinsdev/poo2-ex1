package application.dto;

import domain.entity.ClassificacaoFilme;
import domain.entity.GeneroFilme;

import java.time.Duration;

public record CreateFilmeRequest(
        String nome,
        String descricao,
        Duration duracao,
        int generoId,
        int classificacaoId
) {
}
