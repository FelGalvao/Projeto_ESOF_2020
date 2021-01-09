package pt.ufp.inf.esof.projetoesof.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ufp.inf.esof.projetoesof.models.Cliente;
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

    @PostMapping("/create")
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
        return optionalTarefa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build() );
    }

    @GetMapping("/{id}/estado")
    public ResponseEntity<Tarefa.Estado> getTarefaEstado(@PathVariable Long id){
        Optional<Tarefa> optionalTarefa=tarefaService.findById(id);
        return optionalTarefa.map(tarefa -> {
            return ResponseEntity.ok(tarefa.getEstado());
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
