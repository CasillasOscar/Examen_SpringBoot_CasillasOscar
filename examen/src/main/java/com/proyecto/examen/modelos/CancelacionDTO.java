package com.proyecto.examen.modelos;

public class CancelacionDTO {
    private Integer id_reserva;
    private String id_habitacion;
    private Integer id_cliente;
    private String motivo;

    public CancelacionDTO(Integer id_reserva, String id_habitacion, Integer id_cliente, String motivo) {
        this.id_reserva = id_reserva;
        this.id_habitacion = id_habitacion;
        this.id_cliente = id_cliente;
        this.motivo = motivo;
    }

    public Integer getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(Integer id_reserva) {
        this.id_reserva = id_reserva;
    }

    public String getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(String id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
