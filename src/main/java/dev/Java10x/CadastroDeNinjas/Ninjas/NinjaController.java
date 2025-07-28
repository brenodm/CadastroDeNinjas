package dev.Java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    @GetMapping("/boasVindas")
    public String boasVinas() {
        return "Essa é a minha primeira mensagem";
    }

    //Criar novo Ninja
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado com sucesso.";
    }

    //Mostrar todos os Ninjas
    @GetMapping("/listar")
    public String mostraTodosOsNinjas() {
        return "Todos os Ninjas cadastrados:";
    }

    //Mostrar ninja por ID
    @GetMapping("/listarID")
    public String mostrarTodosOsNinjasPorId() {
        return "Ninja procurado por ID: ";
    }

    //Alterar Ninja
    @PutMapping("/alterarID")
    public String alterarNinjaPorId() {
        return "Ninja foi alterado";
    }

    //Deletar Ninja

    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId() {
        return "Ninja deletado com sucesso.";
    }

}
