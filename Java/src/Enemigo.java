package src;
public class Enemigo implements Personaje {
	Clase clase;
	Raza raza;
	String nombre;

	int vida;

	public Enemigo(String nombre, Raza raza, Clase clase)
	{
		asignarNombre(nombre);
		asignarClase(clase);
		asignarRaza(raza);
		asignarVida();
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
		vida = 8 + raza.getConstitucion();
	}

	public void asignarNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public void ResetPersonaje() { asignarVida();}
	public int getVida() { return vida; }
	public Raza getRaza() { return raza; }
	public Clase getClase() { return clase; }
	public String getNombre() { return this.nombre; }
	public void setVida(int nVida) { this.vida = nVida; }
}
