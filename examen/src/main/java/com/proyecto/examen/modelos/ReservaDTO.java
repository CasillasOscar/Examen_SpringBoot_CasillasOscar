package com.proyecto.examen.modelos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReservaDTO {
    private String idHabitacion;
    private LocalDateTime fecha_inicio;
    private LocalDateTime fecha_fin;
    private Integer id_usuario;

    public ReservaDTO(String idHabitacion, LocalDateTime fecha_fin, LocalDateTime fecha_inicio, Integer id_usuario) {
        this.idHabitacion = idHabitacion;
        this.fecha_fin = fecha_fin;
        this.fecha_inicio = fecha_inicio;
        this.id_usuario = id_usuario;
    }

    public String getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public LocalDateTime getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDateTime fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDateTime getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDateTime fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }
}
