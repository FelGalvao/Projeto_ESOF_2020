package pt.ufp.inf.esof.projetoesof.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pt.ufp.inf.esof.projetoesof.dtos.EmpregadoResponseDTO;
import pt.ufp.inf.esof.projetoesof.models.Cliente;
import pt.ufp.inf.esof.projetoesof.models.Empregado;
import pt.ufp.inf.esof.projetoesof.services.ClienteService;
import pt.ufp.inf.esof.projetoesof.services.EmpregadoService;

import java.util.Optional;

@RestController
@RequestMapping("/empregado")
public class    EmpregadoController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmpregadoService empregadoService;

    @GetMapping()
    public ResponseEntity<Iterable<Empregado>> getAllEmpregados(){
        this.logger.info("Pedido GET recebido com sucesso.");

        Iterable<Empregado> empregados = empregadoService.getAllEmpregados();
        return ResponseEntity.ok(empregados);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Empregado> getEmpregadoById(@PathVariable Long id){
        this.logger.info("Pedido GET recebido com sucesso.");
        Optional<Empregado> optionalEmpregado=empregadoService.findById(id);
        return optionalEmpregado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Empregado> createEmpregado(@RequestBody Empregado empregado){
          this.logger.info("Pedido POST recebido com sucesso.");
             Empregado e = empregadoService.createEmpregado(empregado);
             return ResponseEntity.ok(e);
    }





}
