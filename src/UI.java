import java.util.TreeMap;

public class UI {

	public static void main(String[] args) {
		
		TreeMap u = new TreeMap();
		Gestor g = new Gestor();
		
		u = g.consultarUsuario(1);
		
		System.out.println(u.get("nombre"));

	}

}
