package com.estoque.controller;

import com.estoque.model.Product;
import com.estoque.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public List<Product> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Product criar(@RequestBody Product produto) {
        return repository.save(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> atualizar(@PathVariable Long id, @RequestBody Product dadosAtualizados) {
        return repository.findById(id)
                .map(produto -> {
                    produto.setNome(dadosAtualizados.getNome());
                    produto.setQuantidade(dadosAtualizados.getQuantidade());
                    produto.setPreco(dadosAtualizados.getPreco());
                    Product atualizado = repository.save(produto);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
