package pt.ufp.inf.esof.projetoesof.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ufp.inf.esof.projetoesof.dtos.DTOStaticFactory;
import pt.ufp.inf.esof.projetoesof.dtos.TarefaCreateDTO;
import pt.ufp.inf.esof.projetoesof.dtos.TarefaResponseDTO;
import pt.ufp.inf.esof.projetoesof.models.Empregado;
import pt.ufp.inf.esof.projetoesof.models.Tarefa;
import pt.ufp.inf.esof.projetoesof.services.TarefaService;

import java.util.Optional;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TarefaService tarefaService;

    private final DTOStaticFactory dtoStaticFactory=DTOStaticFactory.getInstance();



    @GetMapping
    public ResponseEntity<Iterable<Tarefa>> getAllTarefas(){
        this.logger.info("Pedido GET recebido com sucesso.");

        Iterable<Tarefa> tarefas = tarefaService.getAllTarefas();
        return ResponseEntity.ok(tarefas);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> gettarefaById(@PathVariable Long id){
        this.logger.info("Pedido GET recebido com sucesso.");
        Optional<Tarefa> optionalTarefa=tarefaService.findById(id);
        return optionalTarefa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

   /* @PostMapping
    public ResponseEntity<Tarefa> createTarefa(@RequestBody Tarefa tarefa){
        this.logger.info("Pedido POST recebido com sucesso.");
        Optional<Tarefa> optionalTarefa = tarefaService.createTarefa(tarefa);
        return optionalTarefa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }*/

    @PatchMapping("/empregado/{id}")
    public ResponseEntity<Tarefa> adicionaEmpregado(@PathVariable Long id, @RequestBody Empregado empregado){
        this.logger.info("Pedido PATCH recebido com sucesso.");
        Optional<Tarefa>optionalTarefa =tarefaService.adicionaEmpregado(id, empregado);
        return optionalTarefa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build() );
    }

    @GetMapping("/{id}/estado")
    public ResponseEntity<Tarefa.Estado> getTarefaEstado(@PathVariable Long id){
        this.logger.info("Pedidio GET recebido com sucesso.");
        Optional<Tarefa> optionalTarefa=tarefaService.findById(id);
        return optionalTarefa.map(tarefa -> {
            return ResponseEntity.ok(tarefa.getEstado());
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<TarefaResponseDTO> createExplicador(@RequestBody TarefaCreateDTO tarefa){
        Optional<Tarefa> optionalTarefa=tarefaService.createTarefa(tarefa.converter());
        return optionalTarefa.map(value -> ResponseEntity.ok(dtoStaticFactory.tarefaResponseDTO(value))).orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
