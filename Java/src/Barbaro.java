package juego;

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
		if(enemigo.clase.getDefiende == true)
		{
			hit = Juego.lanzarDados(20);
			nHit = Juego.lanzarDados(20);
			if(nHit < hit) hit = nHit;
		}
		else hit = Juego.lanzarDados(20);

		if(hit + this.fuerza >= enemigo.clase.getArmadura()) { enemigo.setVida(enemigo.getVida() - dmg); }
	}

	public void defender()
	{
		defiende = true;
	}
}
