package pt.ufp.inf.esof.projetoesof.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ufp.inf.esof.projetoesof.models.Tarefa;
import pt.ufp.inf.esof.projetoesof.repositories.TarefaRepoI;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepoI tarefaRepoI;

    public Iterable<Tarefa> getAllTarefas(){return tarefaRepoI.findAll();}
}
