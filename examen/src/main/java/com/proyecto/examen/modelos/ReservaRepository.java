package com.proyecto.examen.modelos;


import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {


    Optional<Reserva> getReservaById(Integer id);

    //Falla porque no puede crear la consulta, el problema que da con el id porque estan todos los bean correctos
    Optional<Reserva> getReservaByIdHabitacionEqualsAndFechaCheckoutIsBeforeAndBorradoNull(@NotNull Habitacione idHabitacion, @NotNull LocalDateTime fechaCheckout);

}
