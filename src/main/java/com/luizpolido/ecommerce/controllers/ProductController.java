package com.luizpolido.ecommerce.controllers;

import com.luizpolido.ecommerce.dto.ProductDTO;
import com.luizpolido.ecommerce.entities.Product;
import com.luizpolido.ecommerce.repositories.ProductRepository;
import com.luizpolido.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = {"/{id}"})
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id){
        //Usar o construtor new ResponseEntitty<> para definir status HTTP extremamente especifico
        //Usar o metodo estatico ResponseEntity.ok (ou outros) para definir status HTTP de forma mais generica
        //return new ResponseEntity<>(productService.findById(id) , HttpStatus.OK); <- Exemplo
        ProductDTO dto = productService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAll (Pageable pageable){
        Page<ProductDTO> dto = productService.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO dto){
        dto = productService.insert(dto);
        //Cria uma URI esperada pelo metodo .created para especifiar no header da requisicao o caminho (URL) do recurso
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }
}
