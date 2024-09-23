package br.edu.infnet.Arquitetura_Softwares_Escalaveis.AT.transporte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.Arquitetura_Softwares_Escalaveis.AT.transporte.model.Encomenda;
import br.edu.infnet.Arquitetura_Softwares_Escalaveis.AT.transporte.model.Status;

@Repository
public interface EncomendaRepository extends JpaRepository<Encomenda, Long> {
    List<Encomenda> findByStatus(Status status);
}
