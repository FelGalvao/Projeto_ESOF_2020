package pt.ufp.inf.esof.projetoesof.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ufp.inf.esof.projetoesof.dtos.DTOStaticFactory;
import pt.ufp.inf.esof.projetoesof.dtos.ProjetoCreateDTO;
import pt.ufp.inf.esof.projetoesof.dtos.ProjetoResponseDTO;
import pt.ufp.inf.esof.projetoesof.dtos.TarefaCreateDTO;
import pt.ufp.inf.esof.projetoesof.models.Cliente;
import pt.ufp.inf.esof.projetoesof.models.Projeto;
import pt.ufp.inf.esof.projetoesof.models.Tarefa;
import pt.ufp.inf.esof.projetoesof.services.ProjetoService;

import java.util.Optional;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProjetoService projetoService;

    private final DTOStaticFactory dtoStaticFactory=DTOStaticFactory.getInstance();


    @GetMapping()
    public ResponseEntity<Iterable<Projeto>> getAllProjetos(){
        this.logger.info("Pedido GET recebido com sucesso.");

        Iterable<Projeto> projetos = projetoService.getAllProjetos();
        return ResponseEntity.ok(projetos);

    }
    @GetMapping("/{id}/tempo")
    public ResponseEntity<Integer> getProjetoTempo(@PathVariable Long id){
        this.logger.info("Pedido GET recebido com sucesso.");
        Optional<Integer> optionalProjeto=projetoService.getProjetoTempo(id);
        return optionalProjeto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping("/{id}/valor")
    public ResponseEntity<Integer> getProjetoValor(@PathVariable Long id){
        this.logger.info("Pedido GET recebido com sucesso.");
        Optional<Integer> optionalProjeto=projetoService.getProjetoValor(id);
        return optionalProjeto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }


    @PostMapping
    public ResponseEntity<ProjetoResponseDTO> createProjeto(@RequestBody Projeto projeto){
        this.logger.info("Pedido POST recebido com sucesso.");
       Optional<Projeto> optionalProjeto = projetoService.createProjeto(projeto);
        return optionalProjeto.map(value -> ResponseEntity.ok(dtoStaticFactory.projetoResponseDTO(value))).orElseGet(() -> ResponseEntity.badRequest().build());
    }

   @PatchMapping("/tarefa/{id}")
   public ResponseEntity<ProjetoResponseDTO> adicionaTarefa(@PathVariable Long id, @RequestBody TarefaCreateDTO tarefa){
        this.logger.info("Pedido PATCH recebido com sucesso.");
    Optional<Projeto>optionalProjeto =projetoService.adicionaTarefa(id, tarefa.converter());
    return optionalProjeto.map(value -> ResponseEntity.ok(dtoStaticFactory.projetoResponseDTO(value ))).orElseGet(() -> ResponseEntity.badRequest().build());
   }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> getprojetoById(@PathVariable Long id){
        this.logger.info("Pedido GET recebido com sucesso.");
        Optional<Projeto> optionalProjeto=projetoService.findById(id);
        return optionalProjeto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/estado")
    public ResponseEntity<Projeto.Estado> getProjetoEstado(@PathVariable Long id){
        this.logger.info("Pedidio GET recebido com sucesso.");
        Optional<Projeto> optionalProjeto=projetoService.findById(id);
        return optionalProjeto.map(projeto -> {
            return ResponseEntity.ok(projeto.getEstado());
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }







}
