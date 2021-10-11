
package capaNegocio;

import capaDatos.clsJBDCConection;
import java.sql.*;
import javax.print.DocFlavor;
import javax.swing.JOptionPane;

/**
 *
 * @author Emily, 02/09/21
 */
public class clsUsuario {
    clsJBDCConection objConectar=new clsJBDCConection();
    String strSQL="";
    ResultSet rs=null;
  
    
    //Metodp de inicio de sesion
    public String inicioSesion(String usu, String con) throws Exception{
        strSQL="select nombrescompleto from usuario where nomusu='"+usu+ "' and con='"+con+"'";
        try {
            rs=objConectar.consultarBD(strSQL);
            if(rs.next()){
                return rs.getString("nombresCompleto");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return "";
    }
    
    //validacion de vigencia de usuario
    public boolean validarVigencia(String usu) throws Exception{
        strSQL="select estado from usuario where nomusu='"+usu+"'";
        try {
            rs=objConectar.consultarBD(strSQL);
            if(rs.next()){
                return rs.getBoolean("estado");
            }
        } catch (Exception e) {
              throw new Exception(e.getMessage());
        }
        return false;
    }
    
    public String preguntaSecreta(String usu) throws Exception{
       strSQL="select pregunta from usuario where nomusu='"+usu+"'";
        try {
            rs=objConectar.consultarBD(strSQL);
            if(rs.next()){
                return rs.getString("pregunta");
            }
        } catch (Exception e) {
              throw new Exception(e.getMessage());
        }
        return ""; 
    }
       public boolean validarPregunta(String usu, String rpta) throws Exception{
        strSQL="select * from usuario where nomusu='"+usu+"' and upper(respuesta)=upper('"+rpta+"')";
        try {
            rs=objConectar.consultarBD(strSQL);
            if(rs.next()){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
              throw new Exception(e.getMessage());
        }
        
    }
       
       public void cambiarContrasena(String usu, String cont) throws Exception{
        strSQL="UPDATE usuario SET con = '"+cont+"' WHERE nomusu = '"+usu+"'";
        try {
           objConectar.ejecutarBD(strSQL);
           
        } catch (Exception e) {
              throw new Exception(e.getMessage());
        }
        
    }
       
        public String usuInicioSesion(String usu) throws Exception{
        strSQL="select nombrescompleto from usuario where nomusu='"+usu+ "'";
        try {
            rs=objConectar.consultarBD(strSQL);
            if(rs.next()){
                return rs.getString("nombresCompleto");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return "";
    }
        
       
}
