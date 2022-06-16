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
	
	@Override 
	public boolean esGanador(Combatiente combatiente, Caracteristica c) {
		boolean esGanador = false;
		Caracteristica cAux;
		if (this.getCaracteristica(c) == combatiente.getCaracteristica(c)) {
			esGanador(combatiente, c.nextCaracteristica(c));
			cAux = c.nextCaracteristica(c);

			if (c.equals(cAux)) {
				System.out.println("El resultado de la pelea es empate");
				return esGanador;
			}

		} else if (this.getCaracteristica(c) > combatiente.getCaracteristica(c)) {
			esGanador = true;
			System.out.println("El Villano " + this.getNombre() + " es el vencedor del combate");

		} else if (this.getCaracteristica(c) < combatiente.getCaracteristica(c)) {
			System.out.println("El combatiente " + combatiente.getNombre() + " es el vencedor del combate");
		}
		return esGanador;
	}
	
	public String getNombreCivil() {
		return nombreCivil;
	}

}

