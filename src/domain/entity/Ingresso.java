package domain.entity;

public class Ingresso {
    private Long id;
    private final TipoIngresso tipo;
    private final Sessao sessao;
    private final Assento assento;
    private final Funcionario vendedor;
    private final Cliente cliente;

    public Ingresso(TipoIngresso tipo, Sessao sessao, Assento assento, Funcionario vendedor, Cliente cliente) {
        this.tipo = tipo;
        this.sessao = sessao;
        this.assento = assento;
        this.vendedor = vendedor;
        this.cliente = cliente;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoIngresso getTipo() {
        return tipo;
    }

    public Sessao getSessao() {
        return sessao;
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
