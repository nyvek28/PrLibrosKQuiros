import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class MultiMulta {

	public Multa crear(Usuario u)throws	java.sql.SQLException,Exception{
		
		Multa da = null;
		return da;
	}
	
	// recibe codigo para realizar la busqueda
	public Multa buscar()throws java.sql.SQLException,Exception{
		
		Multa da = null;
		return da;
		
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
