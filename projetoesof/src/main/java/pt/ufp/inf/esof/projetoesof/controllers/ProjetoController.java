package pt.ufp.inf.esof.projetoesof.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.ufp.inf.esof.projetoesof.models.Cliente;
import pt.ufp.inf.esof.projetoesof.models.Projeto;
import pt.ufp.inf.esof.projetoesof.models.Tarefa;
import pt.ufp.inf.esof.projetoesof.services.ProjetoService;

import java.util.Optional;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping()
    public ResponseEntity<Iterable<Projeto>> getAllProjetos(){
        //this.logger.info("");

        Iterable<Projeto> projetos = projetoService.getAllProjetos();
        return ResponseEntity.ok(projetos);

    }
    @GetMapping("/{id}/tempo")
    public ResponseEntity<Integer> getProjetoTempo(@PathVariable Long id){
        Optional<Integer> optionalProjeto=projetoService.getProjetoTempo(id);
        return optionalProjeto.map(projeto -> {
            return ResponseEntity.ok(projeto);
        }).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping("/{id}/valor")
    public ResponseEntity<Integer> getProjetoValor(@PathVariable Long id){
        Optional<Integer> optionalProjeto=projetoService.getProjetoValor(id);
        return optionalProjeto.map(projeto -> {
            return ResponseEntity.ok(projeto);
        }).orElseGet(() -> ResponseEntity.notFound().build());

    }







    @PostMapping
    public ResponseEntity<Projeto> createProjeto(@RequestBody Projeto projeto){
        //this.logger.info("");
       Optional<Projeto> optionalProjeto = projetoService.createProjeto(projeto);
        if(optionalProjeto.isPresent()){
            return ResponseEntity.ok(optionalProjeto.get());
        }
        return ResponseEntity.badRequest().build();
    }




}
