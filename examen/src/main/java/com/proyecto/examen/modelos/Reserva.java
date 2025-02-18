package com.proyecto.examen.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservas")
//@JsonIgnoreProperties({"idHabitacion", "idusuario"})
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_habitacion", nullable = false)
    private Habitacione idHabitacion;

//    @JsonProperty("Id_Habitacion")
//    public String getId_Habitacion(){
//        return idHabitacion != null ? idHabitacion.getIdHabitacion() : null;
//    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private com.proyecto.examen.modelos.Usuario idUsuario;

//    @JsonProperty("id_usuario")
//    public Integer getId_Usuario(){
//        return idUsuario != null ? idUsuario.getId() : null;
//    }

    @NotNull
    @Column(name = "fecha_checkin", nullable = false)
    private LocalDateTime fechaCheckin;

    @NotNull
    @Column(name = "fecha_checkout", nullable = false)
    private LocalDateTime fechaCheckout;

    @Size(max = 20)
    @Column(name = "borrado", length = 20)
    private String borrado;

    @Column(name = "precio")
    private Float precio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Habitacione getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Habitacione idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public com.proyecto.examen.modelos.Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(com.proyecto.examen.modelos.Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDateTime getFechaCheckin() {
        return fechaCheckin;
    }

    public void setFechaCheckin(LocalDateTime fechaCheckin) {
        this.fechaCheckin = fechaCheckin;
    }

    public LocalDateTime getFechaCheckout() {
        return fechaCheckout;
    }

    public void setFechaCheckout(LocalDateTime fechaCheckout) {
        this.fechaCheckout = fechaCheckout;
    }

    public String getBorrado() {
        return borrado;
    }

    public void setBorrado(String borrado) {
        this.borrado = borrado;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

}