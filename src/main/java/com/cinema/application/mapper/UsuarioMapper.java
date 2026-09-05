package com.cinema.application.mapper;

import com.cinema.application.dto.ClienteResponse;
import com.cinema.application.dto.FuncionarioResponse;
import com.cinema.domain.entity.Cliente;
import com.cinema.domain.entity.Funcionario;

public class UsuarioMapper {
    public FuncionarioResponse toResponse(Funcionario domain){
        return new FuncionarioResponse(domain.getCpf(), domain.getNome());
    }

    public ClienteResponse toResponse(Cliente domain){
        return new ClienteResponse(domain.getCpf(), domain.getNome());
    }
}
