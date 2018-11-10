package src;

public class Mago extends Clase
{
	public Mago()
	{
		crearClase();
	}

	public void crearClase()
	{
		super.armadura = 10;
		setNombre("Mago");
	}

	public void ataque(Personaje enemigo, Personaje yo)
	{
		int dmg = Juego.lanzarDados(6);
		int evade = 0;
		if(enemigo.getClase().getDefiende() == true)
		{
			evade = Juego.lanzarDados(20);
			int nEvade = Juego.lanzarDados(20);
			if(nEvade > evade) evade = nEvade;
		}
		else evade = Juego.lanzarDados(20);

		if(evade + enemigo.getRaza().getDestreza() >= 13) { dmg /= 2; }
		enemigo.setVida(enemigo.getVida() - dmg);
	}

	public void defender()
	{
		setDefiende(true);
	}
}
