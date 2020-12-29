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
    Estado estado;


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

    enum Estado{
        POR_INICIAR,
        INICIADO,
        EM_ANDAMENTO_ATRASADO,
        EM_ANDAMENTO_ADIANTADO,
        CONCLUIDO
    }


    public void addEmpregado(Empregado e){
        this.lista_empregados.add(e);
        e.getLista_tarefas().add(this);
    }

    public void removeEmpregado(Empregado e){
        this.lista_empregados.remove(e);
        e.getLista_tarefas().remove(this);
    }


    public void setEstado(Estado estado) {

        if (estado == Estado.POR_INICIAR) {
            this.setEstado(Estado.POR_INICIAR);
        } else if (estado == Estado.INICIADO) {
            this.setEstado(Estado.INICIADO);
        } else if (estado == Estado.EM_ANDAMENTO_ATRASADO) {
            this.setEstado(Estado.EM_ANDAMENTO_ATRASADO);
        } else if (estado == Estado.EM_ANDAMENTO_ADIANTADO) {
            this.setEstado(Estado.EM_ANDAMENTO_ADIANTADO);
        } else if (estado == Estado.CONCLUIDO) {
            this.setEstado(Estado.CONCLUIDO);
        }
    }

    public void mudaEstado(Estado estado){
        this.setEstado(estado);
    }


}
