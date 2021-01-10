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
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int valor;
    private int tempo;

    Estado estado;



    @ManyToOne
    private Cliente cliente;
    @JsonIgnore
    @OneToMany
    private List<Tarefa> lista_tarefas = new ArrayList<>();

    public Projeto() {

    }

    public Projeto( String nome, Cliente cliente, List<Tarefa> lista_tarefas) {

        this.nome = nome;
        this.cliente = cliente;
        this.lista_tarefas = lista_tarefas;
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

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Tarefa> getLista_tarefas() {
        return lista_tarefas;
    }

    public void setLista_tarefas(List<Tarefa> lista_tarefas) {
        this.lista_tarefas = lista_tarefas;
    }

    public enum Estado{
        POR_INICIAR,
        INICIADO,
        EM_ANDAMENTO_ATRASADO,
        EM_ANDAMENTO_ADIANTADO,
        CONCLUIDO
    }

    public void addTarefa(Tarefa t){
        this.lista_tarefas.add(t);
        t.setProjeto(this);
    }

    public void removeTarefa(Tarefa t){
        this.lista_tarefas.remove(t);
        t.setProjeto(null); //acho que não será preciso
    }

    public int calcularValor(){
        int total=0; valor=0;
        for (Tarefa t:this.lista_tarefas) {
          valor= t.getEmpregado().getCargo().getValor_hora() * t.getEstimativa();
          valor=valor/60;
           total= total + valor;

            }
        this.valor=total;
         return total;

        }

        public int calcularTempo(){
        int tempo=0;
        for (Tarefa t:this.lista_tarefas) {
            tempo= tempo +t.getEstimativa();

        }
        return tempo;
    }


}







