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
    private int duracao;
    Estado estado;

    @ManyToOne
    private Empregado empregado;


    @ManyToOne
    private Projeto projeto;

    public Tarefa(){

    }

    public Tarefa(String nome, int duracao, Projeto projeto) {

        this.nome = nome;
        this.duracao = duracao;
        this.projeto = projeto;
    }

    public enum Estado{
        POR_INICIAR,
        INICIADO,
        EM_ANDAMENTO_ATRASADO,
        EM_ANDAMENTO_ADIANTADO,
        CONCLUIDO
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", duracao=" + duracao +
                ", estado=" + estado +
                //", empregado=" + empregado +
                ", projeto=" + projeto +
                '}';
    }


}