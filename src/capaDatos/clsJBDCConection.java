
package capaDatos;

import java.sql.*;

/**
 *
 * @author Emily, 31/08/2021
 */
public class clsJBDCConection {
    private String driver, url, user, password;
    private Connection con;
    private Statement sent=null;
    
//constructor de clase
    public clsJBDCConection() {
        this.driver = "org.postgresql.Driver";
        this.url = "jdbc:postgresql://localhost:5432/BDHotel";
        this.user = "postgres";
        this.password = "71396417";
        this.con = null;
    }
//    public clsJDBCConexion(String driver, String url, String user, String password) {
//        this.driver = "org.postgresql.Driver";
//        this.url = "jdbc:postgresql://localhost:5432/BDHotel";
//        this.user = "postgres";
//        this.password = "aljanare";
//        this.con = null;
//    }

    //sobrecargar el contructor
    public clsJBDCConection(String strBD) {
        this.driver = "org.postgresql.Driver";
        this.url = "jdbc:postgresql://localhost:5432/"+strBD;
        this.user = "postgres";
        this.password = "71396417";
        this.con = null;
    }

   
 //Conexión a BD
    public void conectarBD() throws Exception{
        try {
            Class.forName(this.driver);
            con=DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new Exception("Error al conectar a la BD...");
        }
    }
    
    //Desconectar de BD
    public void desconectarBD() throws Exception{
        try {
            con.close();
        } catch (SQLException e) {
           throw new Exception("Error al desconectar a la BD...");
        }
    }

   //Consulta el estado de la conexion
    public boolean getEstadoConexion() throws SQLException{
        return con.isClosed();
    }
    
    //Ejecutar consultas en la BS: select
    public ResultSet consultarBD(String strSQL) throws Exception{
        ResultSet rs =null;
        try{
            conectarBD();
            sent=con.createStatement();
            rs=sent.executeQuery(strSQL);
            return rs;
        } catch (Exception e){
            throw new Exception("Error al iniciar sesión...");
            
        }finally{
            if(con!=null){
                desconectarBD();
            }
        }
    }
    
    //Ejecutar insert, update y delete
    public void ejecutarBD(String strSQL) throws Exception{
        try{
        conectarBD();
        sent= con.createStatement();
        sent.executeUpdate(strSQL);
        } catch (Exception e){
            throw new Exception("Error al iniciar sesión...");
            
        }finally{
            if(con!=null){
                desconectarBD();
            }
        }
    }
}
