package heroesYVillanos;

import java.util.HashMap;

public abstract class Combatiente {

	private String nombre; // nombre de liga o personaje
	private Equipo equipo;
	private HashMap<Caracteristica, Integer> caracteristicas;

	public Combatiente(String nombre, Equipo equipo, int velocidad, int fuerza, int resistencia, int destreza) {
		this.nombre = nombre;
		this.equipo = equipo;
		this.caracteristicas = new HashMap<Caracteristica, Integer>();
		caracteristicas.put(Caracteristica.FUERZA, fuerza);
		caracteristicas.put(Caracteristica.VELOCIDAD, velocidad);
		caracteristicas.put(Caracteristica.DESTREZA, destreza);
		caracteristicas.put(Caracteristica.RESISTENCIA, resistencia);
	}

	public boolean esGanador(Combatiente combatiente, Caracteristica c) {
		try {
			examinarEquipo(combatiente, c);
		} catch (PeleasEntreElMismoEquipoExcepcion e) {
			System.err.println("No se pueden enfrentar 2 combatientes del mismo equipo!!!");
		}

		boolean esGanador = false;
		Caracteristica aux = c;

		if (!this.getEquipo().equals(combatiente.getEquipo())) {

			while (this.getCaracteristica(aux) == combatiente.getCaracteristica(aux)) {
				aux = aux.nextCaracteristica(aux);

				if (aux.equals(c)) {
					System.out.println("El resultado de la pelea es empate en todas las caracteristicas");
					return esGanador;
				}

			}
			if (this.getCaracteristica(aux) > combatiente.getCaracteristica(aux)) {
				esGanador = true;
				System.out.println("El combatiente " + this.getNombre() + " es el vencedor del combate por " + aux);

			} else {
				System.out.println(
						"El combatiente " + combatiente.getNombre() + " es el vencedor del combate por " + aux);
			}

		}

		return esGanador;
	}
	
	private boolean examinarEquipo(Combatiente c, Caracteristica caracteristica) throws PeleasEntreElMismoEquipoExcepcion {
		boolean diferenteEquipo = true;
		if (this.getEquipo().equals(c.getEquipo())) {
			throw new PeleasEntreElMismoEquipoExcepcion();
		}
		return diferenteEquipo;
	}

	public int getCaracteristica(Caracteristica c) {
		return caracteristicas.get(c);
	}

	public String getNombre() {
		return nombre;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public int compareTo(Liga otraLiga, Caracteristica c) {
		return Integer.compare(this.getCaracteristica(c), otraLiga.getCaracteristica(c));
	}

	public int compareTo(Combatiente otroCombatiente, Caracteristica c) {
		return Integer.compare(this.getCaracteristica(c), otroCombatiente.getCaracteristica(c));
	}

}
