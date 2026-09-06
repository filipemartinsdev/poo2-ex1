package com.cinema.application.dto;

import java.time.Instant;

public record IngressoResponse (
        long id,
        String tipo,
        long sessaoId,
        Instant horario,
        long sala,
        int assento,
        String cliente,
        String funcionario
) {

}
