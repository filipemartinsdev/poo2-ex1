package application.mapper;

import application.dto.IngressoResponse;
import domain.entity.Ingresso;

public class IngressoMapper {
    public IngressoResponse toResponse(Ingresso domain){
        return new IngressoResponse(
                domain.getId(),
                domain.getTipo().description,
                domain.getSessao().getHorario(),
                domain.getSessao().getSala().getNumero(),
                domain.getAssento().getNumero(),
                domain.getCliente().getNome(),
                domain.getVendedor().getNome()
        );
    }
}
