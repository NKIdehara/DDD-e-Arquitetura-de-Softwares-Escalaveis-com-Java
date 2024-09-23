package br.edu.infnet.Arquitetura_Softwares_Escalaveis.AT.almoxarifado.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
public class Dimensoes {
    private double altura;
    private double largura;
    private double profundidade;

    public Dimensoes(double altura, double largura, double profundidade) {
        if (altura <= 0 || largura <= 0 || profundidade <= 0) {
            throw new IllegalArgumentException("Dimensões inválidas!");
        }
        this.altura = altura;
        this.largura = largura;
        this.profundidade = profundidade;
    }
}