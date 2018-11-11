package src;
import java.util.Random;
import java.util.ArrayList;
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
		System.out.print("\033[H\033[2J");
		System.out.flush();
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
		System.out.print("\033[H\033[2J");
		System.out.flush();
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
		List<Enemigo> enemigos = new ArrayList<Enemigo>();
		enemigos.add(new Enemigo("Klrak", new src.Enano(), new src.Barbaro()));
		enemigos.add(new Enemigo("Adran", new src.Elfo(), new src.Picaro()));
		enemigos.add(new Enemigo("Isaac", new src.Humano(), new src.Clerigo()));
		enemigos.add(new Enemigo("Elysium", new src.Elfo(), new src.Mago()));
		enemigos.add(new Enemigo("Krrogh", new src.Orco(), new src.Barbaro()));
		enemigos.add(new Enemigo("Jenkins", new src.Humano(), new src.Mago()));
		int n = lanzarDados(6); // Obtiene un numero al azar para elegir un contrincante
		Enemigo enemigo = (Enemigo) enemigos.get(n-1);
		System.out.print("\nEncontrando Contrincante...");
		System.out.print("\n\nEl "+jugador.getRaza().getNombre()+" "+jugador.getClase().getNombre()+" "+jugador.getNombre()+" se enfrentara a el "+enemigo.getRaza().getNombre()+" "+enemigo.getClase().getNombre()+" "+enemigo.getNombre());

		for(int i=0; i<3;){
			if(jugador.getVida() <= 0)
			{
				System.out.print("\n\nLa cuerda de la profecia ha sido cortado, y con ella tu vida. F\n");
				break;
			}
			else
			{
				if (enemigo.getVida() <= 0) {
					if(i < 2)
					{
						System.out.print("\n\nTu enemigo fue eliminado. Preparate para el siguiente encuentro\n");
						++i;
						n = lanzarDados(6); // Obtiene un numero al azar para elegir un contrincante
						enemigo = (Enemigo) enemigos.get(n-1);
						enemigo.ResetPersonaje();
						System.out.print("\n\nEncontrando Contrincante...");
						System.out.print("\nEl "+jugador.getRaza().getNombre()+" "+jugador.getClase().getNombre()+" "+jugador.getNombre()+" se enfrentara a el "+enemigo.getRaza().getNombre()+" "+enemigo.getClase().getNombre()+" "+enemigo.getNombre());
					}
					else
					{
						System.out.print("\n\nTodos tus enemigos han sido vencidos. Has encontrado la fuente de la eterna subscripcion a RuneScape\n");
						break;
					}
				}
			}
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
			System.out.print("\033[H\033[2J");
			System.out.flush();
			System.out.print("\n\n"+jugador.getNombre()+": "+jugador.getVida()+"     "+enemigo.getNombre()+": "+enemigo.getVida());
			if(sel == 1){
				System.out.print("\n\n "+jugador.getNombre()+ " se prepara para Atacar!!\n");
				jugador.getClase().ataque(enemigo, jugador);
			}
			else{
				System.out.print("\n\n "+jugador.getNombre()+ " se prepara para Defender!\n");
				jugador.getClase().setDefiende(true);
			}
			enemigo.getClase().setDefiende(false);
			if(enemigo.getVida()>0){
				sel = lanzarDados(2);
				System.out.print("\n\n"+jugador.getNombre()+": "+jugador.getVida()+"     "+enemigo.getNombre()+": "+enemigo.getVida());
				if(sel == 1){
					System.out.print("\n\n "+enemigo.getNombre()+ " se prepara para Atacar!!\n");
					enemigo.getClase().ataque(jugador, enemigo);
				}
				else{
					System.out.print("\n\n "+enemigo.getNombre()+ " se prepara para Defender!\n");
					enemigo.getClase().setDefiende(true);
				}
				System.out.print("\n\n"+jugador.getNombre()+": "+jugador.getVida()+"     "+enemigo.getNombre()+": "+enemigo.getVida());
			}
		}
	}
}
