package application.dto;

public record SalaResponse(
        long numero,
        Categoria categoria,
        long assentos
) {
    public static record Categoria (int id, String description){}
}
