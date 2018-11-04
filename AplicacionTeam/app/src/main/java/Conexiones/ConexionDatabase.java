/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author David
 */
public class ConexionDatabase {
     private static Connection cnx = null;
    
     public static Connection obtenerConexion(){
            
           
            
            try{
                Class.forName("com.mysql.jdbc.Driver");
                //Connecta con la base de datos no importa si utilizo wampserver o mierdas
                //Por que todo corre en el puerto 3306
                //Pero si utilizo wamp o xamp debo desabilitar el otro para que no ocupe el puerto de mysql

                cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurante?autoReconnect=true&useSSL=false","root","0000");

                System.out.println("Conexion Satisfactoria con la base de datos restaurante");    
           
            }catch(Exception E){
                System.out.println("Error de Conexion"+E);       

            }
            
            return cnx;
    
    }
     
     public static void cerrarConexion() throws SQLException{
         if(!cnx.isClosed()){
             cnx.close();
         }
     }
    
}
