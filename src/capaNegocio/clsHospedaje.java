
package capaNegocio;

/**
 *
 * @author NUEVO 5-10
 */
import capaDatos.*;
import java.sql.*;
public class clsHospedaje {
    clsJBDCConection objConectar=new clsJBDCConection();
    String strSQL="";
    ResultSet rs=null;
    public Integer generarNumHospedaje() throws Exception{
        strSQL="select COALESCE(max(numhospedaje),0)+1 as numero from hospedaje";
        try {
            rs=objConectar.consultarBD(strSQL);
            if(rs.next()){
                return rs.getInt("numero");
            }
        } catch (Exception e) {
            throw new Exception("Error al generar el número de hospedaje!");
        }
        return 0;
    }
    
     public void registrarHospedaje(Integer num, String fecIni, String fecFin,String mot, Double cos, Integer codHue, String dniEmp,Integer codHab,String obs) throws Exception{
        strSQL="insert into hospedaje values(" + num + ",'" + fecIni + "','" + fecFin + "','" + mot + "'," + cos + ",true,false," + codHue + ",'" + dniEmp + "'," + codHab + ",'" + obs + "')";
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al registrar hospedaje");
        }
    }
    
     public ResultSet listarHospedaje() throws Exception{
        strSQL="select H.*, HU.nombres || ' ' || HU.apellidos as huesped, E.nombres || ' ' || E.apellidos as empleado, HA.numero as numHab from hospedaje H inner join huesped HU on H.codhuesped=HU.codhuesped inner join empleado E on H.dniempleado=E.dniempleado inner join habitacion HA on H.codhabitacion=HA.codhabitacion";
        try {
            rs=objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al listar Habitación!");
        }
    }
     
     public ResultSet buscarHos(Integer cod) throws Exception{
        strSQL="select H.*, HU.nombres as nombres , HU.apellidos as apellidos,HU.numdocumento as doc,\n" +
"HA.numero as numH, th.nombre as tipo, E.dniempleado\n" +
"from hospedaje H inner join huesped HU on H.codhuesped=HU.codhuesped \n" +
"inner join empleado E on H.dniempleado=E.dniempleado \n" +
"inner join habitacion HA on H.codhabitacion=HA.codhabitacion \n" +
"inner join tipo_habitacion TH on TH.codtipohabitacion=HA.codtipohabitacion  where H.numHospedaje="+cod;
        try {
            rs=objConectar.consultarBD(strSQL);
            return rs;
        } catch (Exception e) {
            throw new Exception("Error al buscar hospedaje!");
        }
    }
     
     public void eliminarHos(Integer cod) throws Exception{
        strSQL="delete from hospedaje where numHospedaje=" + cod;
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al eliminar Hospedaje!");
        }
    }
     
      public void modificarHos(Integer num, String fecIni, String fecFin,String mot,  String dniEmp,String obs) throws Exception{
        strSQL="update hospedaje set fechainicio='" + fecIni + "',fechafin='" + fecFin + "',motivo='" + mot + "', dniempleado='"+dniEmp+"', observacion='"+obs+"'where numHospedaje="+num;
        try {
            objConectar.ejecutarBD(strSQL);
        } catch (Exception e) {
            throw new Exception("Error al modificar hospedaje!");
        }
    }
}
