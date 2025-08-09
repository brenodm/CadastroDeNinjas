package dev.Java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private MissoesService missoesService;

    @PostMapping("/criar")
    public String criarMissoes() {
        return "Missao criado com sucesso";
    }

    @GetMapping("/listar")
    public String listarMissoes() {
        return "Missoes Cadastradas: ";
    }

    @PutMapping("/alterar")
    public String alterarMissoes() {
        return "Missão alterada com sucesso";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao() {
        return "Missão deletada com sucesso";
    }

}
