package pt.ufp.inf.esof.projetoesof;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pt.ufp.inf.esof.projetoesof.models.*;
import pt.ufp.inf.esof.projetoesof.repositories.ClienteRepoI;

@Component
public class Inicializacao implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ClienteRepoI clienteRepoI;

    @SneakyThrows
    @Override
    public void onApplicationEvent (ContextRefreshedEvent contextRefreshedEvent){
        Cliente cliente=new Cliente();
        cliente.setId(123L);
        cliente.setNome("Fernando Mendes");
        cliente.setIdade(56);

        Cliente cliente2=new Cliente();
        cliente2.setId(13124L);
        cliente2.setNome("Cavaco Silva");
        cliente2.setIdade(48);


        clienteRepoI.save(cliente);
        clienteRepoI.save(cliente2);



    }
}
