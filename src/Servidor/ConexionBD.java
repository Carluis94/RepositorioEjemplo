
package Servidor;
import java.sql.*;
import java.util.logging.*;

public class ConexionBD {
    public String bd = "palindromo";
    public String user = "root";
    public String pass = "carlitos.1994";
    public String url = "jdbc:mysql://localhost:3306/"+bd;
    
    public Connection conectar(){
    
        Connection conexion = null;

        try{
            conexion = DriverManager.getConnection(url, user, pass);
        }catch (Exception ex){
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }//Fin try-catch
        return conexion; 
    }//Fin metodo conectar
}//Fin clase ConexionBD