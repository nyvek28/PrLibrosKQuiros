 import java.util.Date;

class Transaccion {
	
	private static int consecutivo = 0;
	private Date fecha;
	private int id;
	private int tipo;
	private int idUsuario;
	private int idEjemplar;
	private String descripcion;
	private Ejemplar ejemplar;
	private Usuario user;
	
	public Transaccion(Date fecha, int tipo, int idUsuario, int idEjemplar, String descripcion, Ejemplar ejemplar,
			Usuario user, int id) {
		
		this.setId(id);
		this.fecha = fecha;
		this.tipo = tipo;
		this.idUsuario = idUsuario;
		this.idEjemplar = idEjemplar;
		this.descripcion = descripcion;
		this.ejemplar = ejemplar;
		this.user = user;
	}

	public Transaccion (Usuario u, Ejemplar e, int pTipo, String pDesccripcion){
		
		this.setId(Transaccion.getConsecutivo()+1);
		this.setFecha(new Date());
		this.setTipo(pTipo);
		this.setDescripcion(pDesccripcion);
		this.setIdUsuario(u.getId());
		this.setIdEjemplar(e.getId());
		this.setEjemplar(e);
		this.setUser(u);
		
	}
	
	private void realizarAccion(int t) {
		
		switch(t){
		
			case 0:
			case 2:
				this.getEjemplar().setCondicionActual(0);
				break;
				
			case 1:
				this.getEjemplar().setCondicionActual(1);
				break;
				
			case 3:
				this.getEjemplar().setCondicionActual(2);
				break;
				
			case 4:
			case 5:
				this.getEjemplar().setCondicionActual(3);
				break;
				
			default:
				this.getEjemplar().setCondicionActual(0);
				break;
		
		}
			
	}
	
	public String tipoToString(){
		
		String tipo;
		String[] tipos = {"Entrada","Prestamo","Devolucion","Reservacion","Salida","Fuera de Uso"};
		
		tipo = tipos[this.getTipo()];
		
		return tipo;
		
	}
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
		this.realizarAccion(this.getTipo());
	}

	

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdEjemplar() {
		return idEjemplar;
	}

	public void setIdEjemplar(int idEjemplar) {
		this.idEjemplar = idEjemplar;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Ejemplar getEjemplar() {
		Ejemplar e;
		
		e = (new MultiEjemplar()).buscar(this.getIdEjemplar());
		
		return e;
	}

	public void setEjemplar(Ejemplar ejemplar) {
		this.ejemplar = ejemplar;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public static int getConsecutivo() {
		return consecutivo;
	}

	public static void setConsecutivo(int consecutivo) {
		Transaccion.consecutivo = consecutivo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
