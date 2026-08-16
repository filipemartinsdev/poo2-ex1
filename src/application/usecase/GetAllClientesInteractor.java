package application.usecase;

import application.dto.ClienteResponse;
import application.gateway.ClienteGateway;
import application.mapper.UsuarioMapper;

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
