/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Database.*;
import java.sql.SQLException;
import Modelo.*;
/**
 *
 * @author David
 */
public class Facade {
    private Usuario user;
    private static Facade facade=null;
    
    public static Facade UnicaInstancia(){
        if(facade==null) facade = new Facade();
        
        return facade;
    }
    
    
    public Usuario ingresar(int documento, String contrasena) throws SQLException{
        UsuarioDB udb= new UsuarioDB();
        user= udb.ingresar(documento, contrasena);
        return user;
    }
    
    public Usuario Registrar(String nombre, String tipoDocumento, int documento, int codigo_empresa, String contrasena) throws SQLException{
        UsuarioDB udb = new UsuarioDB();
        udb.registrar(nombre, tipoDocumento, documento, codigo_empresa, contrasena);
        return udb.ingresar(documento, contrasena);
    }
    
    
}
    
    
