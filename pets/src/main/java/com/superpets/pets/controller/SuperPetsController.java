package com.superpets.pets.controller;

import com.superpets.pets.services.PetsService;
import com.superpets.pets.shared.PetsDto;
import com.superpets.pets.shared.PetsListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/superpets")
public class SuperPetsController {
    @Autowired
    private PetsService service;

    //listar
    @GetMapping
    private ResponseEntity<List<PetsListDto>> listPets() {
        return new ResponseEntity<>(service.pegarTodos(), HttpStatus.OK);
    }

    //pegaId
    @GetMapping("/{id}")
    private ResponseEntity<PetsDto> getPetById(@PathVariable String id) {
        Optional<PetsDto> pet = service.obterPorID(id);

        if (pet.isPresent()) {
            return new ResponseEntity<>(pet.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Cadastrar
    @PostMapping
    private ResponseEntity<PetsDto> addPet(@RequestBody PetsDto pet) {
        return new ResponseEntity<>(service.cadastrar(pet), HttpStatus.CREATED);
    }

    //Atualizar
    @PutMapping("/{id}")
    private ResponseEntity<PetsDto> updatePet(@PathVariable String id, @RequestBody PetsDto pet) {
        PetsDto updatedPet = service.atualizarPorId(id, pet);

        if (updatedPet != null) {
            return new ResponseEntity<>(updatedPet, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deletePetById(@PathVariable String id) {
        service.deletarPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
