package pt.ufp.inf.esof.projetoesof.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CargoResponseDTO {
    private String tipo;
    private int valor_hora;
    private List<EmpregadoCreateDTO> lista_empregados = new ArrayList<>();

}
