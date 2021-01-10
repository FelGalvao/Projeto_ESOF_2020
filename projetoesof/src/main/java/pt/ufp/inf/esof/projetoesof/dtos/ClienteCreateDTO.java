package pt.ufp.inf.esof.projetoesof.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pt.ufp.inf.esof.projetoesof.models.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteCreateDTO implements CreateDTO<Cliente> {
    Logger logger= LoggerFactory.getLogger(this.getClass());
    private String nome;
    private int idade;
    private List<ProjetoCreateDTO> lista_projetos = new ArrayList<>();

    @Override
    public Cliente converter(){
        logger.info("Convertido para Modelo");
        Cliente cliente= new Cliente();
        cliente.setNome(this.getNome());
        cliente.setIdade(this.getIdade());
        cliente.setLista_projetos(lista_projetos.stream().map(ProjetoCreateDTO::converter).collect(Collectors.toList()));
        return cliente;
    }

}
