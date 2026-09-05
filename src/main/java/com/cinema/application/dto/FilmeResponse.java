package com.cinema.application.dto;

import java.time.Duration;

public record FilmeResponse(
        Long id,
        String nome,
        String descricao,
        Duration duracao,
        Genero genero,
        Classificacao classificacao
) {

    public static record Genero (int id, String description){}
    public static record Classificacao (int id, String description){}
}