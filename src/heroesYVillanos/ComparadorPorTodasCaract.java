package heroesYVillanos;
import java.util.Comparator;

public class ComparadorPorTodasCaract implements Comparator<Combatiente>{
	@Override
	public int compare(Combatiente c1, Combatiente c2){
		boolean mismaVelocidad = c1.getCaracteristica(Caracteristica.VELOCIDAD) == c2.getCaracteristica(Caracteristica.VELOCIDAD);
		boolean mismaFuerza = c1.getCaracteristica(Caracteristica.FUERZA) ==  c2.getCaracteristica(Caracteristica.FUERZA);
		boolean mismaResistencia = c1.getCaracteristica(Caracteristica.RESISTENCIA) == c2.getCaracteristica(Caracteristica.RESISTENCIA);
		boolean mismaDestreza = c1.getCaracteristica(Caracteristica.DESTREZA) == c2.getCaracteristica(Caracteristica.DESTREZA);
		
		System.out.println("Personajes: " + c1.getNombre() + " y " + c2.getNombre());
		System.out.println("Misma velocidad: " + mismaVelocidad);
		System.out.println("Misma fuerza: " + mismaFuerza);
		System.out.println("Misma destreza: " + mismaDestreza);
		System.out.println("Misma resistencia: " + mismaResistencia);
		
		try {
			if(mismaVelocidad && mismaFuerza && mismaDestreza) {
				System.out.println("If 1");
				return -Integer.compare(c1.getCaracteristica(Caracteristica.DESTREZA), c2.getCaracteristica(Caracteristica.DESTREZA));
			} else if(mismaVelocidad && mismaFuerza && !mismaDestreza) {
				System.out.println("If 2");
				return -Integer.compare(c1.getCaracteristica(Caracteristica.RESISTENCIA), c2.getCaracteristica(Caracteristica.RESISTENCIA));
			} else if( mismaVelocidad && !mismaFuerza) {
				System.out.println("If 3");
				return -Integer.compare(c1.getCaracteristica(Caracteristica.FUERZA), c2.getCaracteristica(Caracteristica.FUERZA));
			} else if(!mismaVelocidad){
				System.out.println("If 4");
				return -Integer.compare(c1.getCaracteristica(Caracteristica.VELOCIDAD), c2.getCaracteristica(Caracteristica.VELOCIDAD));
			} else {
				throw new ErrorDeComparacionException();
			}
		}catch(ErrorDeComparacionException E){
			System.err.println("Hubo un error en la comparacion");
			return 0;
		}
		
		
	}
}
