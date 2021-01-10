package pt.ufp.inf.esof.projetoesof.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long id;
    private String nome;

    @JsonIgnore
    @ManyToMany
    private List<Tarefa> lista_tarefas = new ArrayList<>();

    @ManyToOne
    private Cargo cargo;


    public Empregado(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Empregado() {

    }

    /**
     * Função que adiciona uma tarefa à lista de tarefas de um empregado
     * @param t tarefa a ser adicionada à lista
     */
    public void addTarefa(Tarefa t){
        t.setEmpregado(this);
        this.lista_tarefas.add(t);
    }


    /**
     * Função que remove uma tarefa da lista de tarefas de um empregado
     * @param t tarefa a ser removida
     */
    public void removeTarefa(Tarefa t){
        t.setEmpregado(null);
        this.lista_tarefas.remove(t);
    }

    /**
     * Função que associa um cargo a um empregado e adiciona o empregado à lista de empregados do cargo
     * @param c cargo a ser associado
     */
    public void addCargo(Cargo c){
        this.setCargo(c);
        c.getLista_empregados().add(this);
    }


    /**
     * Função que desassocia o cargo de um empregado e remove o empregado da lista de empregados do cargo
     * @param c cargo a ser desassociado
     */
    public void removeCargo(Cargo c){
        this.setCargo(null);
        c.getLista_empregados().remove(this);
    }


}