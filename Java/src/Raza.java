package src;

public abstract class Raza
{
	int fuerza;
	int destreza;
	int constitucion;
	String nombre;
	/*****
	****Constructor
	*****/
	public Raza()
	{
		this.fuerza = 0;
		this.destreza = 0;
		this.constitucion = 0;
	}
	/*****
	* void crearRaza()
	******
	* Inicializa las variables del padre.
	******
	*****/
	public abstract void crearRaza();
	/*****
	* void Habilidad(Personaje personaje)
	******
	*	Recibe el objeto personaje y le cambia el atributo vida.
	******
	* Input:
	*		Personaje personaje: Recibe un objeto Personaje.
	*****/
	public abstract void Habilidad(Personaje personaje);
	/*****
	* int Habilidad(int n)
	******
	* Recibe un valor entero y devuelve le retorna el valor aumentado en 2.
	******
	* Input:
	*		int n: Recibe un valor entero.
	* Output:
	*		int : Devuelve un valor entero.
	*****/
	public abstract int Habilidad(int n);
	/*****
	* int getFuerza()
	******
	* Retorna el valor del atributo Fuerza.
	******
	* Output:
	*		int : Devuelve un valor entero.
	*****/
	public int getFuerza() { return fuerza; }
	/*****
	* int Destreza()
	******
	* Retorna el valor del atributo Destreza.
	******
	* Output:
	*		int : Devuelve un valor entero.
	*****/
	public int getDestreza() { return destreza; }
	/*****
	* int getConstitucion()
	******
	* Retorna el valor del atributo Constitucion.
	******
	* Output:
	*		int : Devuelve un valor entero.
	*****/
	public int getConstitucion() { return constitucion; }
	/*****
	* String getNombre()
	******
	* Retorna el nombre de la Raza.
	******
	* Output:
	*		String : Devuelve un string.
	*****/
	public String getNombre() { return nombre; }
	/*****
	* void setFuerza(int nFuerza)
	******
	* Cambia el valor del atributo Fuerza en el objeto en donde fue llamado.
	******
	* Input:
	*		int : Recibe un valor entero.
	*****/
	public void setFuerza(int nFuerza) { this.fuerza = nFuerza; }
	/*****
	* void setDestreza(int nDestreza)
	******
	* Cambia el valor del atributo Destreza en el objeto en donde fue llamado.
	******
	* Input:
	*		int : Recibe un valor entero.
	*****/
	public void setDestreza(int nDestreza) { this.destreza = nDestreza; }
	/*****
	* void setConstitucion(int nConstitucion)
	******
	* Cambia el valor del atributo Constitucion en el objeto en donde fue llamado.
	******
	* Input:
	*		int : Recibe un valor entero.
	*****/
	public void setConstitucion(int nConstitucion) { this.constitucion = nConstitucion; }
	/*****
	* void setNombre(String nNombre)
	******
	* Cambia el valor del atributo Nombre en el objeto en donde fue llamado.
	******
	* Input:
	*		String : Recibe un valor string.
	*****/
	public void setNombre(String nNombre) { this.nombre = nNombre; }
}
