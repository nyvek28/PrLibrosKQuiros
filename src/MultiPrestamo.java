import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

class MultiPrestamo {

	public Prestamo crear(Libro libro, int estadoFisico){
		return null;
	}
	
	public Prestamo buscar(Ejemplar e){
		return null;
	}
	
	public Vector<Prestamo> buscar(Usuario u){
		
		String sql;
		Vector prestamos = new Vector();
		ResultSet rs = null;
		
		sql = "SELECT * "
			+ "FROM TbPrestamo "
			+ "WHERE IdUsuario = "+u.getId();
		try {
			rs = Conector.getConector().ejecutarSQL(sql,true);
		} catch (Exception e) {
			System.out.println("Error con el conector de buscar(Usuario u) en la clase MultiPrestamo");
			e.printStackTrace();
		}
		try {
			while(rs.next()){
				Prestamo p = new Prestamo(rs.getDate("FechaPrestamo"),
											rs.getInt("IdPrestamo"),
											rs.getInt("CantDias"),
											rs.getInt("IdUsuario"),
											rs.getInt("IdEjemplar"),
											rs.getInt("IdTransaccion"),
											rs.getInt("Activo"));
				prestamos.add(p);
			}
		} catch (SQLException e) {
			System.out.println("Error en el while de buscar(Usuario u) en la clase MultiPrestamo");
			e.printStackTrace();
		}
		return prestamos;
		
	}
	
	public Prestamo buscar(Ejemplar e, Usuario u){
		return null;
	}
	
	public ResultSet buscar(String nombre){
		return null;
	}
	
	public void actualizar(Prestamo e){
		
	}
	
	public void borrar(Prestamo e){
		
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
