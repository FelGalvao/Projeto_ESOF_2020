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

    @ManyToMany
    private List<Cargo> lista_cargos = new ArrayList<>();


    public Empregado() {

    }

    public Empregado(int id, String nome, List<Tarefa> lista_tarefas, List<Cargo> lista_cargos) {
        this.id = id;
        this.nome = nome;
        this.lista_tarefas = lista_tarefas;
        this.lista_cargos = lista_cargos;
    }

    public void addTarefa(Tarefa t){
        t.addEmpregado(this);
    }

    public void removeTarefa(Tarefa t){
        t.removeEmpregado(this);
    }

    public void addCargo(Cargo c){
        this.lista_cargos.add(c);
        c.getLista_empregados().add(this);
    }

    public void removeCargo(Cargo c){
        this.lista_cargos.remove(c);
        c.getLista_empregados().remove(this);
    }





    // não tenho a certeza se será preciso, não sei se o remove não fará isso
}
