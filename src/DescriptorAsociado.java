
public class DescriptorAsociado {
	
	private int codigo;
    private String descripcion;
    static int consecutivo = 0;
    
    
	public DescriptorAsociado(String pdescripcion){
		
		setConsecutivo(getConsecutivo() + 1);
		this.setCodigo(getConsecutivo());
        this.setDescripcion(pdescripcion);
        
    }
	
	/**
	 * @return the consecutivo
	 */
	public static int getConsecutivo() {
		return consecutivo;
	}
	/**
	 * @param consecutivo the consecutivo to set
	 */
	public static void setConsecutivo(int consecutivo) {
		DescriptorAsociado.consecutivo = consecutivo;
	}
	
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
