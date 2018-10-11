
package Servidor;

import java.sql.*;
import java.util.logging.*;

public final class MetodosBD {
    static ConexionBD cbd = new ConexionBD();
    static Statement stm;
    static String sSQL = "";
        
    public static ResultSet consultar() {
        try {  
            Connection cn = cbd.conectar();
            sSQL = "SELECT * from texto";
            
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MetodosBD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }//Fin try-catch
    }//Fin metodo consultar
    
    public static void insertar(String detalle){
        try{       
            Connection con = cbd.conectar();
            sSQL = "INSERT INTO texto(text_detalle) VALUES ('"+detalle+"')";
    
            Statement st = (Statement) con.createStatement();
            st.executeUpdate(sSQL);
        }catch(SQLException ex){
            Logger.getLogger(MetodosBD.class.getName()).log(Level.SEVERE, null, ex);
        }//Fin try catch
    }//Fin metodo insertar
    
    public static ResultSet existe(String detalle){
        try{    
            Connection cn = cbd.conectar();
            sSQL = "SELECT * FROM texto WHERE text_detalle = '"+ detalle +"'";
            
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            return rs;
        }catch(SQLException ex){
            Logger.getLogger(MetodosBD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }//Fin try-catch    
    }//Fin metodo existe
}//Fin clase MetodosBD
