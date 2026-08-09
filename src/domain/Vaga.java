package domain;

public class Vaga {
    private Boolean livre;
    private final Assento assento;

    public Vaga(Boolean livre, Assento assento) {
        this.livre = livre;
        this.assento = assento;
    }

    public Boolean getLivre() {
        return livre;
    }

    public void setLivre(Boolean livre) {
        this.livre = livre;
    }

    public Assento getAssento() {
        return assento;
    }
}
