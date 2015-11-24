import java.util.ArrayList;
public class Libro {
	
	private String isbn;
	private String titulo;
    private String volumen;
    private String editorial;
    private String fecha;
    private ArrayList<Autor> listaAutores;
    private ArrayList<DescriptorAsociado> listaDescriptores;
    private ArrayList<Ejemplar> listaEjemplares;
    static int consecutivo = 0;


	public Libro(String ptitulo,String pvolumen, String peditorial, String pfecha,ArrayList<Autor> plistaAutores,ArrayList<DescriptorAsociado> plistaDescriptores,ArrayList<Ejemplar> plistaEjemplares){
        
		setConsecutivo(getConsecutivo() + 1);
        this.setIsbn(Integer.toString(getConsecutivo()));
        this.setTitulo(ptitulo);
        this.setVolumen(pvolumen);
        this.setEditorial(peditorial);
        this.setFecha(pfecha);
        this.setListaAutores(plistaAutores);
        this.setListaDescriptores(listaDescriptores);
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
		Libro.consecutivo = consecutivo;
	}
	
    /**
	 * @return the listaEjemplares
	 */
	public ArrayList<Ejemplar> getListaEjemplares() {
		return listaEjemplares;
	}

	/**
	 * @param listaEjemplares the listaEjemplares to set
	 */
	public void setListaEjemplares(ArrayList<Ejemplar> listaEjemplares) {
		this.listaEjemplares = listaEjemplares;
	}

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = "lib-" +  isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Autor> getListaAutores() {
        return listaAutores;
    }

    public void setListaAutores(ArrayList<Autor> plistaAutores) {
        this.listaAutores = plistaAutores;
    }

    public ArrayList<DescriptorAsociado> getListaDescriptores() {
        return listaDescriptores;
    }

    public void setListaDescriptores(ArrayList<DescriptorAsociado> listaDescriptores) {
        this.listaDescriptores = listaDescriptores;
    }

    public String toString(){
    	
    	String x = "";
    	return x;
    }
}
