package src;
import java.util.Random;
import java.util.List;
import java.util.Scanner;

public class Juego
{
	static Random rObj = new Random();
	static Scanner inp = new Scanner(System.in);

	public static int lanzarDados(int caras)
	{
		return rObj.nextInt(caras) + 1;
	}

	public static void main(String[] args)
	{
		System.out.print("Bienvenido a Dunyons & Doragons XVI! Elige un nombre para tu personaje\n");
		String nombre = inp.next();
		int sel = 0;
		while(true)
		{
			System.out.print("\n\nElige tu clase escribiendo el numero correspondiente:\n1.- Barbaro     2.- Picaro\n3.- Mago        4.- Clerigo\n");
	   		sel = inp.nextInt();
			if(sel > 0 && sel < 5) break;
		}

		Clase clase = null;
		switch(sel)
		{
			case 1:
				clase = new src.Barbaro();
				break;
			case 2:
				clase = new src.Picaro();
				break;
			case 3:
				clase = new src.Mago();
				break;
			case 4:
				clase = new src.Clerigo();
				break;
			default:
				break;
		}

		sel = 0;

		while(true)
		{
			System.out.print("\n\nElige tu raza escribiendo el numero correspondiente:\n1.- Humano     2.- Elfo\n3.- Enano        4.- Orco\n");
	   		sel = inp.nextInt();
			if(sel > 0 && sel < 5) break;
		}

		Raza raza = null;
		switch(sel)
		{
			case 1:
				raza = new src.Humano();
				break;
			case 2:
				raza = new src.Elfo();
				break;
			case 3:
				raza = new src.Enano();
				break;
			case 4:
				raza = new src.Orco();
				break;
			default:
				break;
		}

		Jugador jugador = new Jugador(nombre, raza, clase);
		Enemigo enemigo = null;
		for(int i=0; i<3;){
			int n = lanzarDados(6); // Obtiene un numero al azar para elegir un contrincante
			switch(n)
			{
				case 1:
					enemigo = new Enemigo("Klrak", new src.Enano(), new src.Barbaro());
					break;
				case 2:
					enemigo = new Enemigo("Adran", new src.Elfo(), new src.Picaro());
					break;
				case 3:
					enemigo = new Enemigo("Isaac", new src.Humano(), new src.Clerigo());
					break;
				case 4:
					enemigo = new Enemigo("Elysium", new src.Elfo(), new src.Mago());
					break;
				case 5:
					enemigo = new Enemigo("Krrogh", new src.Orco(), new src.Barbaro());
					break;
				case 6:
					enemigo = new Enemigo("Jenkins", new src.Humano(), new src.Mago());
					break;
				default:
					break;
			}
			while(jugador.getVida() > 0 || enemigo.getVida() > 0)
			{
				jugador.getClase().setDefiende(false);
				System.out.print("\n\nElige tu accion:\n1.- Atacar    2.- Defender\n");
				sel = 0;
				while(sel == 0)
				{
					sel = inp.nextInt();
					if(sel != 1 && sel != 2)
					{
						System.out.print("\nEleccion no valida\n");
						sel = 0;
					}
				}
				System.out.print("\n\n"+jugador.getNombre()+": "+jugador.getVida()+"     "+enemigo.getNombre()+": "+enemigo.getVida());
				if(sel == 1){
					jugador.getClase().ataque(enemigo, jugador);
					System.out.print("\n\n "+jugador.getNombre()+ " se prepara para Atacar!!");
				}
				else{
					jugador.getClase().setDefiende(true);
					System.out.print("\n\n "+jugador.getNombre()+ " se prepara para Defender!");
				}
				enemigo.getClase().setDefiende(false);
				sel = lanzarDados(2);
				System.out.print("\n\n"+jugador.getNombre()+": "+jugador.getVida()+"     "+enemigo.getNombre()+": "+enemigo.getVida());
				if(sel == 1){
					enemigo.getClase().ataque(jugador, enemigo);
					System.out.print("\n\n "+enemigo.getNombre()+ " se prepara para Atacar!!");
				}
				else{
					enemigo.getClase().setDefiende(true);
					System.out.print("\n\n "+enemigo.getNombre()+ " se prepara para Defender!");
				}
				System.out.print("\n\n"+jugador.getNombre()+": "+jugador.getVida()+"     "+enemigo.getNombre()+": "+enemigo.getVida());

			}

			if(jugador.getVida() < 0)
			{
				System.out.print("\n\nLa cuerda de la profecia ha sido cortado, y con ella tu vida. F\n");
				break;
			}

			else
			{
				if(i < 2)
				{
					System.out.print("\n\nTu enemigo fue eliminado. Preparate para el siguiente encuentro\n");
					++i;
				}

				else
					System.out.print("\n\nTodos tus enemigos han sido vencidos. Has encontrado la fuente de la eterna subscripcion a RuneScape\n");

			}
		}
	}
}
