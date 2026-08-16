package domain.entity;

public enum ClassificacaoFilme {
    LIVRE(1, "Livre para todas as idades"),
    MIN_10(2, "Indicado para maiores de 10 anos"),
    MIN_12(3, "Indicado para maiores de 12 anos"),
    MIN_14(4, "Indicado para maiores de 14 anos"),
    MIN_16(5, "Indicado para maiores de 16 anos"),
    ADULTO(6, "Indicado para adultos");

    public final int id;
    public final String description;

    ClassificacaoFilme(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public static ClassificacaoFilme getById(int id){
        for (ClassificacaoFilme classificacao : ClassificacaoFilme.values())
            if (classificacao.id == id) return classificacao;

        throw new RuntimeException("Classificação inválida");
    }
}
