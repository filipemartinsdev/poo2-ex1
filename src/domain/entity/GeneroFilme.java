package domain.entity;

public enum GeneroFilme {
    TERROR(1, "Terror"),
    ROMANCE(2, "Romance"),
    FICCAO_CIENTIFICA(3, "Ficção Científica"),
    EPICO(4, "Épico"),
    DOCUMENTARIO(5, "Documentário"),
    ACAO(6, "Ação"),
    MUSICAL(7, "Musical"),
    DRAMA(8, "Drama"),
    OUTRO(9, "Outro");

    public final int id;
    public final String description;

    GeneroFilme(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public static GeneroFilme getById(int id){
        for (GeneroFilme genero : GeneroFilme.values())
            if (genero.id == id) return genero;

        throw new RuntimeException("Gênero inválido");
    }
}
