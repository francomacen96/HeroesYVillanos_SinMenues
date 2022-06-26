package heroesYVillanos;


@SuppressWarnings("serial")

public class CombatienteCaractIncorrectas extends Exception {

	public CombatienteCaractIncorrectas() {
		super("El combatiente posee alguna caracteristica con valor incorrecto");
	}
}
