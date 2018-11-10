package juego;

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

		if(hit + this.destreza >= enemigo.clase.getArmadura()) { enemigo.setVida(enemigo.getVida() - dmg); }
	}

	public void defender()
	{
		defiende = true;
	}
}
