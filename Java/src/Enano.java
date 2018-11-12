package src;

public class Enano extends Raza
{
	public Enano()
	{
		crearRaza();
	}

	public void crearRaza()
	{
		super.fuerza = 1;
		super.destreza = 0;
		super.constitucion = 2;
		setNombre("Enano");
	}

	public void Habilidad(Personaje personaje)
	{
		personaje.setVida(personaje.getVida()+1);
	}
	public int Habilidad (int n)
	{
		return n;
	}
}
