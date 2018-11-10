package src;

public abstract class Raza
{
	int fuerza;
	int destreza;
	int constitucion;
	String nombre;

	public Raza()
	{
		this.fuerza = 0;
		this.destreza = 0;
		this.constitucion = 0;
	}

	public abstract void crearRaza();

	public abstract void Habilidad();

	public int getFuerza() { return fuerza; }
	public int getDestreza() { return destreza; }
	public int getConstitucion() { return constitucion; }
	public String getNombre() { return nombre; }

	public void setFuerza(int nFuerza) { this.fuerza = nFuerza; }
	public void setDestreza(int nDestreza) { this.destreza = nDestreza; }
	public void setConstitucion(int nConstitucion) { this.constitucion = nConstitucion; }
	public void setNombre(String nNombre) { this.nombre = nNombre; }
}
