package pt.ufp.inf.esof.projetoesof.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ufp.inf.esof.projetoesof.models.Cliente;
import pt.ufp.inf.esof.projetoesof.models.Empregado;
import pt.ufp.inf.esof.projetoesof.models.Projeto;
import pt.ufp.inf.esof.projetoesof.models.Tarefa;
import pt.ufp.inf.esof.projetoesof.repositories.ClienteRepoI;
import pt.ufp.inf.esof.projetoesof.repositories.ProjetoRepoI;
import pt.ufp.inf.esof.projetoesof.repositories.TarefaRepoI;

import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepoI tarefaRepoI;

    @Autowired
    private ProjetoRepoI projetoRepoI;

    public Iterable<Tarefa> getAllTarefas(){return tarefaRepoI.findAll()    ;}

    public Optional <Tarefa> createTarefa(Tarefa tarefa){
       Optional<Projeto> optionalProjeto = projetoRepoI.findById(tarefa.getProjeto().getId());
       if(optionalProjeto.isPresent()){
           Projeto projeto = optionalProjeto.get();
           projeto.addTarefa(tarefa);
           projetoRepoI.save(projeto);
           return Optional.of(tarefaRepoI.save(tarefa));
       }
           return Optional.empty();
    }

    public Optional<Tarefa> adicionaEmpregado(Long tarefaId, Empregado empregado) {
        Optional<Tarefa> optionalTarefa = tarefaRepoI.findById(tarefaId);
        if (optionalTarefa.isPresent()) {
            Tarefa tarefa = optionalTarefa.get();
            tarefa.setEmpregado(empregado);
            empregado.addTarefa(tarefa);
            return optionalTarefa;

        }
        return Optional.empty();

    }

    public Optional<Tarefa> findById(Long id){
        return tarefaRepoI.findById(id);

    }


}
