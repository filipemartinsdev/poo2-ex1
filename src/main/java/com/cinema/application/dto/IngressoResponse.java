package com.cinema.application.dto;

import java.time.Instant;

public record IngressoResponse (
        long id,
        String tipo,
        Instant horario,
        long sala,
        int assento,
        String cliente,
        String funcionario
) {

}
