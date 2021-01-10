package pt.ufp.inf.esof.projetoesof.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pt.ufp.inf.esof.projetoesof.models.Projeto;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteResponseDTO {
    private String nome;
    private int idade;
    private List<ProjetoCreateDTO> lista_projetos = new ArrayList<>();

}
