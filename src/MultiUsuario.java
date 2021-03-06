import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

class MultiUsuario {

	public Usuario crear(String pnombre, String papellido, int pid, String pemail, String pdireccion, int ptelefono)throws Exception{
		
		Usuario usuario=null;
		String sql;
		sql="INSERT INTO TUsuario "+
		"VALUES ('"+pnombre+"','"+papellido+"','"+pid+"','"+pemail+"','"+pdireccion+"''"+ptelefono+"');";
		try {
			Conector.getConector().ejecutarSQL(sql);
			usuario = new Usuario(pnombre, papellido, pid, pemail, pdireccion,ptelefono);
		}
		catch (Exception e) {
			throw new Exception (".");
		}
		return usuario;
		
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
		}catch (Exception e) {
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
		ResultSet rs = null;
		Usuario user;
		Vector<Usuario> usuarios = new Vector<Usuario>();
		
		sql = "SELECT * "
			+ "FROM TbUsuario "
			+ "WHERE Nombre LIKE '"+nombre+"' "
			+ "AND Apellido LIKE '"+apellido+"'";
		try {
			rs = Conector.getConector().ejecutarSQL(sql,true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				user = new Usuario (rs.getString("Nombre"), 
									rs.getString("Apellido"), 
									rs.getInt("Identificacion"), 
									rs.getString("Email"), 
									rs.getString("Direccion"), 
									rs.getInt("Telefono"));
				usuarios.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
		try {
			Conector.getConector().ejecutarSQL(sql,true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void borrar(Usuario u){
		
		String sql;
		
		sql = "DELETE *"
			+ "FROM TbUsuario"
			+ "WHERE Identificacion = "+u.getId();
		try{
			Conector.getConector().ejecutarSQL(sql, true);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
