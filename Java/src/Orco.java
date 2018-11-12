package src;

public class Orco extends Raza
{
	public Orco()
	{
		crearRaza();
	}
	public void crearRaza()
	{
		super.fuerza = 2;
		super.destreza = 0;
		super.constitucion = 1;
		setNombre("Orco");
	}

	public void Habilidad(Personaje personaje);
	public int Habilidad(int n){
		n += 2;
		return n;
	}
}
