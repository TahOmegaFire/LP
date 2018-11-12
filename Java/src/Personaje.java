package src;

public interface Personaje
{
	/*****
	* void asignarRaza(Raza raza)
	******
	* Asigna una raza al personaje.
	******
	* Input:
	*		Raza : Recibe un objeto Raza.
	*****/
	public void asignarRaza(Raza raza);
	/*****
	* void asignarClase(Clase clase)
	******
	* Asigna una clase al personaje.
	******
	* Input:
	*		Clase : Recibe un objeto clase.
	*****/
	public void asignarClase(Clase clase);
	/*****
	* void asignarVida()
	******
	* Le asigna vida al personaje.
	******
	*****/
	public void asignarVida();
	/*****
	* void asignarNombre(String nombre)
	******
	* Le asigna un nombre al Personaje.
	******
	* Input:
	*	String : Recibe un string.
	*****/
	public void asignarNombre(String nombre);
	/*****
	* int getVida()
	******
	* Retorna el valor del atributo Vida.
	******
	* Output:
	*	int : Devuelve un entero.
	*****/
	public int getVida();
	/*****
	* void setVida(int vida)
	******
	* Inicia la vida del Personaje con una vida dada.
	******
	* Input:
	*	int : Recibe un entero.
	*****/
	public void setVida(int vida);
	/*****
	* Clase getClase()
	******
	* Obtiene el objeto clase del Personaje.
	******
	* Output:
	*	Clase : Retorna la referencia del objeto Clase.
	*****/
	public Clase getClase();
	/*****
	* Raza getRaza()
	******
	* Obtiene el objeto raza del Personaje.
	******
	* Output:
	*	Raza : Retorna la referencia del objeto Raza.
	*****/
	public Raza getRaza();
	/*****
	* String getNombre()
	******
	* Retorna el nombre del Personake.
	******
	* Output:
	*	String : Retorna el Nombre del Personaje.
	*****/
	public String getNombre();
}
