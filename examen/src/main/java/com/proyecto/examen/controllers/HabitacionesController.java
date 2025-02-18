package com.proyecto.examen.controllers;

import com.proyecto.examen.exceptions.CustomException;
import com.proyecto.examen.modelos.Habitacione;
import com.proyecto.examen.services.HabitacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habitaciones")
@CacheConfig(cacheNames = {"habitacion"})
public class HabitacionesController {

    @Autowired
    HabitacionService habitacionService;

    @PostMapping
    public ResponseEntity<?> addHabitacion(@Valid @RequestBody Habitacione habitacion) throws CustomException {

        return ResponseEntity.ok(habitacionService.addHabitacion(habitacion));
    }
}
