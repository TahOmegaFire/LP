package src;

public class Barbaro extends Clase
{
	public Barbaro()
	{
		crearClase();
	}

	public void crearClase()
	{
		super.armadura = 15;
	}

	public void ataque(Personaje enemigo)
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

		if(hit + this.fuerza >= enemigo.getClase().getArmadura()) { enemigo.setVida(enemigo.getVida() - dmg); }
	}

	public void defender()
	{
		defiende = true;
	}
}
