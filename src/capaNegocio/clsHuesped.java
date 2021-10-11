/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaNegocio;

import capaDatos.clsJBDCConection;
import java.sql.*;

/**
 *
 * @author NUEVO
 */
public class clsHuesped {
     clsJBDCConection objConectar = new clsJBDCConection();
    String strSQL;
    ResultSet rs = null;
    public Integer generarNumHuesp() throws Exception{
        strSQL="select coalesce(max(codhuesped),0)+1 as codigo from huesped";

        try{
            rs=objConectar.consultarBD(strSQL);
            if(rs.next()){
                return rs.getInt("codigo");
            }
        }catch (Exception e){
        throw new Exception("Error al generar codigo huesped");
        }
        return 0;
    }
    public ResultSet listar() throws Exception {
        strSQL = "select * from huesped";
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
     public void darBajaHues(String docum, String tipoDoc) throws Exception{
        strSQL="update huesped set estado=false where numdocumento ='"+docum+"'and tipodocumento='"+tipoDoc+"'";
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
     
     public void eliminarHues(String docum, String tipoDoc) throws Exception {
        strSQL = "delete from huesped where numdocumento ='"+docum+"'and tipodocumento='"+tipoDoc+"'";
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
     public ResultSet buscarHuesped(String docum, String tipoDoc) throws Exception{
        strSQL="select * from huesped where numdocumento ='"+docum+"'and tipodocumento='"+tipoDoc+"'";
        try {
            rs=objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
     
     public void registrarHuesp(Integer cod, String numDoc, String tipodoc,String nombres, String apellidos, String fechaNac,Boolean sexo, String direccion, String ciudad, String pais, String tel, String correo, Boolean est ) throws Exception{
        strSQL="insert into huesped values("+cod+", '"+numDoc+"','"+tipodoc+"','"+nombres+"','"+apellidos+"','"+fechaNac+"',"+sexo+",'"+direccion+"','"+ciudad+"','"+pais+"','"+tel+"','"+correo+"',"+est+")";
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar Huesped!");
        }
    }
     
      public void modificar(String numDoc, String tipodoc,String nombres, String apellidos, String fechaNac,Boolean sexo, String direccion, String ciudad, String pais, String tel, String correo, Boolean est) throws Exception {
        strSQL = "update huesped set nombres='"+ nombres +"', apellidos='"+apellidos+"',direccion='"+direccion+"',telefono = '"+tel+"',correo = '"+correo+"',pais ='"+pais+"',ciudad='"+ciudad+"', fechanac='"+fechaNac+"', sexo= "+sexo+", estado = "+est+" where numdocumento ='"+numDoc+"'and tipodocumento='"+tipodoc+"'";
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    //
     public ResultSet buscarHuesped(String numDoc) throws Exception{
        strSQL="select * from huesped where numdocumento ='"+numDoc+"'";
        try {
            rs=objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } 
     }
}
