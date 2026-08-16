package domain.entity;

import java.time.Duration;

public class Filme {
    private Long id;
    private final String nome;
    private final String descricao;
    private final Duration duracao;
    private final GeneroFilme genero;
    private final ClassificacaoFilme classificacao;

    public Filme(String nome, String descricao, Duration duracao, GeneroFilme genero, ClassificacaoFilme classificacao) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.genero = genero;
        this.classificacao = classificacao;
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

    public String getDescricao() {
        return descricao;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public GeneroFilme getGenero() {
        return genero;
    }

    public ClassificacaoFilme getClassificacao() {
        return classificacao;
    }
}
