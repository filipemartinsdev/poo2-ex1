package domain;

public enum ClassificacaoFilme {
    LIVRE("Livre para todas as idades"),
    MIN_10("Indicado para maiores de 10 anos"),
    MIN_12("Indicado para maiores de 12 anos"),
    MIN_14("Indicado para maiores de 14 anos"),
    MIN_16("Indicado para maiores de 16 anos"),
    ADULTO("Indicado para adultos");

    public final String descricao;

    ClassificacaoFilme(String descricao) {
        this.descricao = descricao;
    }
}
