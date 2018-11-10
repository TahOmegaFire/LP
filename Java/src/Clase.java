package src;

public abstract class Clase
{
	int armadura;
	boolean defiende;
	String nombre;

	public Clase()
	{
		this.armadura = 0;
	}

	public abstract void crearClase();
	public abstract void ataque(Personaje enemigo, Personaje yo);
	public abstract void defender();

	public int getArmadura() { return armadura; }
	public boolean getDefiende() { return defiende; }
	public String getNombre() { return nombre; }
	
	public void setArmadura(int nArmadura) { this.armadura = nArmadura; }
	public void setDefiende(boolean nDefiende) { this.defiende = nDefiende; }
	public void setNombre(String nNombre) { this.nombre = nNombre; }
}
