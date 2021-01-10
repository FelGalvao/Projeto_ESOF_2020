package pt.ufp.inf.esof.projetoesof.dtos;

import pt.ufp.inf.esof.projetoesof.models.Tarefa;

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

    public TarefaResponseDTO tarefaResponseDTO ( Tarefa tarefa){
        return TarefaResponseDTO.builder()
                .nome(tarefa.getNome())
                .estado(tarefa.getEstado())
                .empregado(tarefa.getEmpregado())
                .projeto(tarefa.getProjeto())
                .build();
    }


}
