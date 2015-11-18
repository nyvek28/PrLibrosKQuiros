
public class Autor {
	

			
			private String nombre;
			private String apellido;
			private String id;
			private String email;
			private String nacionalidad;
			private String paisOrigen;
			public Libro[] listaLibros;
			private static int contadorLibros=0;
			
			public Autor(String pnombre, String papellido, String pid, String pemail, String pnacionalidad, String ppaisOrigen){
				setNombre(pnombre);
				setApellido(papellido);
				setId(pid);
				setEmail(pemail);
				setNacionalidad(pnacionalidad);
				setPaisOrigen(ppaisOrigen);
			}
			public void agregarLibro(Libro plibro){
				listaLibros[contadorLibros]=plibro;
				contadorLibros++;
			}
			public void setNombre(String pnombre){
				nombre=pnombre;
			}
			public void setApellido(String papellido){
				apellido=papellido;
			}
			public void setId(String pid){
				id=pid;
			}
			public void setEmail(String pemail){
				email=pemail;
			}
			public	 void setNacionalidad(String pnacionalidad){
				nacionalidad=pnacionalidad;
			}
			private void setPaisOrigen(String ppaisOrigen){
				paisOrigen=ppaisOrigen;
			}
			public String getNombre(){
				return nombre;
			}
			public String getApellido(){
				return apellido;
			}
			public String getId(){
				return id;
			}
			public String getEmail(){
				return email;
			}
			public String getNacionalidad(){
				return nacionalidad;
			}
			public String getPaisOrigen(){
				return paisOrigen;
			}
}
