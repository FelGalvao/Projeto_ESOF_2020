package pt.ufp.inf.esof.projetoesof.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pt.ufp.inf.esof.projetoesof.models.Tarefa;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TarefaCreateDTO implements CreateDTO<Tarefa> {

    Logger logger= LoggerFactory.getLogger(this.getClass());

    private String nome;
    private int estimativa;
    Tarefa.Estado estado;

    @Override
    public Tarefa converter(){
        logger.info("Convertido para Modelo");
        Tarefa tarefa = new Tarefa();
        tarefa.setNome(this.getNome());
        tarefa.setEstimativa(this.getEstimativa());
        tarefa.setEstado(this.getEstado());
        return tarefa;

    }

}
