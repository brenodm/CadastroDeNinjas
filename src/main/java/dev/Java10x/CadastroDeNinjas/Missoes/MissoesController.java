package dev.Java10x.CadastroDeNinjas.Missoes;

import dev.Java10x.CadastroDeNinjas.Ninjas.NinjaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //Criar novo Ninja
    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missao) {
        MissoesDTO novaMissao = missoesService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Nova missao foi criada: " + novaMissao.getNome() + ". zCom o id: " + novaMissao.getId());

    }

    //Mostrar todos os Ninjas
    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoes() {
        List<MissoesDTO> missoes = missoesService.listarMissao();
        return ResponseEntity.ok(missoes);
    }

    //Mostrar ninja por ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissaoPorId(@PathVariable Long id) {

        MissoesDTO ninja = missoesService.listarMissaoPorId(id);

        if (missoesService.listarMissaoPorId(id) != null){
            return ResponseEntity.status(HttpStatus.FOUND)
                    .body(missoesService.listarMissaoPorId(id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não existe nenhuma missao com o id: " + id + " no nosso sistema.");
        }
    }

    //Alterar Ninja
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissaoPorId(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada) {

        MissoesDTO missao = missoesService.alterarMissaoPorId(id, missaoAtualizada);

        if (missao != null){
            return ResponseEntity.ok(missao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não existe nenhuma missao com o id: " + id + " no nosso sistema.");
        }

    }

    //Deletar o Ninja
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissaoPorId(@PathVariable Long id) {

        if (missoesService.listarMissaoPorId(id) != null){
            missoesService.deletarMissaoPorId(id);
            return ResponseEntity.ok("Missao: " + id + " foi deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não existe nenhuma missoa com o id: " + id + " no nosso sistema.");
        }
    }

}
