import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

class Ejemplar {

	Libro libro;
	Date fechaIngreso;
	String isbn;
	int id;
	int estadoFisico;
	int condicionActual;
	ArrayList<Transaccion> transacciones;
	static int consecutivo = 0;
	
	public Ejemplar(Date fechaIngreso, int id, int estadoFisico, int condicionActual, String isbn) throws SQLException, Exception {
		
		this.setIsbn(isbn);
		this.setLibro((new MultiLibro().buscar(isbn,"Isbn")));
		this.setFechaIngreso(fechaIngreso);
		this.setId(id);
		this.setEstadoFisico(estadoFisico);
		this.setCondicionActual(condicionActual);
	}
	
	public Ejemplar(Libro libro, int estadoFisico){
		
		this.setLibro(libro);
		this.setIsbn(this.getLibro().getIsbn());
		this.setEstadoFisico(estadoFisico);
		this.setFechaIngreso(new Date());
		this.setId((Ejemplar.getConsecutivo()+1));
		this.setTransacciones(new ArrayList<Transaccion>());
		this.getTransacciones().add(new MultiTransaccion().crear(null, this, 0, "Entrada del libro"));
		Ejemplar.setConsecutivo(Ejemplar.getConsecutivo()+1);
		
	}
	
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEstadoFisico() {
		return estadoFisico;
	}
	public void setEstadoFisico(int estadoFisico) {
		this.estadoFisico = estadoFisico;
	}
	public int getCondicionActual() {
		return condicionActual;
	}
	public void setCondicionActual(int condicionActual) {
		this.condicionActual = condicionActual;
	}

	private static int getConsecutivo() {
		return consecutivo;
	}

	private static void setConsecutivo(int consecutivo) {
		Ejemplar.consecutivo = consecutivo;
	}

	public ArrayList<Transaccion> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(ArrayList<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String string) {
		this.isbn = string;
	}
	
	
	
}
