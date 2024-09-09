package br.edu.infnet.event_driven.tp3.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import br.edu.infnet.event_driven.tp3.model.Pedido;

public interface PedidoService {
    public CompletableFuture<UUID> criarPedido(Pedido pedido);
}
