package dev.Java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

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
    public List<NinjaModel> listarNinjas() {
        return ninjaService.listarNinjas();
    }

    //Mostrar ninja por ID
    @GetMapping("/listarID")
    public String listarNinjaId() {
        return "Ninja encontrado por ID: ";
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
