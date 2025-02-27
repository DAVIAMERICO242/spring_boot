package org.example.api.terceiros;

import org.example.api.injectable.ToBeInjected;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/terceiros")
public class TerceiroController {

    @Autowired
    private ToBeInjected injectable;

    @Autowired
    private TerceiroService terceiroService;

    @GetMapping
    public Object getTerceiros() {

        injectable.injectedHello();
        return terceiroService.listarTerceiros();
    }
    @PostMapping
    public ResponseEntity<TerceiroEntidade> create(@RequestBody TerceiroEntidade terceiro){
        return ResponseEntity.ok(terceiroService.createTerceiro(terceiro));
    }
    @PutMapping
    public ResponseEntity<TerceiroEntidade> update(@RequestBody TerceiroEntidade terceiro){
        if(terceiroService.checkExistenceById(terceiro.getCnpj_cpf())){
            return ResponseEntity.ok(terceiroService.updateTerceiro(terceiro));
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{cnpjCpf}")
    public ResponseEntity<Boolean> delete(@PathVariable String cnpjCpf){
        return ResponseEntity.ok(terceiroService.deleteTerceiro(cnpjCpf));
    }
}

