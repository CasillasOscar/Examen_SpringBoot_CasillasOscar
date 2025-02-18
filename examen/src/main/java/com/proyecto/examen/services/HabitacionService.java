package com.proyecto.examen.services;

import com.proyecto.examen.exceptions.CustomException;
import com.proyecto.examen.modelos.Habitacione;
import com.proyecto.examen.modelos.HabitacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HabitacionService {

    @Autowired
    HabitacionesRepository habitacionesRepository;

    public Optional<Habitacione> addHabitacion(Habitacione habitacion) throws CustomException {

        Optional<Habitacione> habitacionExist = habitacionesRepository.getHabitacioneByIdHabitacion(habitacion.getIdHabitacion());

        if(habitacionExist.isEmpty()){

            habitacionesRepository.save(habitacion);
            return Optional.of(habitacion);

        } else {
            throw new CustomException("El id de esta habitación ya existe, no se ha podido crear");
        }

    }

}
