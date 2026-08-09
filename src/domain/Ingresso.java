package domain;

public class Ingresso {
    private final Long id;
    private final TipoIngresso tipo;
    private final Sessao sessao;
    private final Sala sala;
    private final Assento assento;
    private final Funcionario vendedor;
    private final Cliente cliente;

    public Ingresso(Long id, TipoIngresso tipo, Sessao sessao, Sala sala, Assento assento, Funcionario vendedor, Cliente cliente) {
        this.id = id;
        this.tipo = tipo;
        this.sessao = sessao;
        this.sala = sala;
        this.assento = assento;
        this.vendedor = vendedor;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public TipoIngresso getTipo() {
        return tipo;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public Sala getSala() {
        return sala;
    }

    public Assento getAssento() {
        return assento;
    }

    public Funcionario getVendedor() {
        return vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
