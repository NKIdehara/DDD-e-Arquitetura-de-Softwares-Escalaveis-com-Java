package br.edu.infnet.event_driven.tp3.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.event_driven.tp3.model.Pedido;
import br.edu.infnet.event_driven.tp3.model.command.CommandoCriar;

@Service
public class PedidoServiceImpl implements PedidoService {
    @Autowired
    private final CommandGateway commandGateway;

    public PedidoServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    public CompletableFuture<UUID> criarPedido(Pedido pedido) {
        return commandGateway.send(new CommandoCriar(UUID.randomUUID(), pedido.getClienteId(), pedido.getValor()));
    }
}
