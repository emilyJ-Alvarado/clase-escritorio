/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaNegocio;

import capaDatos.clsJBDCConection;
import java.sql.ResultSet;


/**
 *
 * @author NUEVO
 */
public class clsEmpleado {
    clsJBDCConection objConectar = new clsJBDCConection();
    String strSQL;
    ResultSet rs = null;
    
    
    
    public ResultSet listar() throws Exception {
        strSQL = "select * from empleado";
        try {
            rs = objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public ResultSet buscarEmpleadoDni(String dni) throws Exception{
        strSQL="select * from empleado where dniempleado = '" +dni+"'";
        try {
            rs=objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
   
 
    public void modificar(String dni,String nombre ,String apellido, String direccion, String telefono,String correo, String fechanac, Boolean sexo, Boolean vigencia) throws Exception {
        strSQL = "update empleado set nombres='"+ nombre +"', apellidos='"+apellido+"',direccion='"+direccion+"',telefono = '"+telefono+"',correo = '"+correo+"', fechanac='"+fechanac+"', sexo= "+sexo+", vigencia = "+vigencia+" where dniempleado='"+dni+"'";
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    
    
    public void registrarEmpleado(String dni,String nombre ,String apellido, String direccion, String telefono,String correo, String fechanac, Boolean sexo, Boolean vigencia) throws Exception {
        strSQL = "insert into empleado values('"+dni+"','"+nombre+"','"+apellido+"','"+direccion+"','"+telefono+"','"+correo+"','"+fechanac+"',"+sexo+","+vigencia+")";
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public void eliminar(String id) throws Exception {
        strSQL = "delete from empleado where dniempleado='" + id+"'" ;
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public Boolean validarEstado(Integer cod) throws Exception{
        strSQL = "select * from habitacion where codhabitacion=" + cod + " and estado='O'";
        try {
            rs= objConectar.consultarBD(strSQL);
            if(rs.next()){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public void darBajaEm(String dni) throws Exception{
        strSQL="update empleado set vigencia=false where dniempleado='"+dni+"'";
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
public ResultSet listarEmpeladosVig() throws Exception{
        strSQL="select * from empleado where vigencia=true";
        try {
            rs=objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar Empleados!");
        }
    }
}
