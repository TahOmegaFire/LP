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
		setNombre("Barbaro");
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

		if(hit + yo.getRaza().getFuerza() >= enemigo.getClase().getArmadura()) { enemigo.setVida(enemigo.getVida() - dmg); System.out.print("La hacha ha hecho "+dmg+" puntos de daño!"); }
		else { System.out.print("La hacha ha fallado!"); }
	}

	public void defender()
	{
		defiende = true;
	}
}
