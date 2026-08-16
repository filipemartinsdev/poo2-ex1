package domain.entity;

public class Vaga {
    private final int id;
    private final Assento assento;
    private Boolean livre = true;

    public Vaga(int id, Assento assento) {
        this.id = id;
        this.assento = assento;
    }

    public int getId() {
        return id;
    }

    public Boolean getLivre() {
        return livre;
    }

    public void ocupar(){
        this.livre = false;
    }

    public Assento getAssento() {
        return assento;
    }
}
