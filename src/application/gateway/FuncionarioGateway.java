package application.gateway;

import domain.entity.Funcionario;

import java.util.List;
import java.util.Optional;

public interface FuncionarioGateway {
    List<Funcionario> findAllFuncionarios();

    Funcionario saveFuncionario(Funcionario funcionario);

    Optional<Funcionario> findFuncionarioByCpf(String cpf);
}
