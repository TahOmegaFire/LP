package juego;

public abstract class Jugador implements Personaje
{
	Clase clase;
	Raza raza;
	String nombre;

	int vida;
	
	public void Jugador(String nombre, Raza raza, Clase clase)
	{
		this.nombre = nombre;
		this.raza = raza;
		this.clase = clase;

		this.clase.crearClase();
		this.raza.crearRaza();
	}

	public void asignarRaza(Raza raza)
	{
		this.raza = raza;
		raza.crearRaza();
	}

	public void asignarClase(Clase clase)
	{
		this.clase = clase;
		clase.crearClase();
	}

	public void asignarVida()
	{
		vida = 10 + raza.getConstitucion();
	}

	public void asignarNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public int getVida() { return vida; }

	public void setVida(int nVida) { this.vida = nVida; }


}
