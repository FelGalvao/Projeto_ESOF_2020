package pt.ufp.inf.esof.projetoesof.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.ufp.inf.esof.projetoesof.models.Cliente;
import pt.ufp.inf.esof.projetoesof.services.ClienteService;

import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping()
public ResponseEntity<Iterable<Cliente>>getAllClientes(){

    Iterable<Cliente> clientes = clienteService.getAllClientes();
    return ResponseEntity.ok(clientes);

}

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id){
        Optional<Cliente> optionalCliente=clienteService.findById(id);
        return optionalCliente.map(cliente -> {
            return ResponseEntity.ok(cliente);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }



}
