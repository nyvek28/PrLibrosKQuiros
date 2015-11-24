import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;
import java.util.Vector;

public class Gestor {
	
	/*recibe parametros*/
	public void registrarCliente(String pnombre, String papellido, int pid, String pemail, String pdireccion, int ptelefono){
		Usuario usuario;
		usuario= (new MultiUsuario()).crear(pnombre, papellido, pid, pemail, pdireccion, ptelefono);

	}
	
	/*recibe paramentros*/
	public Vector<TreeMap<Object, Object>> consultarUsuario(String nombre, String apellido){

		Vector<TreeMap<Object, Object>> usuarios = new Vector<TreeMap<Object, Object>>();
		Vector<Usuario> busqueda = (new MultiUsuario()).buscar(nombre, apellido);
		
		try {
			for(int i = 0; i < busqueda.size(); i++){
				
				TreeMap<Object, Object> unUsuario = new TreeMap<Object, Object>();
				
				unUsuario.put("id", busqueda.get(i).getId());
				unUsuario.put("nombre", busqueda.get(i).getNombre());
				unUsuario.put("apellido", busqueda.get(i).getApellido());
				unUsuario.put("email", busqueda.get(i).getEmail());
				unUsuario.put("direccion", busqueda.get(i).getDireccion());
				unUsuario.put("telefono", busqueda.get(i).getTelefono());
				
				usuarios.add(unUsuario);
				
			}
		} catch (Exception e) {
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
	public String devolverEjemplar(int id, int codigoEjemplar){

		String msj;
		
		msj = (new MultiUsuario()).buscar(id).devolverEjemplar(codigoEjemplar);
		
		return msj;

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
