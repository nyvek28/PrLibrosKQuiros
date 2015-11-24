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
	
	public void actualizar(Ejemplar e){
		
	}
	
	public void borrar(Ejemplar e){
		
	}
	
}
