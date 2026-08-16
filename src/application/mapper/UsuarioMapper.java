package application.mapper;

import application.dto.ClienteResponse;
import application.dto.FuncionarioResponse;
import domain.entity.Cliente;
import domain.entity.Funcionario;

public class UsuarioMapper {
    public FuncionarioResponse toResponse(Funcionario domain){
        return new FuncionarioResponse(domain.getCpf(), domain.getNome());
    }

    public ClienteResponse toResponse(Cliente domain){
        return new ClienteResponse(domain.getCpf(), domain.getNome());
    }
}
