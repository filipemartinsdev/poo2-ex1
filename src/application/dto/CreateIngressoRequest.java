package application.dto;

public record CreateIngressoRequest (
        int tipoIngressoId,
        long sessaoId,
        int assentoNumero,
        String funcionarioCpf,
        String clienteCpf
) {
}