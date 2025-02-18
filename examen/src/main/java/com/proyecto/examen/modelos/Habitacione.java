package com.proyecto.examen.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "habitaciones")
public class Habitacione {
    @Id
    @Size(max = 10)
    @Column(name = "id_habitacion", nullable = false, length = 10)
    @Pattern(regexp = "^[P][0-9]{1}-[0-9]{2}-(I|D)$", message = "Debe tener la estructura especifica")
    private String idHabitacion;

    @Size(max = 50)
    @Column(name = "tipo", length = 50)
    @Pattern(regexp = "^\\w$", message = "Solo acepta alfanumericos")
    private String tipo;

    @Column(name = "planta")
    @Pattern(regexp = "^[0-9]$",message = "Solo puede ser un numero de un digito")
    private Integer planta;

    @Column(name = "numero")
    private Integer numero;

    @Size(max = 1)
    @Column(name = "ubicacion", length = 1)
    @Pattern(regexp = "^(I|D)$",message = "Solo puede ser un I o D")
    private String ubicacion;

    public String getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getPlanta() {
        return planta;
    }

    public void setPlanta(Integer planta) {
        this.planta = planta;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

}