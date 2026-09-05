package com.cinema.application.usecase;

import com.cinema.application.dto.FuncionarioResponse;
import com.cinema.application.gateway.FuncionarioGateway;
import com.cinema.application.mapper.UsuarioMapper;

import java.util.List;

public class GetAllFuncionariosInteractor {
    private final FuncionarioGateway funcionarioGateway;
    private final UsuarioMapper usuarioMapper;

    public GetAllFuncionariosInteractor(FuncionarioGateway funcionarioGateway, UsuarioMapper usuarioMapper) {
        this.funcionarioGateway = funcionarioGateway;
        this.usuarioMapper = usuarioMapper;
    }

    public List<FuncionarioResponse> getAllFuncionarios(){
        return funcionarioGateway.findAllFuncionarios()
                .stream()
                .map(usuarioMapper::toResponse)
                .toList();
    }
}
