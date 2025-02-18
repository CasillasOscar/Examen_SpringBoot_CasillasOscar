package com.proyecto.examen.services;

import com.proyecto.examen.exceptions.CustomException;
import com.proyecto.examen.modelos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    ReservaRepository reservaRepository;
    @Autowired
    private HabitacionesRepository habitacionesRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<Reserva> hacerReserva(ReservaDTO reserva) throws CustomException {

        if(reserva.getFecha_inicio().isBefore(LocalDateTime.now())){

            throw new CustomException("Solo se puede reservar para fecha de hoy o fechas a futuro");

        } else {

            Optional<Habitacione> habitacionExist = habitacionesRepository.getHabitacioneByIdHabitacion(reserva.getIdHabitacion());

            if(habitacionExist.isPresent()){

                Optional<Usuario> usuarioExist = usuarioRepository.getUsuarioById(reserva.getId_usuario());

                if(usuarioExist.isPresent()){
                    //Comprobamos si hay una reserva con checkout antes al checkin que queremos
                    Optional<Reserva> reservaExist = reservaRepository.getReservaById_HabitacionEqualsAndFechaCheckoutIsBeforeAndBorradoNull(reserva.getIdHabitacion(),reserva.getFecha_inicio());

                    if(reservaExist.isPresent()){

                        Reserva reservaPersist = new Reserva();
                        reservaPersist.setIdHabitacion(habitacionExist.get());
                        reservaPersist.setIdUsuario(usuarioExist.get());
                        reservaPersist.setFechaCheckin(reserva.getFecha_inicio());
                        reservaPersist.setFechaCheckout(reserva.getFecha_fin());
                        reservaPersist.setPrecio(Float.parseFloat("100.54"));

                        reservaRepository.save(reservaPersist);

                        return Optional.of(reservaPersist);


                    } else {
                        throw new CustomException("La habitacion ya esta reservada en esa fecha");
                    }

                } else {
                    throw new CustomException("El usuario con id " + reserva.getId_usuario() + " no existe");
                }

            } else {
                throw new CustomException("La habitacion " + reserva.getIdHabitacion() + " no existe");
            }
        }
    }

}
