/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbtest;

import java.sql.ResultSet;

/**
 *
 * @author Emilio
 */
public class UI {
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws Exception {
        
        ResultSet resultado;
        String msj = "";
        resultado = Conectar.getConector().ejecutarSQL("SELECT*FROM tbPersona", true);
       
        try{
            
            while(resultado.next()){
                
                msj += "Nombre: "+resultado.getNString("Nombre")+"\n";
                
            }
            
        }catch(Exception e){
            
            msj = "Error";
            
        }
        
        System.out.print(msj);
        
    }
    
}
