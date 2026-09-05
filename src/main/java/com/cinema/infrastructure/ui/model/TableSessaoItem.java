package com.cinema.infrastructure.ui.model;

import java.math.BigDecimal;
import java.time.Instant;

public class TableSessaoItem {
    private Integer id;
    private String filme;
    private Instant horario;
    private BigDecimal valor;
    private Integer sala;
    private Integer vagas;

    public TableSessaoItem(Integer id, String filme, Instant horario, BigDecimal valor, Integer sala, Integer vagas) {
        this.id = id;
        this.filme = filme;
        this.horario = horario;
        this.valor = valor;
        this.sala = sala;
        this.vagas = vagas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getSala() {
        return sala;
    }

    public void setSala(Integer sala) {
        this.sala = sala;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }
}
