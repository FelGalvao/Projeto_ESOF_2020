package pt.ufp.inf.esof.projetoesof.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private Enum estado;

    @ManyToOne
    private Cliente cliente;

    @OneToMany
    private List<Tarefa> lista_tarefas = new ArrayList<>();

    public Projeto() {

    }

    public Projeto(int id, String nome, Cliente cliente, Enum estado, List<Tarefa> lista_tarefas) {
        this.id = id;
        this.nome = nome;
        this.cliente = cliente;
        this.estado = estado;
        this.lista_tarefas = lista_tarefas;
    }

    public void addTarefa(Tarefa t){
        this.lista_tarefas.add(t);
        t.setProjeto(this);
    }

    public void removeTarefa(Tarefa t){
        this.lista_tarefas.remove(t);
        t.setProjeto(null); //acho que não será preciso
    }

}
