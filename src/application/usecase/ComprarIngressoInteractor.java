package application.usecase;

import application.dto.CreateIngressoRequest;
import application.dto.IngressoResponse;
import application.gateway.ClienteGateway;
import application.gateway.FuncionarioGateway;
import application.gateway.IngressoGateway;
import application.gateway.SessaoGateway;
import application.mapper.IngressoMapper;
import domain.entity.*;

public class ComprarIngressoInteractor {
    private final SessaoGateway sessaoGateway;
    private final FuncionarioGateway funcionarioGateway;
    private final ClienteGateway clienteGateway;
    private final IngressoGateway ingressoGateway;
    private final IngressoMapper ingressoMapper;

    public ComprarIngressoInteractor(SessaoGateway sessaoGateway, FuncionarioGateway funcionarioGateway, ClienteGateway clienteGateway, IngressoGateway ingressoGateway, IngressoMapper ingressoMapper) {
        this.sessaoGateway = sessaoGateway;
        this.funcionarioGateway = funcionarioGateway;
        this.clienteGateway = clienteGateway;
        this.ingressoGateway = ingressoGateway;
        this.ingressoMapper = ingressoMapper;
    }

    public IngressoResponse comprarIngresso(CreateIngressoRequest request){
        var tipo = TipoIngresso.getById(request.tipoIngressoId());

        var sessao = sessaoGateway.findSessaoById(request.sessaoId())
                .orElseThrow(() -> new RuntimeException("Sessao invalida"));

        var funcionario = funcionarioGateway.findFuncionarioByCpf(request.funcionarioCpf())
                .orElseThrow(() -> new RuntimeException("Funcionario invalido"));

        var cliente = clienteGateway.findClienteByCpf(request.clienteCpf())
                .orElseThrow(() -> new RuntimeException("Cliente invalido"));

        var vaga = sessao.getVagas()
                .stream()
                .filter(v -> v.getAssento().getNumero() == request.assentoNumero())
                .filter(Vaga::getLivre)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Assento inválido ou indisponível"));

        var ingresso = new Ingresso(
                tipo,
                sessao,
                vaga.getAssento(),
                funcionario,
                cliente
        );

        Ingresso created = ingressoGateway.saveIngresso(ingresso);

        vaga.ocupar();

        sessaoGateway.saveSessao(sessao);

        return ingressoMapper.toResponse(created);
    }
}
