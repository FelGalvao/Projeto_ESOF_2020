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
    private float valor_minuto;

    @ManyToMany
    private List<Empregado> lista_empregados = new ArrayList<>();

    public Cargo(){

    }

    public Cargo(String tipo, float valor_minuto, List<Empregado> lista_empregados) {
        this.tipo = tipo;
        this.valor_minuto = valor_minuto;
        this.lista_empregados = lista_empregados;
    }


}
