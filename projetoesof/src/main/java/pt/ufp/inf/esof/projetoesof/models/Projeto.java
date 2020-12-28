package pt.ufp.inf.esof.projetoesof.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Projeto {
    @Id
    private Long id;
    private String nome;
    @ManyToOne
    private Cliente cliente;

    public Projeto(String nome, Cliente cliente) {
        this.nome = nome;
        this.cliente = cliente;
    }


    public Projeto() {
    }
}
