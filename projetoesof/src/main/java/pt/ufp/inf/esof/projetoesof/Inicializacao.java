package pt.ufp.inf.esof.projetoesof;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pt.ufp.inf.esof.projetoesof.models.*;
import pt.ufp.inf.esof.projetoesof.repositories.*;

@Component
public class Inicializacao implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ClienteRepoI clienteRepoI;
    @Autowired
    private EmpregadoRepoI empregadoRepoI;
    @Autowired
    private CargoRepoI cargoRepoI;
    @Autowired
    private ProjetoRepoI projetoRepoI;
    @Autowired
    private TarefaRepoI tarefaRepoI;


    @SneakyThrows
    @Override
    public void onApplicationEvent (ContextRefreshedEvent contextRefreshedEvent){
       Cliente cliente=new Cliente();
        cliente.setNome("Fernando Mendes");
        cliente.setIdade(56);

        Cliente cliente2=new Cliente();
        cliente2.setNome("Cavaco Silva");
        cliente2.setIdade(48);


        clienteRepoI.save(cliente);
        clienteRepoI.save(cliente2);

        Empregado empregado1 = new Empregado();
        empregadoRepoI.save(empregado1);
        empregado1.setNome("Joaquim Manuel");


        //Empregado empregado2=new Empregado();
        //empregadoRepoI.save(empregado2);
        //empregado2.setNome("Afonso Dias");
        //empregadoRepoI.save(empregado2);


        Cargo cargo1= new Cargo();
        cargo1.setTipo("Desenvolvedor Júnior");
        cargo1.setValor_hora(10);

        Cargo cargo2 = new Cargo();
        cargo2.setTipo("Analista Júnior");
        cargo2.setValor_hora(20);

        Cargo cargo3 = new Cargo();
        cargo3.setTipo("Desenvolvedor Sénior");
        cargo3.setValor_hora(40);

        Cargo cargo4 = new Cargo();
        cargo4.setTipo("Analista Sénior");
        cargo4.setValor_hora(80);

        cargoRepoI.save(cargo1);
        cargoRepoI.save(cargo2);
        cargoRepoI.save(cargo3);
        cargoRepoI.save(cargo4);

        empregado1.addCargo(cargo1);
        //empregadoRepoI.save(empregado1);

        //empregado2.addCargo(cargo2);



        Projeto projeto1 = new Projeto();
        projeto1.setNome("Primeiro Projeto");
        projeto1.setEstado(Projeto.Estado.INICIADO);
        projetoRepoI.save(projeto1);



        Tarefa tarefa1 = new Tarefa();
        tarefaRepoI.save(tarefa1);
        tarefa1.setNome("Primeira Tarefa");
        tarefa1.setEstimativa(10);
        tarefa1.setEstado(Tarefa.Estado.INICIADO);



        Tarefa tarefa2 = new Tarefa();
        tarefa2.setNome("Segunda Tarefa");
        tarefa2.setEstimativa(20);
        tarefa2.setEstado(Tarefa.Estado.POR_INICIAR);


        empregado1.addTarefa(tarefa1);
        //empregadoRepoI.save(empregado1);


        //empregado2.addTarefa(tarefa2);
        projeto1.addTarefa(tarefa1);
        projeto1.addTarefa(tarefa2);
        cliente.addProjeto(projeto1);

        
        tarefaRepoI.save(tarefa1);
        tarefaRepoI.save(tarefa2);

        empregadoRepoI.save(empregado1);
        //empregadoRepoI.save(empregado2);


        projetoRepoI.save(projeto1);



        clienteRepoI.save(cliente);













    }
}
