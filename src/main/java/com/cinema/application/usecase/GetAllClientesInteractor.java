package com.cinema.application.usecase;

import com.cinema.application.dto.ClienteResponse;
import com.cinema.application.gateway.ClienteGateway;
import com.cinema.application.mapper.UsuarioMapper;

import java.util.List;

public class GetAllClientesInteractor {
    private final ClienteGateway clienteGateway;
    private final UsuarioMapper usuarioMapper;

    public GetAllClientesInteractor(ClienteGateway clienteGateway, UsuarioMapper usuarioMapper) {
        this.clienteGateway = clienteGateway;
        this.usuarioMapper = usuarioMapper;
    }

    public List<ClienteResponse> getAllClientes() {
        return clienteGateway.findAllClientes()
                .stream()
                .map(usuarioMapper::toResponse)
                .toList();
    }
}
