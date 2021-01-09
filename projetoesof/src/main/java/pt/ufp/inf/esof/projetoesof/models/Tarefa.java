package pt.ufp.inf.esof.projetoesof.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int duracao;
    private int duracao_estimada;
    Estado estado;
    @JsonIgnore

    @ManyToOne
    private Empregado empregado;


    @ManyToOne
    private Projeto projeto;

    public Tarefa(){

    }

    public Tarefa(String nome, int duracao_estimada, Projeto projeto) {

        this.nome = nome;
        this.duracao_estimada = duracao_estimada; //duracao = duracao;
        this.projeto = projeto;
    }


    public enum Estado{
        POR_INICIAR,
        INICIADO,
        EM_ANDAMENTO_ATRASADO,
        EM_ANDAMENTO_ADIANTADO,
        CONCLUIDO
    }


}