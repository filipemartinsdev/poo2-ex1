package com.cinema.infrastructure.ui.model;

import com.cinema.domain.entity.ClassificacaoFilme;
import com.cinema.domain.entity.GeneroFilme;

public class TableFilmeItem {
    private Integer id;
    private String nome;
    private GeneroFilme genero;
    private ClassificacaoFilme classificacao;
    private Integer duracao;

    public TableFilmeItem(Integer id, String nome, GeneroFilme genero, ClassificacaoFilme classificacao, Integer duracao) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.classificacao = classificacao;
        this.duracao = duracao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public GeneroFilme getGenero() {
        return genero;
    }

    public void setGenero(GeneroFilme genero) {
        this.genero = genero;
    }

    public ClassificacaoFilme getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(ClassificacaoFilme classificacao) {
        this.classificacao = classificacao;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }
}
