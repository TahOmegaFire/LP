package src;

public abstract class Clase
{
	int armadura;
	boolean defiende;

	public Clase()
	{
		this.armadura = 0;
	}

	public abstract void crearClase();
	public abstract void ataque(Personaje enemigo);
	public abstract void defender();

	public int getArmadura() { return armadura; }
	public boolean getDefiende() { return defiende; }
	
	public void setArmadura(int nArmadura) { this.armadura = nArmadura; }
	public void setDefiende(boolean nDefiende) { this.defiende = nDefiende; }
}
