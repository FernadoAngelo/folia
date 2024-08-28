package br.edu.unicesumar.folia.controller.banco;

import br.edu.unicesumar.folia.domain.banco.Banco;
import br.edu.unicesumar.folia.domain.banco.BancoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("banco")
public class BancoRestController {


    private final BancoService bancoService;

    public BancoRestController(BancoService bancoService) {
        this.bancoService = bancoService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid Banco banco){
        bancoService.salvaBanco(banco);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deletar(@PathVariable UUID uuid){
        bancoService.deletarBanco(uuid);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<Banco> atualizar(@PathVariable UUID uuid, @RequestBody Banco banco){
        bancoService.atualizaBanco(uuid, banco);
        return new ResponseEntity<>(banco, HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Banco> visualizarPorId(@PathVariable UUID uuid){
        Banco response = bancoService.encontrarPorIdBanco(uuid);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Banco>> visualizar(){
        List<Banco> response = bancoService.encontrarTodos();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
