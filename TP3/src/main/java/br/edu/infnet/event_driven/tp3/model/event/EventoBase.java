package br.edu.infnet.event_driven.tp3.model.event;

public class EventoBase<T> {
    public final T id;

    public EventoBase(T id) {
        this.id = id;
    }
}