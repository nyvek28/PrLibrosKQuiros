import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

class MultiUsuario {

	public Usuario crear(String pnombre, String papellido, int pid, String pemail, String pdireccion, int ptelefono){
		return null;
	}
	
	public Usuario buscar(int id){
		
		String sql;
		ResultSet rs = null;
		Usuario user  = null;
		
		sql = "SELECT * "
			+ "FROM TbUsuario "
			+ "WHERE Identificacion = "+id;
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
				user = new Usuario (rs.getString("Nombre"), 
						rs.getString("Apellido"), 
						rs.getInt("Identificacion"), 
						rs.getString("Email"), 
						rs.getString("Direccion"), 
						rs.getInt("Telefono"));
			} else {
				user = null;
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
		
		return user;
		
	}
	
	public Vector buscar(String nombre, String apellido){
		
		String sql;
		ResultSet rs;
		Usuario user;
		Vector<Usuario> usuarios = new Vector<Usuario>();
		
		sql = "SELECT * "
			+ "FROM TbUsuario "
			+ "WHERE Nombre LIKE '"+nombre+"' "
			+ "AND Apellido LIKE '"+apellido+"'";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		while (rs.next()) {
			user = new Usuario (rs.getString("Nombre"), rs.getString("Apellido"), rs.getInt("Identificacion"), 
					rs.getString("Email"), rs.getString("Direccion"), rs.getInt("Telefono"));
			usuarios.add(user);
		}
		rs.close();
		
		return usuarios;
		
	}
	
	public void actualizar(Usuario u){
		
		String sql;
		
		sql = "UPDATE TbUsuario "
			+ "SET Nombre = '"+u.getNombre()+"' "
				+", Apellido = '"+u.getApellido()+"' "
				+", Direccion = '"+u.getDireccion()+"' "
				+", Email = '"+u.getEmail()+"' "
				+", Telefono = "+u.getTelefono()+" "
			+ "WHERE Identificacion = "+u.getId();
		Conector.getConector().ejecutarSQL(sql,true);
		
	}
	
	public void borrar(Usuario u, String pnombre, String papellido, int pid, String pemail, String pdireccion, int ptelefono){
		
	}
	
}
