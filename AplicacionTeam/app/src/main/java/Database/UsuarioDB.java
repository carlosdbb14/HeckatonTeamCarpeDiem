/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Conexiones.ConexionDatabase;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Modelo.*;
/**
 *
 * @author David
 */
public class UsuarioDB {
    private Usuario usuario;
    
    public Usuario ingresar(int documento, String contrasena) throws SQLException{
        Usuario user = null;
        CallableStatement  cl = ConexionDatabase.obtenerConexion().prepareCall("{call SP_INGRESAR(?,?)}");
	cl.setInt(1, documento);
        cl.setString(2,contrasena);
		
	ResultSet rs = cl.executeQuery();
        if(rs.next()){
            user = new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getString(6));
        }
        return user;
    }
    
    public boolean registrar(String nombre, String tipoDocumento, int documento, int codigo_empresa, String contrasena) throws SQLException{
        CallableStatement cl = ConexionDatabase.obtenerConexion().prepareCall("{call SP_REGISTRAR(?,?,?,?,?)}");
        cl.setString(1, nombre);
        cl.setString(2, tipoDocumento);
        cl.setInt(3, documento);
        cl.setInt(4, codigo_empresa);
        cl.setString(5, contrasena);
        
        int r = cl.executeUpdate();
        
        if(r== 1) return true;
        else if(r==0) return false;
        else return false;
    }
}
