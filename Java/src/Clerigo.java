package juego;

public class Clerigo extends Clase
{
	public Clerigo()
	{
		crearClase();
	}

	public void crearClase()
	{
		super.armadura = 15;
	}

	public void ataque(Personaje enemigo)
	{
		int dmg = Juego.lanzarDados(6);
		int evade = 0;
		if(enemigo.clase.getDefiende() == true)
		{
			evade = Juego.lanzarDados(20);
			nEvade = Juego.lanzarDados(20);
			if(nEvade > evade) evade = nEvade;
		}
		else evade = Juego.lanzarDados(20);

		if(evade + enemigo.getConstitucion() >= 13) { dmg /= 2; }
		enemigo.setVida(enemigo.getVida() - dmg);
	}

	public void defender()
	{
		setDefiende(true);
	}
}
