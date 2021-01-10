package pt.ufp.inf.esof.projetoesof.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pt.ufp.inf.esof.projetoesof.models.Empregado;
import pt.ufp.inf.esof.projetoesof.models.Projeto;
import pt.ufp.inf.esof.projetoesof.models.Tarefa;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TarefaCreateDTO implements CreateDTO<Tarefa> {

    Logger logger= LoggerFactory.getLogger(this.getClass());

    private String nome;
    private int duracao;
    private int duracao_estimada;
    Tarefa.Estado estado;
    Empregado empregado;
    Projeto projeto;

    @Override
    public Tarefa converter(){
        logger.info("Convertido para Modelo");
        Tarefa tarefa = new Tarefa();
        tarefa.setNome(this.getNome());
        tarefa.setDuracao(this.getDuracao());
        tarefa.setDuracao_estimada(this.getDuracao_estimada());
        tarefa.setEstado(this.getEstado());
        tarefa.setEmpregado(this.getEmpregado());
        tarefa.setProjeto(this.projeto);
        return tarefa;

    }


}
