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
          valor= t.getEmpregado().getCargo().getValor_hora() * t.getDuracao_estimada();
          valor=valor/60;
           total= total + valor;

            }
         return tempo;

        }

        public int calcularTempo(){
        int tempo=0;
        for (Tarefa t:this.lista_tarefas) {
            tempo= tempo +t.getDuracao_estimada();

        }
        return tempo;
    }

    public void setEstado() {

        int i = 0;
        double percentagem = 0;
        double estado_percentagem = 0;

        for (Tarefa t : this.getLista_tarefas()){
            if (t.getEstado().equals(Tarefa.Estado.POR_INICIAR) || t.getEstado() == null){
                percentagem = percentagem + 0;
            }else if (t.getEstado().equals(Tarefa.Estado.INICIADO)){
                percentagem = percentagem + 0.25;
            }else if (t.getEstado().equals(Tarefa.Estado.EM_ANDAMENTO_ATRASADO)){
                percentagem = percentagem + 0.5;
            }else if (t.getEstado().equals(Tarefa.Estado.EM_ANDAMENTO_ADIANTADO)){
                percentagem = percentagem + 0.75;
            }else if (t.getEstado().equals(Tarefa.Estado.CONCLUIDO)){
                percentagem = percentagem + 1;
            }
            i++;
        }

        estado_percentagem = percentagem/i;

        if (estado_percentagem == 0){
            this.setEstado(Projeto.Estado.POR_INICIAR);
        }else if(estado_percentagem > 0 && estado_percentagem <= 0.33){
            this.setEstado(Projeto.Estado.INICIADO);
        }else if(estado_percentagem > 0.33 && estado_percentagem <= 0.66){
            this.setEstado(Projeto.Estado.EM_ANDAMENTO_ATRASADO);
        }else if(estado_percentagem > 0.66 && estado_percentagem < 1){
            this.setEstado(Projeto.Estado.EM_ANDAMENTO_ADIANTADO);
        }else if (estado_percentagem == 1){
            this.setEstado(Projeto.Estado.CONCLUIDO);
        }
    }
}







