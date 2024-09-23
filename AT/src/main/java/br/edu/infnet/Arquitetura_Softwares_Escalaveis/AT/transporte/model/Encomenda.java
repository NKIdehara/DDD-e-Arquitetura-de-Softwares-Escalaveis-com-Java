package br.edu.infnet.Arquitetura_Softwares_Escalaveis.AT.transporte.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "encomendas")
@Getter@Setter
@NoArgsConstructor@AllArgsConstructor
public class Encomenda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descricao;
    private Destino destino;
    private Date previsao;
    private Status status;
}
