package heroesYVillanos;

import java.util.Comparator;

public class ComparadorPorDestreza implements Comparator<Combatiente>{
	@Override
	public int compare(Combatiente combA, Combatiente combB) {
		if(combA.getCaracteristica(Caracteristica.DESTREZA) > combB.getCaracteristica(Caracteristica.DESTREZA)) {
			return 1;
		} else if(combA.getCaracteristica(Caracteristica.DESTREZA) == combB.getCaracteristica(Caracteristica.DESTREZA)) {
			return 0;
		} else {
			return -1;
		}
	}
}