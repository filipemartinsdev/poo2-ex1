package com.cinema.infrastructure.ui.model;

import com.cinema.domain.entity.TipoIngresso;

public class TableIngressoItem {
    private Long id;
    private String tipo;
    private Long sessao;
    private Integer assento;
    private String cliente;
    private String vendedor;

    public TableIngressoItem(Long id, String tipo, Long sessao, Integer assento, String cliente, String vendedor) {
        this.id = id;
        this.tipo = tipo;
        this.sessao = sessao;
        this.assento = assento;
        this.cliente = cliente;
        this.vendedor = vendedor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getSessao() {
        return sessao;
    }

    public void setSessao(Long sessao) {
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
