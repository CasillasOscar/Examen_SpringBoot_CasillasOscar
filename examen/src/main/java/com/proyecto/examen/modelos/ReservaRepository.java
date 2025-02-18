package com.proyecto.examen.modelos;


import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {


    Optional<Reserva> getReservaById(Integer id);

    Optional<Reserva> getReservaByIdHabitacionEqualsAndFechaCheckoutIsAfterAndBorradoNull(Habitacione habitacione, LocalDateTime fechaInicio);
    //Tenia que ser after y no before

}
