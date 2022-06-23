package heroesYVillanos;

import java.util.Comparator;

public class ComparadorPorVelocidad implements Comparator<Combatiente>{
	@Override
	public int compare(Combatiente combA, Combatiente combB) {
		if(combA.getCaracteristica(Caracteristica.VELOCIDAD) > combB.getCaracteristica(Caracteristica.VELOCIDAD)) {
			return 1;
		} else if(combA.getCaracteristica(Caracteristica.VELOCIDAD) == combB.getCaracteristica(Caracteristica.VELOCIDAD)) {
			return 0;
		} else {
			return -1;
		}
	}
}
