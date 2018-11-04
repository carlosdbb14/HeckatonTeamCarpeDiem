/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author David
 */
public class Pedido {
    private int id_pedido;
    private int cantidad;
    private Date fecha;
    private int id_usuario;
    private int id_producto;

    public Pedido(int id_pedido, int cantidad, Date fecha, int id_usuario, int id_producto) {
        this.id_pedido = id_pedido;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.id_usuario = id_usuario;
        this.id_producto = id_producto;
    }

    public Pedido() {
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id_pedido=" + id_pedido + ", cantidad=" + cantidad + ", fecha=" + fecha + ", id_usuario=" + id_usuario + ", id_producto=" + id_producto + '}';
    }
    
    
    
}
