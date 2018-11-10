package juego;
import java.util.Random;


public class Juego
{
	static Random rObj;
	
	public static int lanzarDados(int caras)
	{
		return rObj.nextInt(caras);
	}

}
