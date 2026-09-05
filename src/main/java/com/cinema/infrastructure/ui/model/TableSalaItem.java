package com.cinema.infrastructure.ui.model;

import com.cinema.domain.entity.CategoriaSala;

public class TableSalaItem {
    private Integer numero;
    private CategoriaSala categoria;
    private Integer assentos;

    public TableSalaItem(Integer numero, CategoriaSala categoria, Integer assentos) {
        this.numero = numero;
        this.categoria = categoria;
        this.assentos = assentos;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public CategoriaSala getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaSala categoria) {
        this.categoria = categoria;
    }

    public Integer getAssentos() {
        return assentos;
    }

    public void setAssentos(Integer assentos) {
        this.assentos = assentos;
    }
}
