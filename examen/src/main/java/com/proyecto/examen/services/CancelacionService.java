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

    public Optional<HistorialReserva> realizarCancelacion(CancelacionDTO historial_reserva) throws CustomException {

            Optional<Usuario> usuarioExist = usuarioRepository.getUsuarioById(historial_reserva.getId_cliente());

            if (usuarioExist.isPresent()) {

                Optional<Reserva> reservaExist = reservaRepository.getReservaById(historial_reserva.getId_reserva());

                if (reservaExist.isPresent()) {

                    if (!LocalDateTime.now().isAfter(reservaExist.get().getFechaCheckin())) {

                        if(Objects.equals(reservaExist.get().getId_Usuario(), historial_reserva.getId_cliente())){

                            if(reservaExist.get().getId_Habitacion().contentEquals(historial_reserva.getId_habitacion())){

                                //Penalizacion
                                if(LocalDateTime.now().isAfter(reservaExist.get().getFechaCheckin().plusHours(-48))){
                                    reservaExist.get().setPrecio(reservaExist.get().getPrecio() + (reservaExist.get().getPrecio() * Float.parseFloat("0.20")));
                                }
                                    HistorialReserva historial = new HistorialReserva();
                                    historial.setId(historial_reserva.getId_reserva());
                                    historial.setMotivo(historial_reserva.getMotivo());

                                    reservaExist.get().setBorrado("cancelada");
                                    reservaRepository.save(reservaExist.get());

                                    historialReservaRepository.save(historial);

                                    return Optional.of(historial);

                            } else {

                                throw new CustomException("El habitacion de la reserva no coincide");
                            }

                        } else {

                            throw new CustomException("El usuario de la reserva no coincide");

                        }

                    } else {

                        throw new CustomException("La reserva solo se puede hacer antes de la fecha de checkin");

                    }

                } else {

                    throw new CustomException("El reserva con id " + historial_reserva.getId_reserva() + " no existe");

                }

            } else {

                throw new CustomException("El usuario no existe");

            }

    }
}
