package heroesYVillanos;

import java.util.Comparator;

public class ComparadorPorResistencia implements Comparator<Combatiente>{
	@Override
	public int compare(Combatiente combA, Combatiente combB) {
		if(combA.getCaracteristica(Caracteristica.RESISTENCIA) > combB.getCaracteristica(Caracteristica.RESISTENCIA)) {
			return 1;
		} else if(combA.getCaracteristica(Caracteristica.RESISTENCIA) == combB.getCaracteristica(Caracteristica.RESISTENCIA)) {
			return 0;
		} else {
			return -1;
		}
	}
}
