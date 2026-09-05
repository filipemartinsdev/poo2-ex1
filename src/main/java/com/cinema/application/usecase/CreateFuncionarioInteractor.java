package com.cinema.application.usecase;

import com.cinema.application.dto.CreateFuncionarioRequest;
import com.cinema.application.dto.FuncionarioResponse;
import com.cinema.application.gateway.FuncionarioGateway;
import com.cinema.application.mapper.UsuarioMapper;
import com.cinema.domain.entity.Funcionario;

public class CreateFuncionarioInteractor {
    private final FuncionarioGateway funcionarioGateway;
    private final UsuarioMapper usuarioMapper;

    public CreateFuncionarioInteractor(FuncionarioGateway funcionarioGateway, UsuarioMapper usuarioMapper) {
        this.funcionarioGateway = funcionarioGateway;
        this.usuarioMapper = usuarioMapper;
    }

    public FuncionarioResponse createFuncionario(CreateFuncionarioRequest request){
        var funcionario = new Funcionario(request.cpf(), request.nome());
        funcionarioGateway.saveFuncionario(funcionario);

        return usuarioMapper.toResponse(funcionario);
    }
}
