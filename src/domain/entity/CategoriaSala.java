package domain.entity;

public enum CategoriaSala {
    ECONOMICA(1, "Econômica"),
    COMUM(2, "Comum"),
    PREMIUM(3, "Premium");

    public final int id;
    public final String description;

    CategoriaSala(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public static CategoriaSala getById(int id){
        for(CategoriaSala categoria : CategoriaSala.values())
            if (categoria.id == id) return categoria;

        throw new RuntimeException("Categoria de sala inválida");
    }
}
