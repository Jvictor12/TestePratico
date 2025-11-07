package io.github.jvictor12.TestePratico.controller;

import io.github.jvictor12.TestePratico.service.PhotosService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/photos")
public class PhotosController {

    private final PhotosService service;

    //Requisitar para a The Cat API e salvar todos os retornos
    @PostMapping("/fetch")
    public ResponseEntity fetchAndSave(@RequestParam(defaultValue = "3") int limit) {
        return ResponseEntity.status(HttpStatus.OK).body(service.fetchAndSave(limit));
    }

    //Buscar todos os dados cadastrados no banco.
    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    //Buscar "photo" por ID
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
    }
}
