package com.proyecto.examen.modelos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialReservaRepository extends JpaRepository<HistorialReserva, Integer> {
}
