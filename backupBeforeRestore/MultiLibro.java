

/*import java.sql.*;
import java.util.Vector;
import java.util.Date;*/
import java.util.ArrayList;

public class MultiLibro {
	
	public Libro crear(String ptitulo, String pvolumen, String peditorial, String pfecha, ArrayList<Autor> listaAutores,ArrayList<DescriptorAsociado> plistaDescriptores) throws java.sql.SQLException,Exception{
		
		Libro libro=null;/*
		String sql;
		sql="INSERT INTO TLibro "+
		"VALUES ('"+ptitulo+"','"+pvolumen+"','"+peditorial+"','"+pfecha+"','"+listaAutores+"''"+plistaDescriptores+"');";
		try {
			Conector.getConector().ejecutarSQL(sql);
			libro = new Libro(ptitulo, pvolumen, peditorial, pfecha, plistaAutores,plistaDescriptores);
		}
		catch (Exception e) {
			throw new Exception (".");
		}*/
		return libro;
	}
	
	public  Libro buscar(String ptitulo, String columna) throws java.sql.SQLException,Exception{
		
		Libro libro = null;/*
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT titulo,volumen,editorial,fecha,listaAutores,listaDescriptores "+
		"FROM TLibro "+
		"WHERE" + columna + " LIKE "+ptitulo+"';";
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
		rs.close();*/
		return libro; 
	}
	
	public  Libro buscar(int codigo) throws java.sql.SQLException,Exception{
		
		Libro libro = null;/*
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT titulo,volumen,editorial,fecha,listaAutores,listaDescriptores "+
		"FROM TLibro "+
		"WHERE titulo='"+ptitulo+"';";
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
		rs.close();*/
		return libro; 
	}
	
	
	public  void actualizar(Libro plibro) throws java.sql.SQLException,Exception{
		
		/*String sql;
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
		} */
	}
	
	public  void borrar(Libro plibro) throws java.sql.SQLException,Exception{
		
		/*java.sql.ResultSet rs;
		String sql;
		sql= "DELETE FROM TLibro "+
		"WHERE titulo='"+pcuenta.getTitulo()+"';";
		try {
			Conector.getConector().ejecutarSQL(sql);
		}
		catch (Exception e) {
			throw new Exception ("");
		}*/
	}
}