package src;

public interface Personaje
{
	public void asignarRaza(Raza raza);
	public void asignarClase(Clase clase);
	public void asignarVida();
	public void asignarNombre(String nombre);
	public int getVida();
	public void setVida(int vida);
	public Clase getClase();
	public Raza getRaza();
}
