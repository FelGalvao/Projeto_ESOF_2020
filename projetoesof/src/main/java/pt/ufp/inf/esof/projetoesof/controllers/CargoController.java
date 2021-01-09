package pt.ufp.inf.esof.projetoesof.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.ufp.inf.esof.projetoesof.models.Cargo;
import pt.ufp.inf.esof.projetoesof.services.CargoService;

@RestController
@RequestMapping("/cargo")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @GetMapping()
    public ResponseEntity<Iterable<Cargo>> getAllCargos(){
        //this.logger.info("");

        Iterable<Cargo> cargos = cargoService.getAllCargos();
        return ResponseEntity.ok(cargos);

    }
}
