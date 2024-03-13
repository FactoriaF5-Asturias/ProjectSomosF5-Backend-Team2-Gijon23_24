package org.teamraccoon.dreamfusion.products;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teamraccoon.dreamfusion.generics.IGenericFullService;
import org.teamraccoon.dreamfusion.messages.Message;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "${api-endpoint}/products")
public class ProductController {

    IGenericFullService<Product, ProductDTO> service;

    @GetMapping(path = "")
    public List<Product> index() {

        List<Product> products = service.getAll();

        return products;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") @NonNull Long id) throws Exception {

        Product ticket = service.getById(id);

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(ticket);
    }

    @GetMapping(path = "getByName/{name}")
    public ResponseEntity<Product> findById(@PathVariable("name") @NonNull String name) throws Exception {

        Product ticket = service.getByName(name);

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(ticket);
    }

    @PostMapping(path = "")
    public ResponseEntity<Product> create(@RequestBody ProductDTO ticket) {

        Product newProduct = service.save(ticket);

        return ResponseEntity.status(201).body(newProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") @NonNull Long id, @RequestBody ProductDTO ticket) throws Exception {

        Product updatedProduct = service.update(id, ticket);

        return ResponseEntity.status(200).body(updatedProduct);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Message> remove(@PathVariable("id") @NonNull Long id) throws Exception { 

        Message delete = service.delete(id);

        return ResponseEntity.status(200).body(delete);
    }

}