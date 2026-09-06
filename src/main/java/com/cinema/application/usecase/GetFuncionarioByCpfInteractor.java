package com.cinema.application.usecase;

import com.cinema.application.dto.FuncionarioResponse;
import com.cinema.application.gateway.FuncionarioGateway;
import com.cinema.application.mapper.UsuarioMapper;
import com.cinema.domain.entity.Funcionario;

import java.util.Optional;

public class GetFuncionarioByCpfInteractor {
    private final FuncionarioGateway funcionarioGateway;
    private final UsuarioMapper usuarioMapper;

    public GetFuncionarioByCpfInteractor(FuncionarioGateway funcionarioGateway, UsuarioMapper usuarioMapper) {
        this.funcionarioGateway = funcionarioGateway;
        this.usuarioMapper = usuarioMapper;
    }

    public Optional<FuncionarioResponse> getByCpf(String cpf){
        Optional<Funcionario> funcionario = funcionarioGateway.findFuncionarioByCpf(cpf);
        return funcionario.map(usuarioMapper::toResponse);
    }
}
