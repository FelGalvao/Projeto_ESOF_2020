package pt.ufp.inf.esof.projetoesof.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    @ManyToOne
    private Cliente cliente;

    @OneToMany
    private List<Projeto> lista_projetos = new ArrayList<>();

    public Cliente(){ }

    public Cliente(Long id, String nome, int idade, Cliente cliente, List<Projeto> lista_projetos) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cliente = cliente;
        this.lista_projetos = lista_projetos;
    }


    public void addProjeto(Projeto p){
      this.lista_projetos.add(p);
      p.setCliente(this);






    }
}
