import java.util.TreeMap;

public class UI {

	public static void main(String[] args) throws Exception {
		
		TreeMap u = new TreeMap();
		Gestor g = new Gestor();
		String msj;
		
		msj = g.devolverEjemplar(3, 6);
		
		System.out.println(msj);

	}

}
