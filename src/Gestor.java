import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;
import java.util.Vector;

public class Gestor {
	
	/*recibe parametros*/
	public void registrarCliente(){


	}
	
	/*recibe paramentros*/
	public Vector<TreeMap<Object, Object>> consultarUsuario(String nombre){

		Vector<TreeMap<Object, Object>> usuarios = new Vector<TreeMap<Object, Object>>();
		ResultSet busqueda = (new MultiUsuario()).buscar(nombre);
		
		try {
			while(busqueda.next()){
				
				TreeMap<Object, Object> unUsuario = new TreeMap<Object, Object>();
				
				unUsuario.put("id", busqueda.getString("Cedula"));
				unUsuario.put("nombre", busqueda.getString("Nombre"));
				unUsuario.put("apellido", busqueda.getString("Apellido"));
				unUsuario.put("email", busqueda.getString("Email"));
				unUsuario.put("direccion", busqueda.getString("Direccion"));
				unUsuario.put("telefono", busqueda.getString("Telefono"));
				
				usuarios.add(unUsuario);
				
			}
		} catch (SQLException e) {
			System.out.println("Error en Gestor/consultarUsuario");
			e.printStackTrace();
		}
		
		return usuarios;

	}
	
	public TreeMap<Object,Object> consultarUsuario(int id){

		Usuario user;
		TreeMap<Object,Object> datos = new TreeMap<Object,Object>();
		
		user = (new MultiUsuario()).buscar(id);
		datos.put("identificacion", user.getId());
		datos.put("nombre", user.getNombre());
		datos.put("apellido", user.getApellido());
		datos.put("telefono", user.getTelefono());
		datos.put("email", user.getEmail());
		datos.put("direccion", user.getDireccion());
		
		
		return datos;

	}

	/*recibe paramentros*/
	public void modificarUsuario(String pnombre, String papellido, int pid, String pemail, String pdireccion, int ptelefono){
		
		Usuario user = (new MultiUsuario()).buscar(pid);
		user.setNombre(pnombre);
		user.setApellido(papellido);
		user.setEmail(pemail);
		user.setDireccion(pdireccion);
		user.setTelefono(ptelefono);
		try{
			(new MultiUsuario()).actualizar(user);
		}catch(Exception e){
			System.out.println("Error en Gestor/modificarUsuario/.actuaizar(user)");
		}

	}

	/*recibe paramentros*/
	public void reservarEjemplar(){


	}

	/*recibe paramentros*/
	public void prestarEjemplar(){


	}

	/*recibe paramentros*/	
	public void devolverLibro(){


	}

	/*recibe paramentros*/
	public void cancelarMulta(){


	}

	/*recibe paramentros*/
	public void anularReservacion(){


	}


	/*recibe paramentros*/
	public void eliminarCliente(){


	}

	/* recibe parametros */
	public void registrarLibro(){


	}

	/*recibe parametros*/
	public void modificarLibro(){


	}

	/*recibe parametros*/
	public String consultarLibro(){

		/* consultar libro */ 
		String x = "";
		return x;

	}

	/*recibe parametros*/
	public void registrarEjemplar(){


	}

	/*recibe parametros*/
	public void modificarEjemplar(){


	}

	/*recibe parametros*/
	public String consultarEjemplar(){

		// consultar ejemplar
		String x = "";
		return x;
		
	}

	/*recibe parametros*/
	public void eliminarEjemplar(){


	}

	/*recibe parametros*/
	public void mostrarHistorialTransacciones(){


	}

	/*recibe parametros*/
	public String consultarTransaccion(){

		// consultar transaccion
		String x = "";
		return x;
		
	}

	/*recibe parametros*/
	public String consultarAutor(){

		// consultar autor
		String x = "";
		return x;
	}

	/*recibe parametros*/
	public void registrarAutor(){


	}

	/*recibe parametros*/
	public void modificarAutor(){


	}

	/*recibe parametros*/
	//DA: descriptor asociado
	public String consultarDA(){

		// consultar descriptor asociado
		String x = "";
		return x;
		
	}

	/*recibe parametros*/ 
	// DA: descriptor asociado

	public void registrarDA(){


	}

	/*recibe parametros*/
	public void modificarDA(){


	}

	public String verEstado(){

		String x = "";
		return x;
	}
}
