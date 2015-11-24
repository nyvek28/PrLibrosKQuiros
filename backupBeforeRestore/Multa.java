import java.util.Date;

class Multa {

	private static int consecutivo = 0;
	private static double costoPorDia = 1500;
	private int id;
	private Date fecha;
	private int idUsuario;
	private Usuario user;
	
	public Multa(Usuario u){
		
		this.setId(Multa.getConsecutivo()+1);
		this.setFecha(new Date());
		this.setIdUsuario(u.getId());
		this.setUser(u);
		u.getMultas().add(this);
		
	}
	
	private double calcularCosto(int cantDias){
		return 0;
	}
	
	public double calcularMulta(Date fechaDevolucion){
		this.calcularCosto(0);
		return 0;
	}
	
	public static int getConsecutivo() {
		return consecutivo;
	}
	public static void setConsecutivo(int consecutivo) {
		Multa.consecutivo = consecutivo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}

	public static double getCostoPorDia() {
		return costoPorDia;
	}

	public static void setCostoPorDia(double costoPorDia) {
		Multa.costoPorDia = costoPorDia;
	}
	
	
	
}
