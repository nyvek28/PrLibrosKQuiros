import java.util.Date;

class Multa {

	private static int consecutivo = 0;
	private static double costoPorDia = 1500;
	private int id;
	private Date fecha;
	private int idUsuario;
	private Usuario user;
	private int estado;
	private double montoTotal;
	
	public Multa(Usuario u){
		
		this.setId(Multa.getConsecutivo()+1);
		this.setFecha(new Date());
		this.setIdUsuario(u.getId());
		this.setUser(u);
		u.getMultas().add(this);
		setEstado(1);
		
	}
	public double getMontoTotal(){
		return montoTotal;
	}
	private void setMontoTotal(double pMontoTotal){
		montoTotal=pMontoTotal;
	}
	
	private double calcularCosto(long diasPasados){
		
		double monto;
		
		monto = Multa.getCostoPorDia()*diasPasados;
		setMontoTotal(monto);
		
		
		return monto;
		
	}
	public void cancelar(){
		setEstado(0);
	}
	
	public double calcularMulta(Date fechaDevolucion){
		
		long dias;
		double monto;
		
		dias = (Math.abs((new Date()).getTime() - fechaDevolucion.getTime()))/(24*60*60*1000);
		monto = this.calcularCosto(dias);
		
		return monto;
		
	}
	public void setEstado(int pestado){
		pestado=estado;
	}
	public int getEstado(){
		return estado;
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
