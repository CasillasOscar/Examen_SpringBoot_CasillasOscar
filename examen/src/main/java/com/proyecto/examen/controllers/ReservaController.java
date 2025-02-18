package com.proyecto.examen.controllers;

import com.proyecto.examen.exceptions.CustomException;
import com.proyecto.examen.modelos.ReservaDTO;
import com.proyecto.examen.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reserva")
@CacheConfig(cacheNames = {"reserva"})
public class ReservaController {

    @Autowired
    ReservaService reservaService;

    @PostMapping("/{id_habitacion}")
    public ResponseEntity<?> hacerReserva(@PathVariable String id_habitacion, @RequestBody ReservaDTO reserva) throws CustomException {

        if(id_habitacion.contentEquals(reserva.getIdHabitacion())){

            return ResponseEntity.ok(reservaService.hacerReserva(reserva)); //Me faltaba un return

        } else {

            throw new CustomException("La habitación en la URI y la de la reserva no es la misma");

        }

    }

}
