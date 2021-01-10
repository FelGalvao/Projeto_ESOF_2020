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

        /**++++++++++++++ Cargos +++++++++++++*/

        Cargo cargo1= new Cargo();
        cargoRepoI.save(cargo1);
        cargo1.setTipo("Desenvolvedor Júnior");
        cargo1.setValor_hora(10);

        Cargo cargo2 = new Cargo();
        cargoRepoI.save(cargo2);
        cargo2.setTipo("Analista Júnior");
        cargo2.setValor_hora(20);

        Cargo cargo3 = new Cargo();
        cargoRepoI.save(cargo3);
        cargo3.setTipo("Desenvolvedor Sénior");
        cargo3.setValor_hora(40);

        Cargo cargo4 = new Cargo();
        cargoRepoI.save(cargo4);
        cargo4.setTipo("Analista Sénior");
        cargo4.setValor_hora(80);

        /**+++++++++++++++++++++++++++++++++++*/


        /**+++++++++++++ Clientes +++++++++++++*/
        Cliente cliente1 = new Cliente();
        clienteRepoI.save(cliente1);
        cliente1.setNome("Fernando Mendes");
        cliente1.setIdade(56);

        Cliente cliente2 = new Cliente();
        clienteRepoI.save(cliente2);
        cliente2.setNome("Cavaco Silva");
        cliente2.setIdade(48);

        /**++++++++++++++++++++++++++++++++++++*/


        /**++++++++++++ Empregados +++++++++++*/
        Empregado empregado1 = new Empregado();
        empregadoRepoI.save(empregado1);
        empregado1.setNome("Joaquim Manuel");


        Empregado empregado2 = new Empregado();
        empregadoRepoI.save(empregado2);
        empregado2.setNome("Afonso Dias");

        empregado1.addCargo(cargo1);
        empregado2.addCargo(cargo2);

        /**+++++++++++++++++++++++++++++++++++*/


        /**+++++++++++++ Projetos +++++++++++++*/

        Projeto projeto1 = new Projeto();
        projetoRepoI.save(projeto1);
        projeto1.setNome("Primeiro Projeto");
        //projeto1.setEstado(Projeto.Estado.INICIADO);

        Projeto projeto2 = new Projeto();
        projetoRepoI.save(projeto2);
        projeto2.setNome("Segundo Projeto");

        /**+++++++++++++++++++++++++++++++++++*/


        /**++++++++++++++ Tarefas ++++++++++++*/
        Tarefa tarefa1 = new Tarefa();
        tarefaRepoI.save(tarefa1);
        tarefa1.setNome("Primeira Tarefa");
        tarefa1.setDuracao_estimada(10);
        tarefa1.setEstado(Tarefa.Estado.INICIADO);

        Tarefa tarefa2 = new Tarefa();
        tarefaRepoI.save(tarefa2);
        tarefa2.setNome("Segunda Tarefa");
        tarefa2.setDuracao_estimada(20);
        tarefa2.setEstado(Tarefa.Estado.POR_INICIAR);

        Tarefa tarefa3 = new Tarefa();
        tarefaRepoI.save(tarefa3);
        tarefa3.setNome("Terceira Tarefa");
        tarefa3.setDuracao_estimada(30);
        tarefa3.setEstado(Tarefa.Estado.CONCLUIDO);

        /**+++++++++++++++++++++++++++++++++++++*/


        empregado1.addTarefa(tarefa1);
        empregado2.addTarefa(tarefa2);

        projeto1.addTarefa(tarefa1);
        projeto1.addTarefa(tarefa3);
        projeto2.addTarefa(tarefa2);

        cliente1.addProjeto(projeto1);
        cliente2.addProjeto(projeto2);

        cargoRepoI.save(cargo1);
        cargoRepoI.save(cargo2);
        cargoRepoI.save(cargo3);
        cargoRepoI.save(cargo4);

        clienteRepoI.save(cliente1);
        clienteRepoI.save(cliente2);

        empregadoRepoI.save(empregado1);
        empregadoRepoI.save(empregado2);

        projeto1.setEstado();
        projeto2.setEstado();
        projetoRepoI.save(projeto1);
        projetoRepoI.save(projeto2);

        tarefaRepoI.save(tarefa1);
        tarefaRepoI.save(tarefa2);
        tarefaRepoI.save(tarefa3);














    }
}
