package domain.entity;

public enum TipoIngresso {
    MEIO(1, "Meio"), INTEIRO(2, "Inteiro");

    public final int id;
    public final String description;

    TipoIngresso(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public static TipoIngresso getById(int id){
        for (TipoIngresso tipoIngresso : TipoIngresso.values())
            if (tipoIngresso.id == id) return tipoIngresso;

        throw new RuntimeException("Tipo de Ingresso invalido");
    }
}
