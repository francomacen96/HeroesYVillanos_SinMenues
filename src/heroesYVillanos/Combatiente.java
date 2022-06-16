package heroesYVillanos;

import java.util.HashMap;

public class Combatiente{
	
private String nombre; // nombre de liga o personaje
private Equipo equipo;
private HashMap<Caracteristica, Integer> caracteristicas;

public Combatiente(String nombre, Equipo equipo, int velocidad, int fuerza,
		int resistencia, int destreza) {
	this.nombre = nombre;
	this.equipo = equipo;
	this.caracteristicas = new HashMap<Caracteristica, Integer>();
	caracteristicas.put(Caracteristica.FUERZA, fuerza);
	caracteristicas.put(Caracteristica.VELOCIDAD, velocidad);
	caracteristicas.put(Caracteristica.DESTREZA, destreza);
	caracteristicas.put(Caracteristica.RESISTENCIA, resistencia);
}

public boolean esGanador(Combatiente combatiente, Caracteristica c) {

	if (this.getEquipo().equals(combatiente.getEquipo())) {
		System.out.println("No se pueden enfrentar 2 combatientes del mismo equipo");
	}

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
		System.out.println("El combatiente " + this.getNombre()
				+ " es el vencedor del combate");

	} else if (this.getCaracteristica(c) < combatiente.getCaracteristica(c)) {
		System.out.println("El combatiente " + combatiente.getNombre()
				+ " es el vencedor del combate");
	}
	return esGanador;
}

public boolean esGanador(Liga liga, Caracteristica c) {

	if (this.getEquipo().equals(liga.getEquipo())) {
		System.out.println("No se pueden enfrentar 2 ligas del mismo equipo");
	}

	boolean esGanador = false;
	Caracteristica cAux;
	if (this.getCaracteristica(c) == liga.getCaracteristica(c)) {
		esGanador(liga, c.nextCaracteristica(c));
		cAux = c.nextCaracteristica(c);

		if (c.equals(cAux)) {
			System.out.println("El resultado de la pelea es empate");
			return esGanador;
		}

	} else if (this.getCaracteristica(c) > liga.getCaracteristica(c)) {
		esGanador = true;
		System.out.println("El combatiente " + this.getNombre()
				+ " es el vencedor del combate");

	} else if (this.getCaracteristica(c) < liga.getCaracteristica(c)) {
		System.out.println("La liga: " + liga.getNombre()
				+ " es la vencedora del combate");
	}
	return esGanador;
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
	return Integer.compare(this.getCaracteristica(c),otraLiga.getCaracteristica(c) );
}

public int compareTo(Combatiente otroCombatiente, Caracteristica c) {
	return Integer.compare(this.getCaracteristica(c),otroCombatiente.getCaracteristica(c) );
}
}
