package pt.ufp.inf.esof.projetoesof.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ufp.inf.esof.projetoesof.models.Cliente;
import pt.ufp.inf.esof.projetoesof.models.Empregado;
import pt.ufp.inf.esof.projetoesof.repositories.EmpregadoRepoI;

import java.util.Optional;

@Service
public class EmpregadoService {

    @Autowired
    private EmpregadoRepoI empregadoRepoI;

    public Iterable<Empregado> getAllEmpregados(){
        return empregadoRepoI.findAll();
    }

    public Optional<Empregado> findById(Long id){
        return empregadoRepoI.findById(id);

    }

    public Empregado createEmpregado(Empregado empregado) {

        return empregadoRepoI.save(empregado);
    }

}
