package pt.ufp.inf.esof.projetoesof.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tipo;
    private int valor_hora;

    @ManyToMany
    private List<Empregado> lista_empregados = new ArrayList<>();

    public Cargo(){

    }

    public Cargo(int id, String tipo, int valor_hora, List<Empregado> lista_empregados) {
        this.id = id;
        this.tipo = tipo;
        this.valor_hora = valor_hora;
        this.lista_empregados = lista_empregados;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getValor_hora() {
        return valor_hora;
    }

    public void setValor_hora(int valor_hora) {
        this.valor_hora = valor_hora;
    }

    public List<Empregado> getLista_empregados() {
        return lista_empregados;
    }

    public void setLista_empregados(List<Empregado> lista_empregados) {
        this.lista_empregados = lista_empregados;
    }
}