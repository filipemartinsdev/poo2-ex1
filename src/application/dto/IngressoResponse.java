package application.dto;

import java.time.Duration;
import java.time.Instant;

public record IngressoResponse (
        long id,
        String tipo,
        Instant horario,
        long sala,
        int assento,
        String cliente,
        String funcionario
) {

}
