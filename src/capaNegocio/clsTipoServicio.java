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
 * @author emily 22-9
 */
public class clsTipoServicio {
    clsJBDCConection objConexion= new clsJBDCConection();
    String strSQL;
    Statement sent;
    ResultSet rs=null;
    
      public Integer generarCodigoTH() throws Exception{
        strSQL="select coalesce(max(codtiposer),0)+1 as codigo from tipo_servicio";
        try {
            rs=objConexion.consultarBD(strSQL);
            if(rs.next()){
                return rs.getInt("codigo");
            }
        } catch (Exception e) {
            throw new Exception("Errror al generar el codigo de tipo de servicio.");
        }
        return 0;
    }
      
    public void registrarTS(Integer cod, String nom,Double cos, Boolean vig ) throws Exception{
        strSQL="insert into tipo_servicio values("+cod+",'"+nom+"',"+cos+","+vig+")";
        try {
            objConexion.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar Tipo de Servicio");
        }
    
    }
    
      public void modificarTS(Integer cod, String nom,Double cos, Boolean vig ) throws Exception{
        strSQL="update tipo_servicio set nombre='"+nom+" ',costobase="+cos+" ,vigencia="+vig+"  where codtiposer="+cod;
        try {
            objConexion.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al modificar Tipo Servicio");
        }
    }
      
      public void eliminarTS(Integer cod) throws Exception{
        strSQL="delete from tipo_servicio where codtiposer=" + cod;
        try {
            objConexion.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al eliminar Tipo de Servicio");
        }
    }
    
    public void darBajaTS(Integer cod) throws Exception{
        strSQL="update tipo_servicio set vigencia=false where codtiposer=" + cod;
        try {
            objConexion.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al dar de baja Tipo de Servicio");
        }
    }
    
      public ResultSet listarTS() throws Exception{
        strSQL="select * from tipo_servicio";
        try {
            rs=objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar Tipo de Servicio");
        }
    }
    
    public ResultSet buscarTS(Integer cod) throws Exception{
        strSQL="select * from tipo_servicio where codtiposer=" + cod;
        try {
            rs=objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al encontrar Tipo de Servicio");
        }
    }
    
    
}
