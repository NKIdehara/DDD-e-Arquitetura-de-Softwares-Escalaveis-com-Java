package br.edu.infnet.event_driven.tp3.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;

import br.edu.infnet.event_driven.tp3.model.Pedido;
import br.edu.infnet.event_driven.tp3.repository.PedidoRepository;

@Service
public class PedidoQueryServiceImpl implements PedidoQueryService {
    private final EventStore eventStore;
    private final PedidoRepository pedidoRepository;

    public PedidoQueryServiceImpl(EventStore eventStore, PedidoRepository pedidoRepository) {
        this.eventStore = eventStore;
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Object> listarEventos(String id) {
        List<Object> eventos = eventStore.readEvents(id, 0)
                                    .asStream()
                                    .map(record -> record.getPayload()).collect(Collectors.toList());
        return eventos;
    }

    @Override
    public Optional<Pedido> getById(UUID uuid) {
        return pedidoRepository.findById(uuid);
    }
}
