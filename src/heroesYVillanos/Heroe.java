package heroesYVillanos;

public class Heroe extends Combatiente {

	private String nombreCivil;

	public Heroe(String nombreCivil, String nombre, int velocidad, int fuerza, int resistencia, int destreza) {
		super(nombre, Equipo.HEROE, velocidad, fuerza, resistencia, destreza);
		this.nombreCivil = nombreCivil;
	}
	
	// este metodo devuelve true si el heroe actual le gana al combatiente ingresado de acuerdo a la 
	// caracteristica solicitada, si empatan definen x la siguiente caracteristica.
	//falta agregar q un heroe solo se pueda enfrentar a un villano/liga de villanos.

	public String getNombreCivil() {
		return nombreCivil;
	}
	
}
