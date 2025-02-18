package com.proyecto.examen.controllers;

import com.proyecto.examen.exceptions.CustomException;
import com.proyecto.examen.modelos.HistorialReserva;
import com.proyecto.examen.modelos.Reserva;
import com.proyecto.examen.services.CancelacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/cancelacion")
@CacheConfig(cacheNames = {"cancelado"})
public class CancelacionController {

    @Autowired
    CancelacionService cancelacionService;

    @PostMapping("/{id_habitacion}/{id_cliente}")
    public ResponseEntity<?> cancelar(@PathVariable String id_habitacion, @PathVariable Integer id_cliente, @Valid @RequestBody Reserva cancelacion, @Valid @RequestBody HistorialReserva historial_reserva) throws CustomException {
        if(
                id_habitacion.contentEquals(cancelacion.getIdHabitacion().getIdHabitacion()) &&
                        Objects.equals(id_cliente, cancelacion.getIdHabitacion().getIdHabitacion()))
        {

            ResponseEntity.ok(cancelacionService.realizarCancelacion(cancelacion, historial_reserva));

        } else {

            throw new CustomException("La habitación o el clientre en la URI y la de la reserva no es la misma");

        }
        return null;
    }
}
