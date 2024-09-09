package br.edu.infnet.event_driven.tp3.model.event;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class EventoCriado extends EventoBase<UUID> {
    public final Long clienteId;
    public final Float valor;
    public final Date instante;

    public EventoCriado(UUID uuid, Long clienteId, Float valor) {
        super(uuid);
        this.clienteId = clienteId;
        this.valor = valor;
        this.instante = Date.valueOf(LocalDate.now());
    }
}
