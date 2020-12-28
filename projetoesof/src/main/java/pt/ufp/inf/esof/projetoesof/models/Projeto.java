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
    private String estado;

    //  POR_INICIAR(1)
    //  INICIADO(2)
    //  EM_ANDAMENTO_ATRASADO(3)
    //  EM_ANDAMENTO_ADIANTADO(4)
    //  CONCLUIDO(5)


   /* public enum Estado {

        POR_INICIAR(1), //calls constructor with value 1
        INICIADO(2),
        EM_ANDAMENTO_ATRASADO(3),
        EM_ANDAMENTO_ADIANTADO(4),
        CONCLUIDO(5)
        ; // semicolon needed when fields / methods follow


        private final int _estado;

        private Estado(int _estado) {
            this._estado = _estado;
        }
    }*/

    @ManyToOne
    private Cliente cliente;

    @OneToMany
    private List<Tarefa> lista_tarefas = new ArrayList<>();

    public Projeto() {

    }

    public Projeto(int id, String nome, String estado, Cliente cliente, List<Tarefa> lista_tarefas) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
        this.cliente = cliente;
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

    public void setEstado(int estado) {

        if (estado == 1){
            this.estado = "Por Iniciar";
        }else if (estado == 2){
            this.estado = "Iniciado";
        }else if (estado == 3){
            this.estado = "Em andamento atrasado";
        }else if (estado == 4){
            this.estado = "Em andamento adiantado";
        }else if (estado == 5){
            this.estado = "Concluido";
        }else{
            this.estado = null;
        }

    }




}
