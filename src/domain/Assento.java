package domain;

public class Assento {
    private Long numero;
    private Boolean reclinavel;

    public Assento(Long numero, Boolean reclinavel) {
        this.numero = numero;
        this.reclinavel = reclinavel;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Boolean getReclinavel() {
        return reclinavel;
    }

    public void setReclinavel(Boolean reclinavel) {
        this.reclinavel = reclinavel;
    }
}
