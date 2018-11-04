/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author David
 */
public class Producto {
    private int id_producto;
    private String producto;

    public Producto(int id_producto, String producto) {
        this.id_producto = id_producto;
        this.producto = producto;
    }

    public Producto() {
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Producto{" + "id_producto=" + id_producto + ", producto=" + producto + '}';
    }
    
    
    
}
