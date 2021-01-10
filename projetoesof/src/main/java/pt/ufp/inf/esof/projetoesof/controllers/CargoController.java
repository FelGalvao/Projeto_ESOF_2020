package pt.ufp.inf.esof.projetoesof.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CargoService cargoService;

    @GetMapping()
    public ResponseEntity<Iterable<Cargo>> getAllCargos(){
        this.logger.info("Pedido GET recebido com sucesso.");

        Iterable<Cargo> cargos = cargoService.getAllCargos();
        return ResponseEntity.ok(cargos);

    }
}
