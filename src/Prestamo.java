import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

class Prestamo {

	private static int maxDias = 15;
	private static int consecutivo = 0;
	private Date fechaPrestamo;
	private int id;
	private int cantDias;
	private int idUsario;
	private int idEjemplar;
	private int idTransaccion;
	private Usuario user;
	private Ejemplar ejemp;
	private Transaccion trans;
	private int activo;
	
	public Prestamo(Usuario u, Ejemplar e, int numDias){
		
		Transaccion t;
		
		this.setUser(u);
		this.setEjemp(e);
		this.setCantDias(numDias);
		this.setIdUsario(u.getId());
		this.setIdEjemplar(e.getId());
		this.setId(Prestamo.getConsecutivo()+1);
		this.setFechaPrestamo(new Date());
		t = (new MultiTransaccion()).crear(this.getUser(), this.getEjemp(), 1, "Prestamo");
		this.setTrans(t);
		this.setIdTransaccion(t.getId());
		this.setActivo(1);
		
	}
	
	public Prestamo(Date fecha, int id, int cDias, int idU, int idE, int idT, int activo){
		
		this.setFechaPrestamo(fecha);
		this.setId(id);
		this.setCantDias(cDias);
		this.setIdUsario(idU);
		this.setIdEjemplar(idE);
		this.setIdTransaccion(idT);
		this.setActivo(activo);
		
	}
	
	public String concluirPrestamo() throws SQLException, Exception{
		
		String msj = "Prestamo concluido a tiempo";
		
		this.setActivo(0);
		if((new Date()).after(this.calcularFechaDevolucion())){
			
			msj = "Prestamo concluido"+"\n"
					+ "Multa: "+this.aplicarMulta()+" colones";
					
		}
		
		return msj;
		
	}
	
	public double aplicarMulta() throws SQLException, Exception{
		
		double costo;
		Multa m;
		
		m = (new MultiMulta()).crear(this.getUser());
		costo = m.calcularMulta(this.calcularFechaDevolucion());
		
		return costo;
		
	}
	
	public Date calcularFechaDevolucion(){
		
		Calendar c = Calendar.getInstance();
		Date devolucion;
		
		c.setTime(this.getFechaPrestamo()); // Now use today date.
		c.add(Calendar.DATE, this.getCantDias()); // Adding 5 days
		devolucion = c.getTime();
		
		return devolucion;
		
	}
	
	public static int getMaxDias() {
		return maxDias;
	}
	public static void setMaxDias(int maxDias) {
		Prestamo.maxDias = maxDias;
	}
	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}
	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCantDias() {
		return cantDias;
	}
	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}
	public int getIdUsario() {
		return idUsario;
	}
	public void setIdUsario(int idUsario) {
		this.idUsario = idUsario;
	}
	public int getIdEjemplar() {
		return idEjemplar;
	}
	public void setIdEjemplar(int idEjemplar) {
		this.idEjemplar = idEjemplar;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public Ejemplar getEjemp() {
		Ejemplar e;
		
		e = (new MultiEjemplar()).buscar(this.getIdEjemplar());
		
		return e;
	}
	public void setEjemp(Ejemplar ejemp) {
		this.ejemp = ejemp;
	}

	public static int getConsecutivo() {
		return consecutivo;
	}

	public static void setConsecutivo(int consecutivo) {
		Prestamo.consecutivo = consecutivo;
	}

	public int getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(int idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public Transaccion getTrans() {
		return trans;
	}

	public void setTrans(Transaccion trans) {
		this.trans = trans;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}
	
	
	
}
