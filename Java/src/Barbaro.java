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
			System.out.print("\n"+yo.getNombre()+" obtiene un acierto de :"+hit);
			int nHit = Juego.lanzarDados(20);
			System.out.print("\n"+yo.getNombre()+" obtiene un acierto de :"+nHit);
			if(nHit < hit) hit = nHit;
			System.out.print("\n"+yo.getNombre()+" finalmente obtiene un acierto de :"+hit);
		}
		else {
			hit = Juego.lanzarDados(20);
			System.out.print("\n"+yo.getNombre()+" finalmente obtiene un acierto de :"+hit);
		}
		System.out.print("\n"+yo.getNombre()+" prepara su hacha para realizar un daño de :"+dmg);
		if (hit == 20){
			dmg *=2;
			System.out.print("\n"+yo.getNombre()+" se prepara para realizar un critico");
		}
		System.out.print("\nCon un acierto de "+hit+", "+yo.getNombre()+" ataca a "+enemigo.getNombre()+" con una armadura de :"+enemigo.getClase().getArmadura());
		if(hit + yo.getRaza().getFuerza() >= enemigo.getClase().getArmadura()) { enemigo.setVida(enemigo.getVida() - dmg); System.out.print("\n"+yo.getNombre()+" ha hecho "+dmg+" puntos de daño!"); }
		else { System.out.print("\nEl ataque ha fallado!"); }
	}

	public void defender()
	{
		defiende = true;
	}
}
