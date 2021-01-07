package pt.ufp.inf.esof.projetoesof.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.ufp.inf.esof.projetoesof.models.Projeto;
import pt.ufp.inf.esof.projetoesof.services.ProjetoService;

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


}
