import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class MultiTransaccion {

	public Transaccion crear(Usuario u, Ejemplar e, int pTipo, String pDesccripcion){
		
		return null;
	}
	
	public Transaccion buscar(int id){
		return null;
	}
	
	public ResultSet buscar(String nombre){
		return null;
	}
	
	public void actualizar(Transaccion t){
		
	}
	
	public void borrar(Transaccion t){
		
	}
	
	public String fechaToString(Date fecha){
		
		String msj;
		
		msj = fecha.toString();
		
		return msj;
		
	}
	
	public Date fechaToDate(String texto) throws ParseException{		
		Date fecha;
		
		DateFormat formatter = new SimpleDateFormat("d-MMM-yyyy,HH:mm:ss aaa");
		fecha = formatter.parse(texto);
		
		return fecha;
		
	}
	
}
