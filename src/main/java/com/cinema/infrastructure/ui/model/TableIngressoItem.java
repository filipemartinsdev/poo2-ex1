package com.cinema.infrastructure.ui.model;

import com.cinema.domain.entity.TipoIngresso;

public class TableIngressoItem {
    private Integer id;
    private TipoIngresso tipo;
    private Integer sessao;
    private Integer assento;
    private String cliente;
    private String vendedor;

    public TableIngressoItem(Integer id, TipoIngresso tipo, Integer sessao, Integer assento, String cliente, String vendedor) {
        this.id = id;
        this.tipo = tipo;
        this.sessao = sessao;
        this.assento = assento;
        this.cliente = cliente;
        this.vendedor = vendedor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoIngresso getTipo() {
        return tipo;
    }

    public void setTipo(TipoIngresso tipo) {
        this.tipo = tipo;
    }

    public Integer getSessao() {
        return sessao;
    }

    public void setSessao(Integer sessao) {
        this.sessao = sessao;
    }

    public Integer getAssento() {
        return assento;
    }

    public void setAssento(Integer assento) {
        this.assento = assento;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }
}
