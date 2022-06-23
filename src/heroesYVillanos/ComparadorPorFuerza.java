package heroesYVillanos;

import java.util.Comparator;

public class ComparadorPorFuerza implements Comparator<Combatiente>{
	@Override
	public int compare(Combatiente combA, Combatiente combB) {
		if(combA.getCaracteristica(Caracteristica.FUERZA) > combB.getCaracteristica(Caracteristica.FUERZA)) {
			return 1;
		} else if(combA.getCaracteristica(Caracteristica.FUERZA) == combB.getCaracteristica(Caracteristica.FUERZA)) {
			return 0;
		} else {
			return -1;
		}
	}
}
