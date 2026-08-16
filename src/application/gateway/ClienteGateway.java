package application.gateway;

import domain.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteGateway {
    Cliente saveCliente(Cliente cliente);

    Optional<Cliente> findClienteByCpf(String cpf);

    List<Cliente> findAllClientes();
}
