package pt.ufp.inf.esof.projetoesof.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.ufp.inf.esof.projetoesof.models.Projeto;

@Repository
public interface ProjetoRepoI extends CrudRepository<Projeto, Long> {
}
