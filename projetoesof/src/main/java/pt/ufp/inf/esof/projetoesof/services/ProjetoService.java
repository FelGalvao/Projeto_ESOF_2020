package pt.ufp.inf.esof.projetoesof.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ufp.inf.esof.projetoesof.models.Projeto;
import pt.ufp.inf.esof.projetoesof.repositories.ProjetoRepoI;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepoI projetoRepoI;

    public Iterable<Projeto> getAllProjetos(){
        return projetoRepoI.findAll();
    }
}
