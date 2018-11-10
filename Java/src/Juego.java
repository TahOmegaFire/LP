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
		return rObj.nextInt(caras);
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
		int n = lanzarDados(6)+1; // Obtiene un numero al azar para elegir un contrincante
		Enemigo enemigo = null;
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
	}
}
