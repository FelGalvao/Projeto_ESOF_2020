package pt.ufp.inf.esof.projetoesof.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private int duracao;
    private String estado;

    @ManyToOne
    private Projeto projeto;

    @ManyToMany
    private List<Empregado> lista_empregados = new ArrayList<>();

    public Tarefa(){

    }

    public Tarefa(int id, String nome, int duracao, Projeto projeto, List<Empregado> lista_empregados) {
        this.id = id;
        this.nome = nome;
        this.duracao = duracao;
        this.projeto = projeto;
        this.lista_empregados = lista_empregados;
    }

    public void addEmpregado(Empregado e){
        this.lista_empregados.add(e);
        e.getLista_tarefas().add(this);
    }

    public void removeEmpregado(Empregado e){
        this.lista_empregados.remove(e);
        e.getLista_tarefas().remove(this);
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
