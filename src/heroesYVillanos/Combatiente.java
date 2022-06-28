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
		caracteristicas.put(Caracteristica.VELOCIDAD, velocidad);
		caracteristicas.put(Caracteristica.FUERZA, fuerza);
		caracteristicas.put(Caracteristica.RESISTENCIA, resistencia);
		caracteristicas.put(Caracteristica.DESTREZA, destreza);
		
	}

	public boolean esGanador(Combatiente combatiente, Caracteristica c) {
		boolean esGanador = false;
		int contador = 0;

		try {
			examinarEquipo(combatiente, c);
			
			while (this.getCaracteristica(c) == combatiente.getCaracteristica(c) && contador < 4) {
				c = c.nextCaracteristica(c);
				contador++;
			}
			if (this.getCaracteristica(c) > combatiente.getCaracteristica(c)) {
				esGanador = true;
				System.out.println("El combatiente " + this.getNombre() + " es el vencedor del combate por " + c);
			} else if (this.getCaracteristica(c) < combatiente.getCaracteristica(c)) {
				System.out.println(
						"El combatiente " + combatiente.getNombre() + " es el vencedor del combate por " + c);
			} else {
				System.out.println("El resultado de la pelea es empate en todas las caracteristicas");
			}

		} catch (PeleasEntreElMismoEquipoExcepcion e) {
			System.err.println("No se pueden enfrentar 2 combatientes del mismo equipo!!!");
		}

		return esGanador;
	}

	
	protected boolean examinarEquipo(Combatiente c, Caracteristica caracteristica) throws PeleasEntreElMismoEquipoExcepcion {
		boolean diferenteEquipo = true;
		if (this.getEquipo().equals(c.getEquipo())) {
			throw new PeleasEntreElMismoEquipoExcepcion();
		}
		return diferenteEquipo;
	}
	
	public void setCaracteristica(Caracteristica c, int otroValor) {
		this.caracteristicas.put(c, otroValor);
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

	/*
	 * public int compareTo(Combatiente otroCombatiente) : 
	 * Compara por las cuatro caracteristicas, en un orden determinado. Sirve para listar personajes por múltiples caracteristicas a la vez.
	 * Si se quiere comparar por alguna característica en específico, utilizar Comparator.
	 * */
	@Override
	public int compareTo(Combatiente otroCombatiente) {
		boolean mismaFuerza = false, mismaVelocidad = false, mismaDestreza = false, mismaResistencia = false;
		
		mismaVelocidad = this.getCaracteristica(Caracteristica.VELOCIDAD) == otroCombatiente.getCaracteristica(Caracteristica.VELOCIDAD);
		mismaFuerza = this.getCaracteristica(Caracteristica.FUERZA) == otroCombatiente.getCaracteristica(Caracteristica.FUERZA);
		mismaResistencia = this.getCaracteristica(Caracteristica.RESISTENCIA) == otroCombatiente.getCaracteristica(Caracteristica.RESISTENCIA);
		mismaDestreza = this.getCaracteristica(Caracteristica.DESTREZA) == otroCombatiente.getCaracteristica(Caracteristica.DESTREZA);
		
		System.out.println("Personajes: " + this.nombre + " y " + otroCombatiente.nombre);
		System.out.println("Misma velocidad: " + mismaVelocidad);
		System.out.println("Misma fuerza: " + mismaFuerza);
		System.out.println("Misma destreza: " + mismaDestreza);
		System.out.println("Misma resistencia: " + mismaResistencia);
		
		try {
			if(mismaVelocidad && mismaFuerza && mismaDestreza) {
				System.out.println("If 1");
				return -Integer.compare(this.getCaracteristica(Caracteristica.DESTREZA), otroCombatiente.getCaracteristica(Caracteristica.DESTREZA));
			} else if(mismaVelocidad && mismaFuerza && !mismaDestreza) {
				System.out.println("If 2");
				return -Integer.compare(this.getCaracteristica(Caracteristica.RESISTENCIA), otroCombatiente.getCaracteristica(Caracteristica.RESISTENCIA));
			} else if( mismaVelocidad && !mismaFuerza) {
				System.out.println("If 3");
				return -Integer.compare(this.getCaracteristica(Caracteristica.FUERZA), otroCombatiente.getCaracteristica(Caracteristica.FUERZA));
			} else if(!mismaVelocidad){
				System.out.println("If 4");
				return -Integer.compare(this.getCaracteristica(Caracteristica.VELOCIDAD), otroCombatiente.getCaracteristica(Caracteristica.VELOCIDAD));
			} else {
				throw new ErrorDeComparacionException();
			}
		}catch(ErrorDeComparacionException E){
			System.err.println("Hubo un error en la comparacion");
			return 0;
		}
		
	}
	
}
