package heroesYVillanos;

import java.util.HashMap;

public abstract class Combatiente implements Comparable<Combatiente>{

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

	/* @delete
	public int compareTo(Liga otraLiga, Caracteristica c) {
		return Integer.compare(this.getCaracteristica(c), otraLiga.getCaracteristica(c));
	}
	*/
	
	/*public int compareTo(Combatiente otroCombatiente, Caracteristica c) { //@todo borrar o cambiar
		return Integer.compare(this.getCaracteristica(c), otroCombatiente.getCaracteristica(c));
	}*/

	/*
	 * public int compareTo(Combatiente otroCombatiente) : 
	 * Compara por las cuatro caracteristicas, en un orden determinado. Sirve para listar personajes por múltiples caracteristicas a la vez.
	 * Si se quiere comparar por alguna característica en específico, utilizar Comparator.
	 * */
	@Override
	public int compareTo(Combatiente otroCombatiente) {
		boolean mismaFuerza = false, mismaVelocidad = false, mismaDestreza = false, mismaResistencia = false;
		
		mismaFuerza = this.getCaracteristica(Caracteristica.FUERZA) == otroCombatiente.getCaracteristica(Caracteristica.FUERZA);
		mismaVelocidad = this.getCaracteristica(Caracteristica.VELOCIDAD) == otroCombatiente.getCaracteristica(Caracteristica.VELOCIDAD);
		mismaDestreza = this.getCaracteristica(Caracteristica.DESTREZA) == otroCombatiente.getCaracteristica(Caracteristica.DESTREZA);
		mismaResistencia = this.getCaracteristica(Caracteristica.RESISTENCIA) == otroCombatiente.getCaracteristica(Caracteristica.RESISTENCIA);
		
		System.out.println("Personajes: " + this.nombre + " y " + otroCombatiente.nombre);
		System.out.println("Misma fuerza: " + mismaFuerza);
		System.out.println("Misma velocidad: " + mismaVelocidad);
		System.out.println("Misma destreza: " + mismaDestreza);
		System.out.println("Misma resistencia: " + mismaResistencia);
		
		
		if(mismaFuerza && mismaVelocidad && mismaDestreza) {
			System.out.println("If 1");
			return Integer.compare(this.getCaracteristica(Caracteristica.RESISTENCIA), otroCombatiente.getCaracteristica(Caracteristica.RESISTENCIA));
		} else if(mismaFuerza && mismaVelocidad && !mismaDestreza) {
			System.out.println("If 2");
			return Integer.compare(this.getCaracteristica(Caracteristica.DESTREZA), otroCombatiente.getCaracteristica(Caracteristica.DESTREZA));
		} else if(mismaFuerza && !mismaVelocidad) {
			System.out.println("If 3");
			return Integer.compare(this.getCaracteristica(Caracteristica.VELOCIDAD), otroCombatiente.getCaracteristica(Caracteristica.VELOCIDAD));
		} else {
			System.out.println("If 4");
			return Integer.compare(this.getCaracteristica(Caracteristica.FUERZA), otroCombatiente.getCaracteristica(Caracteristica.FUERZA));
		}
		
	}
	
	@Override
	public String toString() {
		return this.nombre + " " + getCaracteristica(Caracteristica.FUERZA) + " , " + getCaracteristica(Caracteristica.VELOCIDAD) + " , " + getCaracteristica(Caracteristica.DESTREZA) + " , " + getCaracteristica(Caracteristica.RESISTENCIA);
	}
	
}
