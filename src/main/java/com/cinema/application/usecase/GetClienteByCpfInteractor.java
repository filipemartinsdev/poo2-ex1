package com.cinema.application.usecase;

import com.cinema.application.dto.ClienteResponse;
import com.cinema.application.gateway.ClienteGateway;
import com.cinema.application.mapper.UsuarioMapper;
import com.cinema.domain.entity.Cliente;

import java.util.List;
import java.util.Optional;

public class GetClienteByCpfInteractor {
    private final ClienteGateway clienteGateway;
    private final UsuarioMapper usuarioMapper;

    public GetClienteByCpfInteractor(ClienteGateway clienteGateway, UsuarioMapper usuarioMapper) {
        this.clienteGateway = clienteGateway;
        this.usuarioMapper = usuarioMapper;
    }

    public Optional<ClienteResponse> getByCpf(String cpf){
        Optional<Cliente> cliente = clienteGateway.findClienteByCpf(cpf);
        return cliente.map(usuarioMapper::toResponse);
    }
}
