import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class MultiEjemplar {

	public Ejemplar crear(Libro libro, int estadoFisico){
		return null;
	}
	
	public Ejemplar buscar(int id){
		String sql;
		ResultSet rs = null;
		Ejemplar ejem  = null;
		
		sql = "SELECT * "
			+ "FROM TbEjemplar "
			+ "WHERE Codigo = "+id;
		try {
			rs = Conector.getConector().ejecutarSQL(sql,true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (rs.next()) {
				try {
					ejem = new Ejemplar (this.fechaToDate(rs.getString("FechaIngreso")), 
							rs.getInt("Codigo"), 
							rs.getInt("EstadoFisico"), 
							rs.getInt("CondicionActual"), 
							rs.getString("Isbn"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				ejem = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ejem;
	}
	
	public ResultSet buscar(String nombre){
		return null;
	}
	
	public void actualizar(Ejemplar e)throws 
	java.sql.SQLException,Exception{
		
		String sql;
		sql = "UPDATE TbEjemplar "+
		"SET Codigo='"+e.getId()+"' "+
		"SET FechaIngreso='"+this.fechaToString(e.getFechaIngreso())+"' "+
		"SET Isbn='"+e.getIsbn()+"' "+
		"SET EstadoFisico='"+e.getEstadoFisico()+"' "+
		"SET CondicionActual='"+e.getCondicionActual()+"' "+
		"WHERE Codigo='"+e.getId()+"';";
		try {
			Conector.getConector().ejecutarSQL(sql);
		}
		catch (Exception f) {
			throw new Exception ("El cliente no está registrado.");
		}
	}
	
	public void borrar(Ejemplar e){
		
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
