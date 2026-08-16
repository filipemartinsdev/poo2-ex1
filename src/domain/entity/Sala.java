package domain.entity;

import java.util.List;

public class Sala {
    private Long numero;
    private CategoriaSala categoria;
    private List<Assento> assentos;

    public Sala(CategoriaSala categoria, List<Assento> assentos) {
        this.categoria = categoria;
        this.assentos = assentos;
    }

    public Long getNumero() {
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

    public List<Assento> getAssentos() {
        return assentos;
    }

    public void setAssentos(List<Assento> assentos) {
        this.assentos = assentos;
    }
}
