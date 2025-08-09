package dev.Java10x.CadastroDeNinjas.Missoes;
import dev.Java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesDTO {

    private long id;
    private String nome;
    private String dificuldade;
    private List<NinjaModel> ninja;


}
