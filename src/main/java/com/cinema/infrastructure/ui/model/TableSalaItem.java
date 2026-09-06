package com.cinema.infrastructure.ui.model;

import com.cinema.domain.entity.CategoriaSala;

public class TableSalaItem {
    private Long numero;
    private CategoriaSala categoria;
    private Long assentos;

    public TableSalaItem(Long numero, CategoriaSala categoria, Long assentos) {
        this.numero = numero;
        this.categoria = categoria;
        this.assentos = assentos;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public CategoriaSala getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaSala categoria) {
        this.categoria = categoria;
    }

    public Long getAssentos() {
        return assentos;
    }

    public void setAssentos(Long assentos) {
        this.assentos = assentos;
    }
}
