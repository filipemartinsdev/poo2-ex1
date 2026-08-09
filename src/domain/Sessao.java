package domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public class Sessao {
    private final Long id;
    private final Instant horario;
    private final BigDecimal valor;
    private final Filme filme;
    private final Sala sala;
    private final List<Vaga> vagas;

    public Sessao(Long id, Instant horario, BigDecimal valor, Filme filme, Sala sala, List<Vaga> vagas) {
        this.id = id;
        this.horario = horario;
        this.valor = valor;
        this.filme = filme;
        this.sala = sala;
        this.vagas = vagas;
    }

    public Long getId() {
        return id;
    }

    public Instant getHorario() {
        return horario;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Filme getFilme() {
        return filme;
    }

    public Sala getSala() {
        return sala;
    }

    public List<Vaga> getVagas() {
        return vagas;
    }
}
