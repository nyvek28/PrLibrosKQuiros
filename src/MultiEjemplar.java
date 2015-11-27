import java.sql.ResultSet;
import java.sql.SQLException;

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
					ejem = new Ejemplar (rs.getDate("FechaIngreso"), 
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
		"SET FechaIngreso='"+e.getFechaIngreso()+"' "+
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
		
		String sql;
		
		sql = "DELETE *"
			+ "FROM TbEjemplar"
			+ "WHERE Codigo = "+e.getId();
		try{
			Conector.getConector().ejecutarSQL(sql, true);
		}catch(Exception f){
			f.printStackTrace();
		}
	}
	
}
