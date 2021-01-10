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
    //@ManyToOne
    //private Cliente cliente;

    @JsonIgnore
    @OneToMany
    private List<Projeto> lista_projetos = new ArrayList<>();

    public Cliente(){ }

    public Cliente( String nome, int idade, /*Cliente cliente,*/ List<Projeto> lista_projetos) {
        this.nome = nome;
        this.idade = idade;
        //this.cliente = cliente;
        this.lista_projetos = lista_projetos;
    }


    public void addProjeto(Projeto p){
        this.lista_projetos.add(p);
        p.setCliente(this);
    }

    public void removeProjeto(Projeto p){
        this.lista_projetos.remove(p);
        p.setCliente(null); // não tenho a certeza se será preciso, não sei se o remove não fará isso
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

   /* public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }*/

    public List<Projeto> getLista_projetos() {
        return lista_projetos;
    }

    public void setLista_projetos(List<Projeto> lista_projetos) {
        this.lista_projetos = lista_projetos;
    }
}