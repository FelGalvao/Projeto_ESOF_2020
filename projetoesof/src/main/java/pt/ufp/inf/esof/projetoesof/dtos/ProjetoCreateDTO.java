package pt.ufp.inf.esof.projetoesof.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pt.ufp.inf.esof.projetoesof.models.Cliente;
import pt.ufp.inf.esof.projetoesof.models.Projeto;
import pt.ufp.inf.esof.projetoesof.models.Tarefa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjetoCreateDTO implements CreateDTO<Projeto> {
    Logger logger= LoggerFactory.getLogger(this.getClass());
    private String nome;
    private int valor;
    private int tempo;
    Projeto.Estado estado;
    private Cliente cliente;
    private List<TarefaCreateDTO> lista_tarefas = new ArrayList<>();

    @Override
    public Projeto converter(){
        logger.info("Convertido para Modelo");
        Projeto projeto=new Projeto();
        projeto.setNome(this.getNome());
        projeto.setValor(this.getValor());
        projeto.setTempo(this.getTempo());
        projeto.setEstado(this.getEstado());
        projeto.setCliente(this.cliente);
        projeto.setLista_tarefas(lista_tarefas.stream().map(TarefaCreateDTO::converter).collect(Collectors.toList()));
        return projeto;
    }

}
