
package Negocio;

import Servidor.MetodosBD;
import java.sql.*;
import java.util.logging.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public final class Metodos {
    static DefaultTableModel modelo;
    
    private Metodos(){
    }//Fin constructor
    
    private static String eliminarEspacios(String texto){
        return texto.replace(" ", "");
    }//Fin metodo eliminarEspacios
    
    private static void insertar(String detalle){
        MetodosBD.insertar(detalle);
    }//FIn metodo insertar
    
    public static String voltear(String texto){
        String vuelta = "";    
        int tam = texto.length();
        
        for (int i = tam-1; i >= 0; i--) {
            vuelta = vuelta + texto.charAt(i);
        }//Fin for
        
        return vuelta;   
    }//Fin metodo voltear 
    
    public static boolean verificar(String texto, String volteo){
        return eliminarEspacios(texto).equals(eliminarEspacios(volteo));              
    }//Fin metodo verificar
    
    public static void consultar(JTable tblDatos){
        try {
            Object[] registro = new Object[2];
            modelo = (DefaultTableModel) tblDatos.getModel();
            
            ResultSet rs = MetodosBD.consultar();
            
            while (rs.next()){
                registro[0] = rs.getInt(1);
                registro[1] = rs.getString(2);
                
                modelo.addRow(registro);
            }//Fin while
            
            tblDatos.setModel(modelo);
        }catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }//Fin try-catch
    }//Fin metdo consultar
    
    public static void existe(String detalle){
        try {
            boolean existe = false;
            ResultSet rs = MetodosBD.existe(detalle);
            
            while (rs.next()){
                existe=true;
            }//Fin while
            
            if (existe == false) {
                insertar(detalle);
            }//Fin condicion
        }catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }//Fin try-catch
    }//Fin metodo existe
    
    public static void limpiarTable(JTable tblDatos){
        try {
            modelo = (DefaultTableModel) tblDatos.getModel();
            int filas=tblDatos.getRowCount();

            for (int i = 0;i<=filas-1; i++) {
                modelo.removeRow(0);
            }//FIn for
        } catch (Exception e) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, e);
        }//Fin try-catch
    }//Fin metodo limpiarTable
}//FIn clase Metodos
