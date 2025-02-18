package com.proyecto.examen.controllers;

import com.proyecto.examen.exceptions.CustomException;
import com.proyecto.examen.modelos.CancelacionDTO;
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
    public ResponseEntity<?> cancelar(
            @PathVariable String id_habitacion,
            @PathVariable Integer id_cliente,
            @Valid @RequestBody CancelacionDTO cancelacion) throws CustomException
    {
        if(
                id_habitacion.contentEquals(cancelacion.getId_habitacion()) &&
                        Objects.equals(id_cliente, cancelacion.getId_cliente()))
        {

            return ResponseEntity.ok(cancelacionService.realizarCancelacion(cancelacion));

        } else {

            throw new CustomException("La habitación o el clientre en la URI y la de la reserva no es la misma");

        }
        //return null; sobra y falta el return del responseEntity
    }
}
