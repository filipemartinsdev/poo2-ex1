package domain.entity;

public class Assento {
    private int numero;
    private boolean reclinavel;

    public Assento(int numero, boolean reclinavel) {
        this.numero = numero;
        this.reclinavel = reclinavel;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean getReclinavel() {
        return reclinavel;
    }

    public void setReclinavel(boolean reclinavel) {
        this.reclinavel = reclinavel;
    }
}
