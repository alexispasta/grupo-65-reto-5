/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto5.empleadosDAL;

import java.sql.*;
/**
 *
 * @author alexis
 */
public class conexion {
    String strConexionDB="jdbc:sqlite:C:/Users/alexis/Desktop/reto5/ProyectosConstruccion.db";
    Connection conn=null;
    public conexion(){
        try{
            Class.forName("org.sqlite.JDBC");
            conn=DriverManager.getConnection(strConexionDB);
            System.out.println("conexion establecida");
        }
        catch(Exception e){
            System.out.println("error de conexion"+e);
                
        }
    }
    public int ejecutarSentenciaSQL(String strSentenciaSQL){
        try{
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            pstm.execute();
            return 1;
        }
        catch(Exception e){
            System.out.println(e);
            return 0;
        }
    }
    public ResultSet consultarRegistros(String strSentenciaSQL){
        try{
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}

