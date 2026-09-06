package com.cinema.infrastructure.ui.model;

import com.cinema.domain.entity.ClassificacaoFilme;
import com.cinema.domain.entity.GeneroFilme;

public class TableFilmeItem {
    private Long id;
    private String nome;
    private GeneroFilme genero;
    private ClassificacaoFilme classificacao;
    private Long duracao;

    public TableFilmeItem(Long id, String nome, GeneroFilme genero, ClassificacaoFilme classificacao, Long duracao) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.classificacao = classificacao;
        this.duracao = duracao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getDuracao() {
        return duracao;
    }

    public void setDuracao(Long duracao) {
        this.duracao = duracao;
    }
}
