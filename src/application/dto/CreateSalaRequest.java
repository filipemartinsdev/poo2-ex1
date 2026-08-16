package application.dto;

public record CreateSalaRequest(
        int categoriaId,
        int assentosCount
) {
}
