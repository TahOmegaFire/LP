package src;

public class Clerigo extends Clase
{
	public Clerigo()
	{
		crearClase();
	}

	public void crearClase()
	{
		super.armadura = 15;
		setNombre("Clerigo");
	}

	public void ataque(Personaje enemigo,Personaje yo)
	{
		if (yo.getRaza().getNombre().equals("Enano")) {
			yo.getRaza().Habilidad(yo);
			System.out.print("\n"+yo.getNombre()+" activa su habilidad racial de "+yo.getRaza().getNombre()+" y se regenera 1 punto de vida");
		}
		int dmg = Juego.lanzarDados(6);
		int evade = 0;
		if(enemigo.getClase().getDefiende() == true)
		{
			evade = Juego.lanzarDados(20);
			System.out.print("\n"+enemigo.getNombre()+" obtiene un resistir de :"+evade);
			int nEvade = Juego.lanzarDados(20);
			System.out.print("\n"+enemigo.getNombre()+" obtiene un resistir de :"+nEvade);
			if(nEvade > evade) evade = nEvade;
			System.out.print("\n"+enemigo.getNombre()+" finalmente obtiene un resistir de :"+evade);
		}
		else {
			evade = Juego.lanzarDados(20);
			System.out.print("\n"+enemigo.getNombre()+" finalmente obtiene un resistir de :"+evade);
		}
		System.out.print("\n"+yo.getNombre()+" invoca a la luz sagrada para realizar un daño de :"+dmg);
		if (evade == 20) {
			System.out.print("\n"+enemigo.getNombre()+" ha evadido completamente el ataque");
		} else{
			if (enemigo.getRaza().getNombre().equals("Humano")) {
				if (evade == 1) {
					System.out.print("\n"+enemigo.getNombre()+" activa su habilidad racial de "+enemigo.getRaza().getNombre());
					evade = enemigo.getRaza().Habilidad(evade);
				}
			} else {
				if (enemigo.getRaza().getNombre().equals("Elfo")) {
					System.out.print("\n"+enemigo.getNombre()+" activa su habilidad racial de "+enemigo.getRaza().getNombre()+" y obtiene un +2");
					evade = enemigo.getRaza().Habilidad(evade);
				}
			}
			System.out.print("\n"+enemigo.getNombre()+" con destreza :"+enemigo.getRaza().getDestreza()+" finalmente resiste con :"+ (evade + enemigo.getRaza().getDestreza()));
			if(evade + enemigo.getRaza().getConstitucion() >= 13) {
				dmg /= 2;
				System.out.print("\n"+enemigo.getNombre()+" reduce a la mitad el daño total");
			}

			enemigo.setVida(enemigo.getVida() - dmg);
			System.out.print("\nEl hechizo ha hecho "+dmg+" puntos de daño!");
		}
	}

	public void defender()
	{
		setDefiende(true);
	}
}
