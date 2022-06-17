import org.junit.Assert;
import org.junit.Test;

public class CombatienteTest {

	@Test
	public void enfrentamientoPorVelocidadTest() {
		Combatiente p1 = new Heroe("Tony Stark", "Iron Man", 99, 98, 90, 84);
		Combatiente p2 = new Villano("Thanos", "Thanos", 89, 83, 98, 96);

		/***
		 * VELOCIDAD IRONMAN 99 , THANOS 89
		 */

		Assert.assertTrue(p1.esGanador(p2, Caracteristica.VELOCIDAD));

	}

	@Test
	public void enfrentamientoPorFuerzaTest() {
		Combatiente p1 = new Heroe("Tony Stark", "Iron Man", 98, 92, 90, 84);
		Combatiente p2 = new Villano("Thanos", "Thanos", 100, 98, 98, 96);

		/***
		 * Fuerza Thanos 98, ironman 92
		 */

		Assert.assertTrue(p2.esGanador(p1, Caracteristica.FUERZA));

	}

	@Test
	public void enfrentamientoPorDestrezaTest() {
		Combatiente p1 = new Heroe("Tony Stark", "Iron Man", 98, 88, 90, 84);
		Combatiente p2 = new Villano("Thanos", "Thanos", 100, 98, 98, 96);

		/***
		 * Destreza Thanos 98, ironman 90
		 */

		Assert.assertTrue(p2.esGanador(p1, Caracteristica.DESTREZA));

	}

	@Test
	public void enfrentamientoPorResistenciaTest() {
		Combatiente p1 = new Heroe("Tony Stark", "Iron Man", 98, 88, 90, 84);
		Combatiente p2 = new Villano("Thanos", "Thanos", 100, 98, 98, 96);

		/***
		 * Resistencia THANOS 96 Ironman 84
		 */

		Assert.assertTrue(p2.esGanador(p1, Caracteristica.FUERZA));

	}

	@Test
	public void enfrentamientoPorVelocidadEmpataDefinePorFuerza() {
		Combatiente p1 = new Heroe("Tony Stark", "Iron Man", 50, 88, 90, 84);
		Combatiente p2 = new Villano("Coronel Rhoades", "Maquina de guerra", 50, 98, 98, 96);

		/***
		 * VELOCIDAD AMBOS 50
		 * FUERZA DE P2= 98, FUERZA DE P1=88 (GANA P2)
		 */

		Assert.assertTrue(p2.esGanador(p1, Caracteristica.VELOCIDAD));

	}

	@Test
	public void enfrentamientoPorFuerzaEmpataDefinePorDestreza() {
		Combatiente p1 = new Heroe("Bruce Banner", "Hulk", 50, 98, 90, 84);
		Combatiente p2 = new Villano("Thanos", "Thanos", 50, 98, 98, 96);

		/***
		 * FUERZA AMBOS 98
		 */

		Assert.assertTrue( p2.esGanador(p1, Caracteristica.FUERZA));

	}

	@Test
	public void enfrentamientoPorResistenciaEmpataDefinePorDestreza() {
		Combatiente p1 = new Heroe("Steve Rogers", "Capitan America", 50, 98, 90, 84);
		Combatiente p2 = new Villano("Bucky Barnes", "Soldado del Invierno", 50, 98, 90, 96);

		/***
		 * RESISTENCIA AMBOS 90
		 */

		Assert.assertTrue(p2.esGanador(p1, Caracteristica.RESISTENCIA));

	}

	@Test
	public void enfrentamientoEmpataEnTodosLosAspectos() {
		Combatiente p1 = new Heroe("Steve Rogers", "Capitan America", 50, 98, 90, 96);
		Combatiente p2 = new Villano("Craneo rojo", "Craneo Rojo", 50, 98, 90, 96);

		/***
		 * DESTREZA AMBOS 90
		 */

		Assert.assertFalse(p2.esGanador(p1, Caracteristica.VELOCIDAD));

	}

	@Test
	public void comparaUnCombatienteConUnaLigaYGanariaCombatiente() {
		Combatiente p1 = new Heroe("Clark Kent", "Superman", 98, 98, 97, 96);
		Liga L1 = new Liga("Liga de la injusticia", Equipo.VILLANO, 97, 84, 85, 83, null);
		// compare to devuelve 1 Si superman es superior a la liga
		Assert.assertEquals(1, p1.compareTo(L1, Caracteristica.VELOCIDAD));
	}
	
	@Test
	public void comparaUnCombatienteConUnaLigaYGanariaLiga() {
		Combatiente p1 = new Heroe("Clark Kent", "Superman", 98, 98, 97, 96);
		Liga L1 = new Liga("Liga de la injusticia", Equipo.VILLANO, 100, 84, 85, 83, null);
		// compare to devuelve -1 si gana la liga
		Assert.assertEquals(-1, p1.compareTo(L1, Caracteristica.VELOCIDAD));
	}
	@Test
	public void EnfrentamientoEntreligaYHeroePorFuerzaYDestreza() {
		Combatiente p1 = new Heroe("Clark Kent", "Superman", 98, 98, 97, 96);
		Liga L1 = new Liga("Liga de la injusticia", Equipo.VILLANO, 97, 99, 85, 83, null);
		Assert.assertTrue(L1.esGanador(p1, Caracteristica.FUERZA));
		Assert.assertFalse(L1.esGanador(p1, Caracteristica.DESTREZA));
		
	}
	
	@Test
	public void enfrentamientoEntreHeroes() {
		Combatiente p1 = new Heroe("Bruce Banner", "Hulk", 50, 98, 90, 84);
		Combatiente p2 = new Heroe("Clark Kent", "Superman", 98, 98, 97, 96);
		p1.esGanador(p2, Caracteristica.DESTREZA);
	}
		

}
