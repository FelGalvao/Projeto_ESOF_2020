package pt.ufp.inf.esof.projetoesof.dtos;

import pt.ufp.inf.esof.projetoesof.models.Empregado;
import pt.ufp.inf.esof.projetoesof.models.Projeto;
import pt.ufp.inf.esof.projetoesof.models.Tarefa;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DTOStaticFactory {

    private static DTOStaticFactory dtoAbstractFactory;

    private DTOStaticFactory(){

    }

    public static DTOStaticFactory getInstance(){
        if(dtoAbstractFactory==null){
            dtoAbstractFactory=new DTOStaticFactory();
        }
        return dtoAbstractFactory;
    }

    public TarefaCreateDTO tarefaCreateDTO ( Tarefa tarefa){
        return TarefaCreateDTO.builder()
                .nome(tarefa.getNome())
                .estado(tarefa.getEstado())
                .empregado(tarefa.getEmpregado())
                .projeto(tarefa.getProjeto())
                .build();
    }

    public ProjetoResponseDTO projetoResponseDTO(Projeto projeto){

        List<TarefaCreateDTO> projetoResponseDTOS = projeto.getLista_tarefas().stream().map(tarefa ->
                DTOStaticFactory.getInstance().tarefaCreateDTO(tarefa)).collect(Collectors.toList());
        return ProjetoResponseDTO.builder()
                .nome(projeto.getNome())
                .estado(projeto.getEstado())
                .valor(projeto.getValor())
                .tempo(projeto.getTempo())
                .lista_tarefas(projetoResponseDTOS)
                .build();
    }

    public EmpregadoResponseDTO empregadoResponseDTO(Empregado empregado){
        List<TarefaCreateDTO> empregadoResponseDTOS = empregado.getLista_tarefas().stream().map(tarefa ->
                DTOStaticFactory.getInstance().tarefaCreateDTO(tarefa)).collect(Collectors.toList());

        return EmpregadoResponseDTO.builder()
                .nome(empregado.getNome())
                .cargo(empregado.getCargo())
                .lista_tarefas(empregadoResponseDTOS)
                .build();
    }


}
