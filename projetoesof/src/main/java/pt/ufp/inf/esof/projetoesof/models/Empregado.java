package pt.ufp.inf.esof.projetoesof.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Empregado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    @ManyToMany
    private List<Tarefa> lista_tarefas = new ArrayList<>();
    private List<Cargo> lista_cargos = new ArrayList<>();

    public Empregado() {

    }

    public Empregado(int id, String nome, List<Tarefa> lista_tarefas, List<Cargo> lista_cargos) {
        this.id = id;
        this.nome = nome;
        this.lista_tarefas = lista_tarefas;
        this.lista_cargos = lista_cargos;
    }


}
