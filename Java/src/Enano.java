package juego;

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
	}

	public int Habilidad(int vida)
	{
		return vida + 1;
	}
}
