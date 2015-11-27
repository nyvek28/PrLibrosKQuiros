import java.util.Vector;

public class Usuario {
	
	private String nombre;
	private String apellido;
	private int id;
	private String email;
	private String direccion;
	private int telefono;
	private Vector<Prestamo> prestamos;
	private Vector<Multa> multas;
	
	public Usuario(String pnombre, String papellido, int pid, String pemail, String pdireccion, int ptelefono){
		setNombre(pnombre);
		setApellido(papellido);
		setId(pid);
		setEmail(pemail);
		setDireccion(pdireccion);
		setTelefono(ptelefono);
		this.setPrestamos(new Vector<Prestamo>());
		this.setMultas(new Vector<Multa>());
	}
	
	public String devolverEjemplar(int codigoEjemplar) throws Exception{
		
		String msj = "El ejemplar que intenta devolver no se encuentra en los prestamos activos de este cliente";
		Ejemplar ejemplar = null;
		Prestamo prestamo = null;
		
		for(int i = 0; i < this.getPrestamos().size(); i++){
			if(codigoEjemplar == this.getPrestamos().get(i).getIdEjemplar() && this.getPrestamos().get(i).getActivo() != 0){	
				prestamo = this.getPrestamos().get(i);
				ejemplar = prestamo.getEjemp();	
			}
		}
		if(ejemplar != null){
			(new MultiTransaccion()).crear(this, ejemplar, 2, "Devolucion");
			try {
				prestamo.concluirPrestamo();
			} catch (Exception e) {
				System.out.println("Error en la conclusion del prestamo en Usuario");
				e.printStackTrace();
			}
			msj = "Se ha devuelto el libro";
		}
		
		return msj;
		
	}
	public String reservarEjemplar(int codigoEjemplar){
		
		(new MultiEjemplar()).buscar(codigoEjemplar).setCondicionActual(2);
		String x="";
		return x;
		
	}
	public void cancelarMulta(){
		
		
		
	}
	
	public void setNombre(String pnombre){
		nombre=pnombre;
	}
	public void setApellido(String papellido){
		apellido=papellido;
	}
	public void setId(int pid){
		id=pid;
	}
	public void setEmail(String pemail){
		email=pemail;
	}
	public	 void setDireccion(String pdireccion){
		direccion=pdireccion;
	}
	public void setTelefono(int ptelefono){
		telefono=ptelefono;
	}
	public String getNombre(){
		return nombre;
	}
	public String getApellido(){
		return apellido;
	}
	public int getId(){
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
	
	public void prestarEjemplar(int pcodigoEjemplar)throws 
	java.sql.SQLException,Exception{
		Ejemplar e;
		MultiEjemplar multi;
		
		multi = new MultiEjemplar();
		e = multi.buscar(pcodigoEjemplar);
		e.setCondicionActual(1);
		multi.actualizar(e);
	}

	public Vector<Prestamo> getPrestamos() throws Exception{
		Vector p;
		
		p = (new MultiPrestamo()).buscar(this);
		
		return p;
	}

	public void setPrestamos(Vector<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public Vector<Multa> getMultas() {
		return multas;
	}

	public void setMultas(Vector<Multa> multas) {
		this.multas = multas;
	}

			
			
}
