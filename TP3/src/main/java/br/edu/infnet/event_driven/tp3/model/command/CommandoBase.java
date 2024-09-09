package br.edu.infnet.event_driven.tp3.model.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CommandoBase<T> {
    @TargetAggregateIdentifier
    public final T id;

    public CommandoBase(T id) {
        this.id = id;
    }
}