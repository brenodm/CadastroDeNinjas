package dev.Java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    //Criar novo Ninja
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Novo ninja criado: " + novoNinja.getNome() + ". Com o id: " + novoNinja.getId());

    }

    //Mostrar todos os Ninjas
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {

        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //Mostrar ninja por ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjaPorId(@PathVariable Long id) {

        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);

        if (ninjaService.listarNinjaPorId(id) != null){
            return ResponseEntity.status(HttpStatus.FOUND)
                    .body(ninjaService.listarNinjaPorId(id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não existe nenhum ninja com o id: " + id + " no nosso sistema.");
        }
    }

    //Alterar Ninja
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {

        NinjaDTO ninja = ninjaService.alterarNinjaPorId(id, ninjaAtualizado);

        if (ninja != null){
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não existe nenhum ninja com o id: " + id + " no nosso sistema.");
        }

    }

    //Deletar o Ninja
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {

        if (ninjaService.listarNinjaPorId(id) != null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja: " + id + " foi deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não existe nenhum ninja com o id: " + id + " no nosso sistema.");
        }
    }

}
