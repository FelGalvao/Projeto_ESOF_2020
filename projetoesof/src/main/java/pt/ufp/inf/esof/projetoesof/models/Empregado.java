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
    private Long id;
    private String nome;

    @ManyToMany
    private List<Tarefa> lista_tarefas = new ArrayList<>();

    @ManyToOne
    private Cargo cargo;


    public Empregado() {

    }

    public Empregado(Long id, String nome, List<Tarefa> lista_tarefas/*, List<Cargo> lista_cargos*/) {
        this.id = id;
        this.nome = nome;
        this.lista_tarefas = lista_tarefas;
        //this.lista_cargos = lista_cargos;
    }

    public void addTarefa(Tarefa t){
        t.setEmpregado(this);
    }

    public void removeTarefa(Tarefa t){
        t.setEmpregado(null);
    }

    public void addCargo(Cargo c){
        this.setCargo(c);
        c.getLista_empregados().add(this);
    }

    public void removeCargo(Cargo c){
        this.setCargo(null);
        c.getLista_empregados().remove(this);
    }





    // não tenho a certeza se será preciso, não sei se o remove não fará isso
}