package com.cinema.application.dto;

import java.time.Duration;

public record CreateFilmeRequest(
        String nome,
        String descricao,
        Duration duracao,
        int generoId,
        int classificacaoId
) {
}
