package pt.ufp.inf.esof.projetoesof.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.ufp.inf.esof.projetoesof.models.Projeto;
import pt.ufp.inf.esof.projetoesof.models.Cliente;
import pt.ufp.inf.esof.projetoesof.models.Tarefa;
import pt.ufp.inf.esof.projetoesof.repositories.ClienteRepoI;
import pt.ufp.inf.esof.projetoesof.repositories.ProjetoRepoI;

import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepoI projetoRepoI;

    private ClienteRepoI clienteRepoI;

    public Iterable<Projeto> getAllProjetos() {
        return projetoRepoI.findAll();
    }

    public Optional<Projeto> createProjeto(Projeto projeto) {
        Optional<Cliente> optionalCliente = clienteRepoI.findById(projeto.getCliente().getId());
        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            cliente.addProjeto(projeto);
            clienteRepoI.save(cliente);
            return Optional.of(projetoRepoI.save(projeto));
        }

        return Optional.empty();
    }


    public Optional<Integer> getProjetoTempo(Long id) {
        int tempo = 0;
        Optional<Projeto> p = projetoRepoI.findById(id);
        if(p.isPresent()) {
            Projeto projeto = p.get();
            tempo = projeto.calcularTempo();
            return Optional.of(tempo);
        }
        return Optional.empty();
    }

    public Optional<Integer> getProjetoValor(Long id) {
        int valor = 0;
        Optional<Projeto> p = projetoRepoI.findById(id);
        if(p.isPresent()) {
            Projeto projeto = p.get();
            valor = projeto.calcularValor();
            return Optional.of(valor);
        }
        return Optional.empty();
    }

    public Optional<Projeto> adicionaTarefa(Long projetoId, Tarefa tarefa) {
        Optional<Projeto> optionalProjeto = projetoRepoI.findById(projetoId);
        if (optionalProjeto.isPresent()) {
            Projeto projeto = optionalProjeto.get();
            tarefa.setProjeto(projeto);
            projeto.addTarefa(tarefa);
            return optionalProjeto;

        }
        return Optional.empty();

    }
    public Optional<Projeto> findById(Long id){
        return projetoRepoI.findById(id);

    }
}
