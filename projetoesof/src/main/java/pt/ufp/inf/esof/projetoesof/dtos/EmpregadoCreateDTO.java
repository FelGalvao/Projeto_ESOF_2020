package pt.ufp.inf.esof.projetoesof.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pt.ufp.inf.esof.projetoesof.models.Cargo;
import pt.ufp.inf.esof.projetoesof.models.Empregado;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmpregadoCreateDTO implements CreateDTO<Empregado> {
    Logger logger= LoggerFactory.getLogger(this.getClass());

    private String nome;
    private Cargo cargo;
    private List<TarefaCreateDTO> lista_tarefas = new ArrayList<>();

    @Override
    public Empregado converter(){
        logger.info("Convertido para Modelo");
        Empregado empregado = new Empregado();
        empregado.setNome(this.getNome());
        empregado.setCargo(this.getCargo());
        empregado.setLista_tarefas(lista_tarefas.stream().map(TarefaCreateDTO::converter).collect(Collectors.toList()));

        return empregado;

    }
}
