package dev.Java10x.CadastroDeNinjas.Ninjas;
import dev.Java10x.CadastroDeNinjas.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaDTO {

    private long id;
    private String nome;
    private String email;
    private int idade;
    private MissoesModel missoes;
    private String rank;


}
