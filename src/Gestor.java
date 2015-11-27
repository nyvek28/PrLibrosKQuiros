import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;
import java.util.Vector;

public class Gestor {
	
	/*recibe parametros*/
	public void registrarCliente(String pnombre, String papellido, int pid, String pemail, String pdireccion, int ptelefono)throws Exception{
		
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

	/*recibe parametros*/
	public String reservarEjemplar(int pidEjemplar, int idUsuario ){
			
		Ejemplar ejemplar;
		ejemplar=(new MultiEjemplar()).buscar(pidEjemplar);
		String msj;
		msj=(new MultiUsuario()).buscar(idUsuario).reservarEjemplar(pidEjemplar);
		return msj;

	}

	/*recibe paramentros*/
	public String prestarEjemplar(int id, int codigoEjemplar)throws 
	java.sql.SQLException,Exception{
		
		String msj;
		Usuario u;
		msj = "";
		
		u = (new MultiUsuario()).buscar(id);
		if(u != null){
			u.prestarEjemplar(codigoEjemplar);
		}else{
			msj = "No se encontro el usuario que busca";
		}
		
		return msj;


	}

	/*recibe parametros*/	
	public String devolverEjemplar(int id, int codigoEjemplar){

		String msj;
		Usuario u;
		
		u = (new MultiUsuario()).buscar(id);
		if(u != null){
			msj = u.devolverEjemplar(codigoEjemplar);
		}else{
			msj = "No se encontro el usuario que busca";
		}
		
		return msj;

	}

	/*recibe paramentros*/
	public void cancelarMulta(){
		

	}

	/*recibe paramentros*/
	public void anularReservacion(){


	}


	/*recibe paramentros*/
	public String eliminarUsuario(int id){

		Usuario u;
		String msj;
		
		u = (new MultiUsuario()).buscar(id);
		try{
			if(u != null){
				(new MultiUsuario()).borrar(u);
				msj = "Se ha borrado el usuario";
			}else{
				msj = "No se ha encontrado el usuario de id: "+id;
			}
		}catch(Exception e){
			msj = "Ocurrio un error al intentar borrar al usuario, porfavor intentelo de nuevo";
		}
		
		return msj;
		
	}

	/* recibe parametros */
	/*Hace falta validacion dobre si el libro ya esta registrado*/
	public String registrarLibro(String ptitulo,String pvolumen, String peditorial, String pfecha,ArrayList<Autor> plistaAutores,ArrayList<DescriptorAsociado> plistaDescriptores,ArrayList<Ejemplar> plistaEjemplares)throws Exception{
		
		Libro libro;
		String msj;
		
		try{
			libro=(new MultiLibro()).crear(ptitulo, pvolumen, peditorial, pfecha, plistaAutores, plistaDescriptores,plistaEjemplares);
			msj = "Se ha registrado el libro corectamente";
		}catch(Exception e){
			e.printStackTrace();
			msj = "Ocurrio un error al registrar el libro, porfavor intentelo de nuevo";
		}
		
		return msj;

	}

	/*recibe parametros*/
	public void modificarLibro(String pisbn,String ptitulo,String pvolumen, String peditorial, String pfecha,ArrayList<Autor> plistaAutores,ArrayList<DescriptorAsociado> plistaDescriptores,ArrayList<Ejemplar> plistaEjemplares)throws Exception{
		Libro libro = (new MultiLibro()).buscar(pisbn);
		libro.setIsbn(pisbn);
		libro.setTitulo(ptitulo);
		libro.setVolumen(pvolumen);
		libro.setEditorial(peditorial);
		libro.setFecha(pfecha);
		libro.setListaAutores(plistaAutores);
		libro.setListaDescriptores(plistaDescriptores);
		
		
		try{
			(new MultiLibro()).actualizar(libro);
		}catch(Exception e){
			System.out.println("Error en Gestor/modificarUsuario/.actuaizar(user)");
		}


	}

	/*recibe parametros*/
	public TreeMap<Object,Object> consultarLibro(String ptitulo) throws SQLException, Exception{

		Libro libro;
		TreeMap<Object,Object> datos = new TreeMap<Object,Object>();
		
		libro = (new MultiLibro()).buscarTitulo(ptitulo);
		
		datos.put("isbn", libro.getIsbn());
		datos.put("Titulo", libro.getTitulo());
		datos.put("Volumen", libro.getVolumen());
		datos.put("Editorial", libro.getEditorial());
		datos.put("Fecha", libro.getFecha());
		
		return datos;

	}

	/*recibe parametros*/
	public String registrarEjemplar(String isbn, int estadoFisico) throws SQLException, Exception{

		String msj;
		Libro l;
		
		
		l = (new MultiLibro()).buscarIsbn(isbn);
		if (l != null){
			msj = l.registrarEjemplar(estadoFisico);
		}else{
			msj = "El libro que ingreso, de ISBN " + isbn + " no se encuentra.";
		}
		
		return msj;

	}

	/*recibe parametros*/
	public void modificarEjemplar(){


	}

	/*recibe parametros*/
	public TreeMap<Object,Object> consultarEjemplar(int pid){
		Ejemplar ejem;
		TreeMap<Object,Object> datos = new TreeMap<Object,Object>();
		
		ejem = (new MultiEjemplar()).buscar(pid);
		
		datos.put("identificacion", ejem.getId());
		datos.put("Estado Fisico", ejem.getEstadoFisico());
		datos.put("CondicionActual", ejem.getCondicionActual());
		datos.put("titulo", (ejem.getLibro()).getTitulo());
		
		
		
		return datos;
		// consultar ejemplar
		
		
		
	}

	/*recibe parametros*/
	public String eliminarEjemplar(int pid){
		
		Ejemplar e;
		String msj;
		
		e = (new MultiEjemplar()).buscar(pid);
		try{
			if(e != null){
				(new MultiEjemplar()).borrar(e);
				msj = "Se ha borrado el usuario";
			}else{
				msj = "No se ha encontrado el usuario de id: "+pid;
			}
		}catch(Exception e){
			msj = "Ocurrio un error al intentar borrar al usuario, porfavor intentelo de nuevo";
		}
		
		return msj;
		
	}

	/*recibe parametros*/
	public String mostrarHistorialTransacciones(int id){

		ArrayList<Transaccion> transacciones;
		Ejemplar e;
		String msj = "";
		
		e = (new MultiEjemplar()).buscar(id);
		if(e != null){
			transacciones = e.getTransacciones();
			if(transacciones.size() > 0){
				for(int i = 0; i < transacciones.size(); i++){
					msj += "-----------------------------------------"+
							"Id: "+transacciones.get(i).getId()+"\n"+
							"Fecha: "+this.formatearFecha(transacciones.get(i).getFecha())+"\n"+
							"Tipo: "+transacciones.get(i).tipoToString()+"\n"+
							"Usuario: "+transacciones.get(i).getUser().getNombre()+" "+transacciones.get(i).getUser().getApellido()+"\n"+
							"Ejemplar: "+transacciones.get(i).getEjemplar().getLibro().getTitulo()+"\n"+
							"-----------------------------------------\n\n";
				}
			}else{
				msj = "Este ejemplar no tiene transacciones";
			}
		}else{
			msj = "No se encontro el ejemplar que busca";
		}

	/*recibe parametros*/
	public String consultarTransaccion(int pid){
		Transaccion trans;
		TreeMap<Object,Object> datos = new TreeMap<Object,Object>();
		
		trans = (new MultiTransaccion()).buscar(pid);
		
		datos.put("identificacion", ejem.getId());
		datos.put("Estado Fisico", ejem.getEstadoFisico());
		datos.put("CondicionActual", ejem.getCondicionActual());
		datos.put("titulo", (ejem.getLibro()).getTitulo());
		
		
		
		return datos;
		// consultar transaccion
		String x = "";
		return x;
		
	}

	/*recibe parametros*/
	public TreeMap consultarAutor(int id){

		TreeMap datos = new TreeMap();
		Autor a;
		
		a = (new MultiAutor()).buscar(id);
		if(a != null){
			datos.put("id", a.getId());
			datos.put("nombre", a.getNombre());
			datos.put("apellido", a.getApellido());
			datos.put("email", a.getEmail());
			datos.put("paisOrigen", a.getPaisOrigen());
			datos.put("nacionalidad", a.getNacionalidad());
		}else{
			datos = null;
		}
		
		return datos;
		
	}
	
	public ArrayList consultarAutorNombre(String nombre){

		ArrayList variosAutores = new ArrayList();
		ArrayList<Autor> autores;
		
		autores = (new MultiAutor()).buscar(nombre);
		if(autores.size() > 0){
			for(int i = 0; i < autores.size(); i++){
				
				TreeMap datos = new TreeMap();
				datos.put("id", autores.get(i).getId());
				datos.put("nombre", autores.get(i).getNombre());
				datos.put("apellido", autores.get(i).getApellido());
				datos.put("email", autores.get(i).getEmail());
				datos.put("paisOrigen", autores.get(i).getPaisOrigen());
				datos.put("nacionalidad", autores.get(i).getNacionalidad());
				variosAutores.add(datos);
			}
		}else{
			variosAutores = null;
		}
		
		return variosAutores;
		
	}

	/*recibe parametros*/
	public void registrarAutor(){


	}

	/*recibe parametros*/
	public void modificarAutor(String pnombre, String papellido, int pid, String pemail, String pnacionalidad, String ppaisOrigen)throws Exception{
		Autor autor;
		autor.setNombre(pnombre);
		autor.setApellido(papellido);
		autor.setId(pid);
		autor.setEmail(pemail);
		autor.setNacionalidad(pnacionalidad);
		autor.setPaisOrigen(ppaisOrigen);
		
		try{
			(new MultiAutor()).actualizar(autor);
		}catch(Exception e){
			System.out.println("Error en Gestor/modificarUsuario/.actualizar(user)");
		}

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

	public void registrarDA()throws Exception{
		DescriptorAsociado descr;
		descr= (new MultiDescriptorAsociado()).crear();

	}

	/*recibe parametros*/
	public void modificarDA(){
		

	}

	public String verEstado(){

		String x = "";
		return x;
	}
	
	public String formatearFecha(Date pFecha){
		
		String fecha;
		SimpleDateFormat formato = new SimpleDateFormat("dd MMMM yyyy");
		
		fecha = formato.format(pFecha);
		
		return fecha;
		
	}
}
