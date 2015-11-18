
public class Usuario {
	private String nombre;
	private String apellido;
	private String id;
	private String email;
	private String direccion;
	private int telefono;
	
	public Usuario(String pnombre, String papellido, String pid, String pemail, String pdireccion, int ptelefono){
		setNombre(pnombre);
		setApellido(papellido);
		setId(pid);
		setEmail(pemail);
		setDireccion(pdireccion);
		setTelefono(ptelefono);
	}
	public void setNombre(String pnombre){
		nombre=pnombre;
	}
	public void setApellido(String papellido){
		apellido=papellido;
	}
	public void setId(String pid){
		id=pid;
	}
	public void setEmail(String pemail){
		email=pemail;
	}
	public	 void setDireccion(String pdireccion){
		direccion=pdireccion;
	}
	private void setTelefono(int ptelefono){
		telefono=ptelefono;
	}
	public String getNombre(){
		return nombre;
	}
	public String getApellido(){
		return apellido;
	}
	public String getId(){
		return id;
	}
	public String getEmail(){
		return email;
	}
	public String getDireccion(){
		return direccion;
	}
	public int getTelefono(){
		return telefono;
	}

			
			
}
