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
		setNombre("Picaro");
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
		System.out.print("\n"+yo.getNombre()+" prepara su daga envenenada para realizar un daño de :"+dmg);
		if (hit == 20) {
			dmg *=2;
			System.out.print("\n"+yo.getNombre()+" se prepara para realizar un critico");
		}
		System.out.print("\nCon un acierto de "+hit+", "+yo.getNombre()+" ataca a "+enemigo.getNombre()+" con una armadura de :"+enemigo.getClase().getArmadura());
		if(hit + yo.getRaza().getDestreza() >= enemigo.getClase().getArmadura()) { enemigo.setVida(enemigo.getVida() - dmg); System.out.print("\nLa daga ha hecho "+dmg+" puntos de daño!"); }
		else {
			System.out.print("\nLa daga ha fallado su objetivo!");
		}
	}

	public void defender()
	{
		defiende = true;
	}
}
