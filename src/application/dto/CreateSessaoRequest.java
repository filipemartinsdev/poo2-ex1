package application.dto;

import java.math.BigDecimal;
import java.time.Instant;

public record CreateSessaoRequest(
        Instant horario,
        BigDecimal valor,
        long filmeId,
        long salaNumero
) {
}
