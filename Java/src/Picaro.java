package src;

public class Picaro extends Clase
{
	public Picaro()
	{
		crearClase();
	}

	public void crearClase()
	{
		super.armadura = 10;
	}

	public void ataque(Personaje enemigo, Personaje yo)
	{
		int dmg = Juego.lanzarDados(8);
		int hit = 0;
		if(enemigo.getClase().getDefiende() == true)
		{
			hit = Juego.lanzarDados(20);
			int nHit = Juego.lanzarDados(20);
			if(nHit < hit) hit = nHit;
		}
		else hit = Juego.lanzarDados(20);

		if(hit + yo.getRaza().getDestreza() >= enemigo.getClase().getArmadura()) { enemigo.setVida(enemigo.getVida() - dmg); }
	}

	public void defender()
	{
		defiende = true;
	}
}