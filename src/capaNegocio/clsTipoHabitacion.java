/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaNegocio;

/**
 *
 * @author emily 21-9
 */

import capaDatos.clsJBDCConection;
import java.sql.*;
public class clsTipoHabitacion {
     clsJBDCConection objConexion=new clsJBDCConection();
    String strSQL;
    ResultSet rs=null;
    
    public Integer generarCodigoTH() throws Exception{
        strSQL="select coalesce(max(codTipoHabitacion),0)+1 as codigo from tipo_habitacion";
        try {
            rs=objConexion.consultarBD(strSQL);
            if(rs.next()){
                return rs.getInt("codigo");
            }
        } catch (Exception e) {
            throw new Exception("Error al generar código de Tipo Habitación!");
        }
        return 0;
    }
    
    public void registrarTH(Integer cod, String nom, String des, Boolean vig, Double cos) throws Exception{
        strSQL="insert into tipo_habitacion values(" + cod + ",'" + nom + "','" + des + "'," + vig + "," + cos + ")";
        try {
            objConexion.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar Tipo Habitación!");
        }
    
    }
    
    public void modificarTH(Integer cod, String nom, String des, Boolean vig, Double cos) throws Exception{
        strSQL="update tipo_habitacion set nombre='" + nom + "',descripcion='" + des + "',vigencia=" + vig + ",costo=" + cos + " where codTipoHabitacion=" + cod;
        try {
            objConexion.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al modificar Tipo Habitación!");
        }
    }
    
    public void eliminarTH(Integer cod) throws Exception{
        strSQL="delete from tipo_habitacion where codTipoHabitacion=" + cod;
        try {
            objConexion.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al eliminar Tipo Habitación!");
        }
    }
    
    public void darBajaTH(Integer cod) throws Exception{
        strSQL="update tipo_habitacion set vigencia=false where codTipoHabitacion=" + cod;
        try {
            objConexion.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al dar de baja Tipo Habitación!");
        }
    }
    
    public ResultSet listarTH() throws Exception{
        strSQL="select * from tipo_habitacion";
        try {
            rs=objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar Tipo Habitación!");
        }
    }
    
    public ResultSet buscarTH(Integer cod) throws Exception{
        strSQL="select * from tipo_habitacion where codTipoHabitacion=" + cod;
        try {
            rs=objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar Tipo Habitación!");
        }
    }
    
    public ResultSet listarTHVigente() throws Exception{
        strSQL="select * from tipo_habitacion where vigencia=true order by nombre";
        try {
            rs=objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar Tipo Habitación!");
        }
    }
    
    public Integer obtenerCodigoTH(String nom) throws Exception{
        strSQL="select codtipohabitacion from tipo_habitacion where nombre='" + nom + "'";
        try {
            rs=objConexion.consultarBD(strSQL);
            if(rs.next()){
                return rs.getInt("codtipohabitacion");
            }
        } catch (Exception e) {
            throw new Exception("Error al obtener el código de Tipo Habitación!");
        }
        return 0;
    }
}
