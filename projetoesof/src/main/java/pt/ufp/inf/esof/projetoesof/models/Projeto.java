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
    Estado estado;


    @ManyToOne
    private Cliente cliente;

    @OneToMany
    private List<Tarefa> lista_tarefas = new ArrayList<>();

    public Projeto() {

    }

    public Projeto(int id, String nome, Cliente cliente, List<Tarefa> lista_tarefas) {
        this.id = id;
        this.nome = nome;
        this.cliente = cliente;
        this.lista_tarefas = lista_tarefas;
    }

    enum Estado{
        POR_INICIAR,
        INICIADO,
        EM_ANDAMENTO_ATRASADO,
        EM_ANDAMENTO_ADIANTADO,
        CONCLUIDO
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