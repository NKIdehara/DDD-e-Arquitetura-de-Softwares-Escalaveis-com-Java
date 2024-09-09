package br.edu.infnet.event_driven.tp3.model.command;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class CommandoCriar extends CommandoBase<UUID> {
    public final Long clienteId;
    public final Float valor;

    public CommandoCriar(UUID uuid, Long clienteId, Float valor) {
        super(uuid);
        this.clienteId = clienteId;
        this.valor = valor;
    }
}
