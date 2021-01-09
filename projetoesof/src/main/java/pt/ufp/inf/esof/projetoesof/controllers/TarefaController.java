package pt.ufp.inf.esof.projetoesof.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ufp.inf.esof.projetoesof.models.Empregado;
import pt.ufp.inf.esof.projetoesof.models.Projeto;
import pt.ufp.inf.esof.projetoesof.models.Tarefa;
import pt.ufp.inf.esof.projetoesof.services.TarefaService;

import java.util.Optional;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<Iterable<Tarefa>> getAllTarefas(){
        //this.logger.info("");

        Iterable<Tarefa> tarefas = tarefaService.getAllTarefas();
        return ResponseEntity.ok(tarefas);

    }

    @PostMapping
    public ResponseEntity<Tarefa> createTarefa(@RequestBody Tarefa tarefa){
        //this.logger.info("");
        Optional<Tarefa> optionalTarefa = tarefaService.createTarefa(tarefa);
        if(optionalTarefa.isPresent()){
            return ResponseEntity.ok(optionalTarefa.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @PatchMapping("/empregado/{id}")
    public ResponseEntity<Tarefa> adicionaEmpregado(@PathVariable Long id, @RequestBody Empregado empregado){
        Optional<Tarefa>optionalTarefa =tarefaService.adicionaEmpregado(id, empregado);
        return optionalTarefa.map(tarefa -> ResponseEntity.ok(tarefa)).orElseGet(() -> ResponseEntity.notFound().build() );
    }

}
