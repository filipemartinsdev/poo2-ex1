package com.cinema.application.usecase;

import com.cinema.application.dto.ClienteResponse;
import com.cinema.application.dto.CreateClienteRequest;
import com.cinema.application.gateway.ClienteGateway;
import com.cinema.application.mapper.UsuarioMapper;
import com.cinema.domain.entity.Cliente;

public class CreateClienteInteractor {
    private final ClienteGateway clienteGateway;
    private final UsuarioMapper usuarioMapper;

    public CreateClienteInteractor(ClienteGateway clienteGateway, UsuarioMapper usuarioMapper) {
        this.clienteGateway = clienteGateway;
        this.usuarioMapper = usuarioMapper;
    }

    public ClienteResponse createCliente(CreateClienteRequest request){
        var cliente = new Cliente(request.cpf(), request.nome());
        clienteGateway.saveCliente(cliente);

        return usuarioMapper.toResponse(cliente);
    }
}
