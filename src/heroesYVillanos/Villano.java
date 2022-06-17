package heroesYVillanos;

public class Villano extends Combatiente {
	
	private String nombreCivil;

	public Villano(String nombreCivil, String nombre, int velocidad, int fuerza, int resistencia, int destreza) {
		super(nombre, Equipo.VILLANO, velocidad, fuerza, resistencia, destreza);
		this.nombreCivil = nombreCivil;
	}
	
	// este metodo devuelve true si el combatiente actual le gana al combatiente ingresado de acuerdo a la 
	// caracteristica solicitada, si empatan definen x la siguiente caracteristica.
	//falta agregar q un villano solo se pueda enfrentar a un heroe/liga de heroes.
	

	public String getNombreCivil() {
		return nombreCivil;
	}

}

