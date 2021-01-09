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
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tipo;
    private int valor_hora;

    @JsonIgnore
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

}