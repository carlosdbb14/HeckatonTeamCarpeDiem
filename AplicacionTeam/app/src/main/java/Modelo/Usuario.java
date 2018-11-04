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
public class Usuario {
    private int id_usuario;
    private String nombre;
    private String tipoDOcumento;
    private int documento;
    private int codigo_empresa;
    private String contrasena;
    

    public Usuario() {
    }

    public Usuario(int id_usuario, String nombre, String tipoDocumento, int documento, int codigo_empresa, String contrasena) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.tipoDOcumento = tipoDOcumento;
        this.documento = documento;
        this.codigo_empresa = codigo_empresa;
        this.contrasena = contrasena;
    }
    
    

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getTipoDOcumento() {
        return tipoDOcumento;
    }

    public void setTipoDOcumento(String tipoDOcumento) {
        this.tipoDOcumento = tipoDOcumento;
    }

    public int getCodigo_empresa() {
        return codigo_empresa;
    }

    public void setCodigo_empresa(int codigo_empresa) {
        this.codigo_empresa = codigo_empresa;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", nombre=" + nombre + ", tipoDOcumento=" + tipoDOcumento + ", documento=" + documento + ", codigo_empresa=" + codigo_empresa + ", contrasena=" + contrasena + '}';
    }

    
    
    
}
