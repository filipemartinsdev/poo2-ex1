package application.usecase;

import application.dto.CreateFuncionarioRequest;
import application.dto.FuncionarioResponse;
import application.gateway.FuncionarioGateway;
import application.mapper.UsuarioMapper;
import domain.entity.Funcionario;
import domain.entity.Usuario;

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
