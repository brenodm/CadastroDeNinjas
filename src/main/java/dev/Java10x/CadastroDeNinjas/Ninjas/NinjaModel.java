package dev.Java10x.CadastroDeNinjas.Ninjas;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.ToString;


// Entity transforma uma classe em uma entidade do DB
@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "missoes")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name= "id")
    private long id;

    @Column (name= "nome")
    private String nome;

    @Column (name= "email")
    private String email;

    @Column (name= "idade")
    private int idade;

    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private dev.Java10x.CadastroDeNinjas.Missoes.MissoesModel missoes;

    @Column (name= "rank")
    private String rank;


}
