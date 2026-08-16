package application.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public record SessaoResponse(
        long id,
        Instant horario,
        FilmeResponse filme,
        SalaResponse sala,
        BigDecimal valor,
        List<VagaResponse> vagas
) {

    public static record VagaResponse (
            AssentoResponse assento,
            boolean livre
    ){}

    public static record AssentoResponse (
            int numero,
            boolean reclinavel
    ){}

}
