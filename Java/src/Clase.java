package src;

public abstract class Clase
{
	int armadura;
	boolean defiende;
	String nombre;

	public Clase()
	{
		this.armadura = 0;
	}
	/*****
	* void crearClase()
	******
	* Crea una clase.
	******
	*****/
	public abstract void crearClase();
	/*****
	* void ataque(Personaje enemigo, Personaje yo)
	******
	* El personaje yo ataca al personaje enemigo, es decir el personaje enemigo pierde una cantidad de vida equivalente al daño del personaje yo.
	******
	* Input:
	*	Personaje enemigo : Personaje atacado, el que va a perder vida.
	* Personaje yo : Personaje atacante.
	*****/
	public abstract void ataque(Personaje enemigo, Personaje yo);
	/*****
	* void defender()
	******
	* Se cambia de estado el atributo defiende, ya sea defendiendo o atacando.
	******
	*****/
	public abstract void defender();
	/*****
	* int getArmadura()
	******
	* Obtiene el valor de la armadura.
	******
	*	Output :
	* int : Retorna un entero que representa a la armadura.
	*****/
	public int getArmadura() { return armadura; }
	/*****
	* boolean getDefiende()
	******
	* Obtiene el valor del estado, True o False.
	******
	* Output :
	*	boolean : Si esta defendiendo se retorna true, si no esta defendiendo retorna false
	*****/
	public boolean getDefiende() { return defiende; }
	/*****
	* String getNombre()
	******
	* Obtiene el nombre de la clase.
	******
	* Output :
	*	String : Nombre de la Clase.
	*****/
	public String getNombre() { return nombre; }
	/*****
	* void setArmadura(int nArmadura)
	******
	* Fija el valor del atributo Armadura.
	******
	* Input :
	*	int Armadura : Entero que representa el valor de la armadura.
	*****/
	public void setArmadura(int nArmadura) { this.armadura = nArmadura; }
	/*****
	* void setDefiende(boolean nDefiende)
	******
	* Fija el valor del atributo Defiende.
	******
	* Input :
	*	boolean nDefiende : Booleano que representa el estado en el que esta el personaje, true defiende y false no defiende.
	*****/
	public void setDefiende(boolean nDefiende) { this.defiende = nDefiende; }
	/*****
	* void setNombre(String nNombre)
	******
	* Fija el valor del atributo nombre de la clase.
	******
	* Input :
	*	String nNombre : Nombre de la clase.
	*****/
	public void setNombre(String nNombre) { this.nombre = nNombre; }
}
