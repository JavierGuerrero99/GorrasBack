package com.example.gorrasapi.controller;

import com.example.gorrasapi.model.Gorra;
import com.example.gorrasapi.repository.GorraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/gorras")
public class GorraController {

    @Autowired
    private GorraRepository gorraRepository;

    // Endpoint para listar todas las gorras
    @GetMapping("/")
    public List<Gorra> listarGorras() {
        return gorraRepository.findAll();
    }

    // Endpoint para obtener una gorra por su ID
    @GetMapping("/{id}")
    public Optional<Gorra> obtenerGorraPorId(@PathVariable Long id) {
        return gorraRepository.findById(id);
    }

    @PostMapping("/")
    public Gorra crearGorra(@RequestBody Gorra gorra) {
        return gorraRepository.save(gorra);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gorra> editarGorra(@PathVariable Long id, @RequestBody Gorra gorraDetalles) {
        Optional<Gorra> gorraOptional = gorraRepository.findById(id);
        if (!gorraOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Gorra gorraExistente = gorraOptional.get();
        gorraExistente.setNombre(gorraDetalles.getNombre());
        gorraExistente.setColor(gorraDetalles.getColor());
        gorraExistente.setPrecio(gorraDetalles.getPrecio());
        gorraExistente.setCantidad(gorraDetalles.getCantidad());
        gorraExistente.setImagenUrl(gorraDetalles.getImagenUrl());

        Gorra gorraActualizada = gorraRepository.save(gorraExistente);
        return new ResponseEntity<>(gorraActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void eliminarGorra(@PathVariable Long id) {
        gorraRepository.deleteById(id);
    }

}
