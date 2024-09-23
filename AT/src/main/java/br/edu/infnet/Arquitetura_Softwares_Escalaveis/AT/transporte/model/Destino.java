package br.edu.infnet.Arquitetura_Softwares_Escalaveis.AT.transporte.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
public class Destino {
    private String destinatario;
    private String endereco;
    private String cidade;
    private String estado;
    private Long cep;

    public Destino(String destinatario, String endereco, String cidade, String estado,  Long cep) {
        if (destinatario.isEmpty() || endereco.isEmpty() || cidade.isEmpty() || estado.isEmpty() || cep < 0) {
            throw new IllegalArgumentException("Endereço inválido!");
        }
        this.destinatario = destinatario;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
}
