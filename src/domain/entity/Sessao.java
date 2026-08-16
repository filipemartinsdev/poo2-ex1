package domain.entity;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public class Sessao {
    private long id;
    private final Instant horario;
    private final BigDecimal valor;
    private final Filme filme;
    private final Sala sala;
    private final List<Vaga> vagas;

    public Sessao(Instant horario, BigDecimal valor, Filme filme, Sala sala, List<Vaga> vagas) {
        this.horario = horario;
        this.valor = valor;
        this.filme = filme;
        this.sala = sala;
        this.vagas = vagas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
