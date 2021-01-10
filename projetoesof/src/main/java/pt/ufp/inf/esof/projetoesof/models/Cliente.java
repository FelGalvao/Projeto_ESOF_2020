package pt.ufp.inf.esof.projetoesof.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;

    @JsonIgnore
    @OneToMany
    private List<Projeto> lista_projetos = new ArrayList<>();

    public Cliente(){ }

    public Cliente( String nome, int idade, List<Projeto> lista_projetos) {
        this.nome = nome;
        this.idade = idade;
        this.lista_projetos = lista_projetos;
    }


    /**
     * Função para adicionar um projeto criado previamente à lista de projetos do cliente correspondente
     * @param p projeto a ser adicionado
     */
    public void addProjeto(Projeto p){
        this.lista_projetos.add(p);
        p.setCliente(this);
    }


    /**
     * Função para remover um projeto da lista de projetos do cliente
     * @param p projeto a ser removido
     */
    public void removeProjeto(Projeto p) {
        this.lista_projetos.remove(p);
        p.setCliente(null); // não tenho a certeza se será preciso, não sei se o remove não fará isso
    }
}