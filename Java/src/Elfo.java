package src;

public class Elfo extends Raza
{
	public Elfo()
	{
		crearRaza();
	}

	public void crearRaza()
	{
		super.fuerza = 0;
		super.destreza = 2;
		super.constitucion = 1;
		setNombre("Elfo");
	}

	public void Habilidad(Personaje personaje)
	{

	}
	public int Habilidad(int n){
		n += 2;
		return n;
	}
}
