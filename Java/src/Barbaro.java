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
		if (yo.getRaza().getNombre().equals("Enano")) {
			yo.getRaza().Habilidad(yo);
			System.out.print("\n"+yo.getNombre()+" activa su habilidad racial de "+yo.getRaza().getNombre()+" y se regenera 1 punto de vida");
		}
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
		if (yo.getRaza().getNombre().equals("Humano")) {
			if (hit == 1) {
				System.out.print("\n"+yo.getNombre()+" activa su habilidad racial de "+yo.getRaza().getNombre());
				hit = yo.getRaza().Habilidad(hit);
			}
		} else {
			if (yo.getRaza().getNombre().equals("Orco")) {
				System.out.print("\n"+yo.getNombre()+" activa su habilidad racial de "+yo.getRaza().getNombre()+" y obtiene un +2");
				hit = yo.getRaza().Habilidad(hit);
			}
		}
		System.out.print("\nCon un acierto de "+hit+" y fuerza de "+yo.getRaza().getFuerza()+", "+yo.getNombre()+" ataca a "+enemigo.getNombre()+" con una armadura de :"+enemigo.getClase().getArmadura());
		if(hit + yo.getRaza().getFuerza() >= enemigo.getClase().getArmadura()) { enemigo.setVida(enemigo.getVida() - dmg); System.out.print("\n"+yo.getNombre()+" ha hecho "+dmg+" puntos de daño!"); }
		else { System.out.print("\nEl ataque ha fallado!"); }
	}

	public void defender()
	{
		defiende = true;
	}
}
