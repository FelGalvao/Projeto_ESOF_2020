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
    private Enum estado;

    @ManyToOne
    private Projeto projeto;

    @ManyToMany
    private List<Empregado> lista_empregados = new ArrayList<>();

    public Tarefa(){

    }

    public Tarefa(int id, String nome, int duracao, Enum estado, Projeto projeto, List<Empregado> lista_empregados) {
        this.id = id;
        this.nome = nome;
        this.duracao = duracao;
        this.estado = estado;
        this.projeto = projeto;
        this.lista_empregados = lista_empregados;
    }

    public void addEmpregado(Empregado e){
        this.lista_empregados.add(e);

    }


}
