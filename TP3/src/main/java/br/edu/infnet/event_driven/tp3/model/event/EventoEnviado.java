package br.edu.infnet.event_driven.tp3.model.event;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class EventoEnviado extends EventoBase<UUID> {
    public final Date instante;

    public EventoEnviado(UUID uuid) {
        super(uuid);
        this.instante = Date.valueOf(LocalDate.now());
    }
}