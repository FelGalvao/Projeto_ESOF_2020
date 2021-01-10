package pt.ufp.inf.esof.projetoesof.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ufp.inf.esof.projetoesof.models.Cliente;
import pt.ufp.inf.esof.projetoesof.repositories.ClienteRepoI;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepoI clienteRepoI;


    public Iterable<Cliente> getAllClientes(){
        return clienteRepoI.findAll();
    }

    public Optional<Cliente> findById(Long id){
       return clienteRepoI.findById(id);

    }
    /*public Optional<Cliente> updateCliente(Cliente cliente){

    }*/

}
