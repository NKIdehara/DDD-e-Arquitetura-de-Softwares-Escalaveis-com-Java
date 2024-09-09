package br.edu.infnet.event_driven.tp3.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.edu.infnet.event_driven.tp3.model.Pedido;

public interface PedidoQueryService {
    public List<Object> listarEventos(String id);
    public Optional<Pedido> getById(UUID uuid);
}
