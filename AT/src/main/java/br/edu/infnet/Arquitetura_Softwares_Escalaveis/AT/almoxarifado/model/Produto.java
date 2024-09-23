package br.edu.infnet.Arquitetura_Softwares_Escalaveis.AT.almoxarifado.model;

import java.math.BigDecimal;

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
@Table(name = "produtos")
@Getter@Setter
@NoArgsConstructor@AllArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String descricao;
    private Dimensoes dimensoes;
    private int estoque;
    private BigDecimal preco;
    private Categoria categoria;
}