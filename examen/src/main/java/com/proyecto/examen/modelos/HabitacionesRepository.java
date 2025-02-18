package com.proyecto.examen.modelos;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HabitacionesRepository extends JpaRepository<Habitacione, String> {
    Optional<Habitacione> getHabitacioneByIdHabitacion(@Size(max = 10) @Pattern(regexp = "^[P][0-9]-[0-9]{2}-(I|D)$", message = "Debe tener la estructura especifica") String idHabitacion);
}
