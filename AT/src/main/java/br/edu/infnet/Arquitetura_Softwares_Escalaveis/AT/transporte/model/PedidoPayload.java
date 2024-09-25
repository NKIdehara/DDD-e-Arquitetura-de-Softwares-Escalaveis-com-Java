package br.edu.infnet.Arquitetura_Softwares_Escalaveis.AT.transporte.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor@AllArgsConstructor
public class PedidoPayload {
    public Long pedidoId;
    public Long clienteId;
    public Long destinoId;
    public List<Long> produtoId;
    public Status status;
}
