package br.edu.infnet.event_driven.tp3.model;

import java.util.UUID;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import br.edu.infnet.event_driven.tp3.model.command.CommandoCriar;
import br.edu.infnet.event_driven.tp3.model.command.CommandoEnviar;
import br.edu.infnet.event_driven.tp3.model.command.CommandoPagar;
import br.edu.infnet.event_driven.tp3.model.command.CommandoReceber;
import br.edu.infnet.event_driven.tp3.model.event.EventoCriado;
import br.edu.infnet.event_driven.tp3.model.event.EventoEnviado;
import br.edu.infnet.event_driven.tp3.model.event.EventoPago;
import br.edu.infnet.event_driven.tp3.model.event.EventoRecebido;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Pedidos")
@Aggregate
@Getter@Setter
public class Pedido {
    @AggregateIdentifier
    @Id
    private UUID pedidoId;
    private Long clienteId;
    private Float valor;
    private Status status;

    public Pedido() {
    }

    @CommandHandler
    public Pedido(CommandoCriar pedido) {
        AggregateLifecycle.apply(new EventoCriado(pedido.id, pedido.clienteId, pedido.valor));
    }

    @CommandHandler
    public Pedido(CommandoPagar pedido) {
        AggregateLifecycle.apply(new EventoPago(pedido.id));
    }

    @CommandHandler
    public Pedido(CommandoEnviar pedido) {
        AggregateLifecycle.apply(new EventoEnviado(pedido.id));
    }

    @CommandHandler
    public Pedido(CommandoReceber pedido) {
        AggregateLifecycle.apply(new EventoRecebido(pedido.id));
    }

    @EventSourcingHandler
    protected void on(EventoCriado pedido) {
        this.pedidoId = pedido.id;
        this.clienteId = pedido.clienteId;
        this.valor = pedido.valor;
        this.status = Status.CRIADO;
    }

    @EventSourcingHandler
    protected void on(EventoPago pedido) {
        this.status = Status.PAGO;
    }

    @EventSourcingHandler
    protected void on(EventoEnviado pedido) {
        this.status = Status.ENVIADO;
    }

    @EventSourcingHandler
    protected void on(EventoRecebido pedido) {
        this.status = Status.RECEBIDO;
    }
}
