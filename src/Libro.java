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


	public Libro(String pisbn,String ptitulo,String pvolumen, String peditorial, String pfecha,ArrayList<Autor> plistaAutores,ArrayList<DescriptorAsociado> plistaDescriptores,ArrayList<Ejemplar> plistaEjemplares){
        
		
        this.setIsbn(pisbn);
        this.setTitulo(ptitulo);
        this.setVolumen(pvolumen);
        this.setEditorial(peditorial);
        this.setFecha(pfecha);
        this.setListaAutores(plistaAutores);
        this.setListaDescriptores(listaDescriptores);
    }
	
	public Libro(String isbn, String titulo, String volumen, String editorial, String fecha){
		
		this.setIsbn(isbn);
		this.setTitulo(titulo);
		this.setVolumen(volumen);
		this.setEditorial(editorial);
		this.setFecha(fecha);
		
	}
	
	public String registrarEjemplar(int estadoFisico){
		
		String msj;
		Ejemplar e;
		
		try{
			e = (new MultiEjemplar()).crear(this, estadoFisico);
			msj = "Se ha registrado el ejemplar codigo " +e.getId() +" de libro "+e.getLibro().getTitulo();
		}catch(Exception s){
			msj = "Ocurrio un error al intentar registrar este ejemplar, porfavor intentelo de nuevo";
		}
		
		return msj;
		
	}
    
	/**
	
	
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
