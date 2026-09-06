package com.cinema.infrastructure.ui.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

public class TableSessaoItem {
    private Long id;
    private String filme;
    private LocalDate data;
    private Instant horario;
    private BigDecimal valor;
    private Long sala;
    private Integer vagas;

    public TableSessaoItem(Long id, String filme, LocalDate data, Instant horario, BigDecimal valor, Long sala, Integer vagas) {
        this.id = id;
        this.filme = filme;
        this.data = data;
        this.horario = horario;
        this.valor = valor;
        this.sala = sala;
        this.vagas = vagas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilme() {
        return filme;
    }

    public void setFilme(String filme) {
        this.filme = filme;
    }

    public Instant getHorario() {
        return horario;
    }

    public void setHorario(Instant horario) {
        this.horario = horario;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Long getSala() {
        return sala;
    }

    public void setSala(Long sala) {
        this.sala = sala;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
