package application.usecase;

import application.dto.ClienteResponse;
import application.dto.CreateClienteRequest;
import application.gateway.ClienteGateway;
import application.mapper.UsuarioMapper;
import domain.entity.Cliente;
import domain.entity.Usuario;

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
