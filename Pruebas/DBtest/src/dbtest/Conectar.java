/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbtest;

/**
 *
 * @author Emilio
 */
public class Conectar {
    
    	private static AccesoDB conectorDB = null;
    
    public static AccesoDB getConector() throws java.sql.SQLException,Exception{
	
        if(conectorDB==null){
	
            conectorDB = new AccesoDB("net.ucanaccess.jdbc.UcanaccessDriver","jdbc:ucanaccess://C:/Users/Emilio/Desktop/DbTest1.accdb");
	}
        
	return conectorDB;
    }
    
}
