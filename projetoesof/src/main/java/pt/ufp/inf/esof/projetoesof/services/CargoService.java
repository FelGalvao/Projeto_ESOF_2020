package pt.ufp.inf.esof.projetoesof.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ufp.inf.esof.projetoesof.models.Cargo;
import pt.ufp.inf.esof.projetoesof.repositories.CargoRepoI;

@Service
public class CargoService {

    @Autowired
    private CargoRepoI cargoRepoI;

    public Iterable<Cargo> getAllCargos(){
        return cargoRepoI.findAll();
    }
}
