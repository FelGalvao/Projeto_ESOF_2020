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
    private Long id;
    private String nome;
    //private int duracao;
    private int estimativa;
    Estado estado;

    @ManyToOne
    private Empregado empregado;


    @ManyToOne
    private Projeto projeto;

    public Tarefa(){

    }

    public Tarefa(String nome, int estimativa, Projeto projeto) {

        this.nome = nome;
        this.estimativa = estimativa; //duracao = duracao;
        this.projeto = projeto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstimativa() {
        return estimativa;//duracao;
    }

    public void setEstimativa(int estimativa) {
        this.estimativa = estimativa; // = duracao;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Empregado getEmpregado() {
        return empregado;
    }

    public void setEmpregado(Empregado empregado) {
        this.empregado = empregado;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", nome= " + nome + '\'' +
                ", duracao=" + estimativa +
                ", estado=" + estado +
                ", empregado=" + empregado +
                ", projeto=" + projeto +
                '}';
    }


    public enum Estado{
        POR_INICIAR,
        INICIADO,
        EM_ANDAMENTO_ATRASADO,
        EM_ANDAMENTO_ADIANTADO,
        CONCLUIDO
    }

    /*@Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", duracao=" + duracao +
                ", estado=" + estado +
                //", empregado=" + empregado +
                ", projeto=" + projeto +
                '}';
    }*/


}