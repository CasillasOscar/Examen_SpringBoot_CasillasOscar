package com.proyecto.examen.services;

import com.proyecto.examen.exceptions.CustomException;
import com.proyecto.examen.modelos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class CancelacionService {

    @Autowired
    HistorialReservaRepository historialReservaRepository;
    @Autowired
    ReservaRepository reservaRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<HistorialReserva> realizarCancelacion(Reserva cancelacion, HistorialReserva historial_reserva) throws CustomException {

        if (Objects.equals(cancelacion.getId(), historial_reserva.getId())) {

            Optional<Usuario> usuarioExist = usuarioRepository.getUsuarioById(cancelacion.getIdUsuario().getId());

            if (usuarioExist.isPresent()) {

                Optional<Reserva> reservaExist = reservaRepository.getReservaById(cancelacion.getId());

                if (reservaExist.isPresent()) {

                    if (!LocalDateTime.now().isAfter(reservaExist.get().getFechaCheckin())) {

                        //Penalizacion
                        if(LocalDateTime.now().isAfter(reservaExist.get().getFechaCheckin().plusHours(-48))){
                            reservaExist.get().setPrecio(reservaExist.get().getPrecio() + (reservaExist.get().getPrecio() * Float.parseFloat("0.20")));
                        }


                        reservaExist.get().setBorrado("cancelada");
                        reservaRepository.save(reservaExist.get());

                        historialReservaRepository.save(historial_reserva);

                        return Optional.of(historial_reserva);


                    } else {

                        throw new CustomException("La reserva solo se puede hacer antes de la fecha de checkin");

                    }

                } else {

                    throw new CustomException("El reserva con id " + cancelacion.getId() + " no existe");

                }

            } else {

                throw new CustomException("El usuario no existe");

            }
        } else {

            throw new CustomException("Los id de cancelacion y reserva no son iguales");
        }
    }
}
