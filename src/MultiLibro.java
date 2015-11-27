

/*import java.sql.*;
import java.util.Vector;
import java.util.Date;*/
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MultiLibro {
	
	public Libro crear(String isbn,String ptitulo, String pvolumen, String peditorial, String pfecha, ArrayList<Autor> listaAutores,ArrayList<DescriptorAsociado> plistaDescriptores,ArrayList<Ejemplar> plistaEjemplares) throws java.sql.SQLException,Exception{
		
		Libro libro=null;
		String sql;
		sql="INSERT INTO TLibro "+
		"VALUES ('"+ptitulo+"','"+pvolumen+"','"+peditorial+"','"+pfecha+"','"+listaAutores+"''"+plistaDescriptores+"','"+plistaEjemplares+"');";
		try {
			Conector.getConector().ejecutarSQL(sql);
			libro = new Libro(isbn,ptitulo, pvolumen, peditorial, pfecha, listaAutores,plistaDescriptores,plistaEjemplares);
		}
		catch (Exception e) {
			throw new Exception (".");
		}
		return libro;
	}
	
	public  Libro buscarTitulo(String ptitulo) throws java.sql.SQLException,Exception{
		
		Libro libro = null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT titulo,volumen,editorial,fecha,listaAutores,listaDescriptores "+
		"FROM TLibro "+
		"WHERE Titulo LIKE '"+ptitulo+"'";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()){
			libro = new Libro(
				rs.getString("isbn"),
				rs.getString("titulo"),
				rs.getString("volumen"),
				rs.getString("editorial"),
				rs.getString("fecha"));
		} else {
			throw new Exception (".");
		}
		rs.close();
		return libro; 
	}
	
	public  Libro buscarIsbn(String isbn) throws java.sql.SQLException,Exception{
		
		Libro libro;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT titulo,volumen,editorial,fecha,listaAutores,listaDescriptores "+
		"FROM TLibro "+
		"WHERE Isbn = '"+isbn+"'";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()){
			libro = new Libro(
				rs.getString("isbn"),
				rs.getString("titulo"),
				rs.getString("volumen"),
				rs.getString("editorial"),
				rs.getString("fecha"));
		} else {
			libro = null;
		}
		rs.close();
		return libro; 
	}
	
	public  Libro buscar(String isbn) throws java.sql.SQLException,Exception{
		
		Libro libro = null;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT titulo,volumen,editorial,fecha,listaAutores,listaDescriptores "+
		"FROM TLibro "+
		"WHERE codigo='"+isbn+"';";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()){
			libro = new Libro(
				rs.getString("titulo"),
				rs.getString("volumen"),
				rs.getString("editorial"),
				rs.getDouble("fecha"),
				rs.getDouble("listaAutores"),
				rs.getString("listaDescriptores"));
		} else {
			throw new Exception (".");
		}
		rs.close();
		return libro; 
	}
	
	
	public  void actualizar(Libro plibro) throws java.sql.SQLException,Exception{
		
		String sql;
		sql="UPDATE TLibro "+
		"SET titulo="+plibro.getTitulo()+", "+
		"volumen='"+plibro.getVolumen()+"', "+
		"editorial='"+plibro.getEditorial()+"', "+
		"fecha='"+plibro.getFecha()+"' "+
		"WHERE titulo='"+plibro.getTitulo()+"';";
		try {
			Conector.getConector().ejecutarSQL(sql); 	
		}
		catch (Exception e) {
			throw new Exception ("");
		} 
	}
	
	public  void borrar(Libro plibro) throws java.sql.SQLException,Exception{
		
		java.sql.ResultSet rs;
		String sql;
		sql= "DELETE FROM TLibro "+
		"WHERE titulo='"+plibro.getTitulo()+"';";
		try {
			Conector.getConector().ejecutarSQL(sql);
		}
		catch (Exception e) {
			throw new Exception ("");
		}
	}
	
	public String fechaToString(Date fecha){
		
		String msj;
		
		msj = fecha.toString();
		
		return msj;
		
	}
	
	public Date fechaToDate(String texto) throws ParseException{		
		Date fecha;
		
		DateFormat formatter = new SimpleDateFormat("d-MMM-yyyy,HH:mm:ss aaa");
		fecha = formatter.parse(texto);
		
		return fecha;
		
	}
}