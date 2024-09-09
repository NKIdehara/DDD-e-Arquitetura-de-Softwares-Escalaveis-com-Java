package br.edu.infnet.event_driven.tp3.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.event_driven.tp3.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, UUID> {
}
