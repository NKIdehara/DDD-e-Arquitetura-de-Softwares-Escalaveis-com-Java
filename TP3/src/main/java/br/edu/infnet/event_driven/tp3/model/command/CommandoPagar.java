package br.edu.infnet.event_driven.tp3.model.command;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class CommandoPagar extends CommandoBase<UUID> {
    public final Date instante;

    public CommandoPagar(UUID uuid) {
        super(uuid);
        this.instante = Date.valueOf(LocalDate.now());
    }
}
