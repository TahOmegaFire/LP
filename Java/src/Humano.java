package src;

public class Humano extends Raza
{
	public Humano()
	{
		crearRaza();
	}

	public void crearRaza()
	{
		super.fuerza = 1;
		super.destreza = 1;
		super.constitucion = 1;
		setNombre("Humano");
	}

	public void Habilidad(Personaje personaje)
	{

	}
	public int Habilidad(int n){
		while (n==1) {
			n=Juego.lanzarDados(20);
		}
		return n;
	}
}
