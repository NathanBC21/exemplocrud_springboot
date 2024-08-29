package br.edu.famper.exemplo1.controller;

import br.edu.famper.exemplo1.model.Produto;
import br.edu.famper.exemplo1.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(produtoService.findAll());
    }

    //Método para buscar um produto e retornará um HtppStatus Ok
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(produtoService.findById(id));
    }

    //@RequestBody pega os campos do arquivo json e ligar com os campos do referentes no objeto
    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(produtoService.salvar(produto));
    }

    //update
    @PutMapping
    public ResponseEntity<Produto> update(@RequestBody Produto  produto){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(produtoService.update(produto));
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        produtoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
