
package capaNegocio;

/**
 *
 * @author NUEVO
 */
import capaDatos.clsJBDCConection;
import java.sql.*;
public class clsHabitacion {
    clsJBDCConection objConexion=new clsJBDCConection();
    String strSQL;
    ResultSet rs=null; 
    
    public ResultSet listarHabitacion() throws Exception{
        strSQL="select H.*,TH.nombre as nombreTH from habitacion H inner join tipo_habitacion TH on H.codtipohabitacion=TH.codtipohabitacion";
        try {
            rs=objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar Habitación!");
        }
    }
    
     public Integer generarCodigoHAB() throws Exception{
        strSQL="select coalesce(max(codhabitacion),0)+1 as codigo from habitacion";
        try {
            rs=objConexion.consultarBD(strSQL);
            if(rs.next()){
                return rs.getInt("codigo");
            }
        } catch (Exception e) {
            throw new Exception("Errror al generar el codigo de habitacion.");
        }
        return 0;
    }
     
    public Boolean verificarNumHabitacion(Integer num) throws Exception{
        strSQL="select * from habitacion where numero=" + num;
        try {
            rs=objConexion.consultarBD(strSQL);
            if(rs.next()){
                return false;
            }else{
                return true;
            }
        } catch (Exception e) {
            throw new Exception("Error al verificar número de Habitación!");
        }
    }
    
    public void registrarHab(Integer cod, Integer num, String nom, String des,String est, Integer cap, Integer codTH) throws Exception{
        strSQL="insert into habitacion values(" + cod + "," + num + ",'" + nom + "','" + des + "','" + est + "'," + cap + "," + codTH + ")";
        try {
            objConexion.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar Habitación!");
        }
    }
    
    public ResultSet buscarHab(Integer num) throws Exception{
        strSQL="select H.*,TH.nombre as nombreTH from habitacion H inner join tipo_habitacion TH on H.codtipohabitacion=TH.codtipohabitacion where numero=" + num;
        try {
            rs=objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar Habitación!");
        }
    }
    
    public void modificarHab(Integer cod, String nom, String des,String est, Integer cap, Integer codTH) throws Exception{
        strSQL="update habitacion set nombre='" + nom + "',descripcion='" + des + "',estado='" + est + "',capacidad=" + cap + ",codTipoHabitacion=" + codTH + " where codHabitacion=" + cod;
        try {
            objConexion.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar Habitación!");
        }
    }
    
    public Boolean verificarDisponibilidad(Integer cod) throws Exception{
        strSQL="select * from habitacion where codHabitacion=" + cod + " and estado='O'";
        try {
            rs=objConexion.consultarBD(strSQL);
            if(rs.next()){
                return false;
            }else{
                return true;
            }
        } catch (Exception e) {
            throw new Exception("Error al verificar disponibilidad de Habitación!");
        }
    }
    
    public void eliminarHab(Integer cod) throws Exception{
        strSQL="delete from habitacion where codHabitacion=" + cod;
        try {
            objConexion.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al eliminar Habitación!");
        }
    }
    
    public void darBajaHab(Integer cod) throws Exception{
        strSQL="update habitacion set estado='M' where codHabitacion=" + cod;
        try {
            objConexion.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al eliminar Habitación!");
        }
    }
//Modifciado 30

 public ResultSet listarHabitacionDisp(String tipoHab) throws Exception{
        strSQL="select H.* from habitacion H inner join tipo_habitacion TH on H.codTipoHabitacion = TH.codTipoHabitacion where TH.nombre='" + tipoHab + "' and estado='D'";
        try {
            rs=objConexion.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar Habitación!");
        }
    }
 
 public Double obtenerCostoHab(Integer numHab) throws Exception{
     strSQL="select TH.costo from habitacion H inner join tipo_habitacion TH on H.codTipoHabitacion=TH.codTipoHabitacion where numero="+numHab ;
     try {
            rs=objConexion.consultarBD(strSQL);
            if(rs.next()){
                return rs.getDouble("costo");
            }
        } catch (Exception e) {
            throw new Exception("Error al listar Habitación!");
        }
     return 0.0;
 }

}
