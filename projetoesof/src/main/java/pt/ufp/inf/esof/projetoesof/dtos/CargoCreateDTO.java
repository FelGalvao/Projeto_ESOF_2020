package pt.ufp.inf.esof.projetoesof.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pt.ufp.inf.esof.projetoesof.models.Cargo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CargoCreateDTO implements CreateDTO<Cargo>{
    Logger logger= LoggerFactory.getLogger(this.getClass());

    private String tipo;
    private int valor_hora;
    private List<EmpregadoCreateDTO> lista_empregados = new ArrayList<>();

    @Override
    public Cargo converter(){
        logger.info("Convertido para Modelo");
        Cargo cargo=new Cargo();
        cargo.setTipo(this.tipo);
        cargo.setValor_hora(this.valor_hora);
        cargo.setLista_empregados(lista_empregados.stream().map(EmpregadoCreateDTO::converter).collect(Collectors.toList()));
        return cargo;
    }

}
