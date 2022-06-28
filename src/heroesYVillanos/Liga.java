package heroesYVillanos;

import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;

public class Liga extends Combatiente{
	
	private HashSet<Combatiente> combatientes;
	
	public Liga(String nombre, Equipo equipo, int velocidad, int fuerza, int resistencia, int destreza, HashSet<Combatiente> combatientes) {
		super(nombre, equipo, velocidad, fuerza, resistencia, destreza);
		this.combatientes = new HashSet<Combatiente>();
	}

	
	public void agregarCombatiente(Combatiente combatiente) {
		
		if(this.getEquipo() == combatiente.getEquipo()) {
			combatientes.add(combatiente);
			super.setCaracteristica(Caracteristica.VELOCIDAD, getCaracteristica(Caracteristica.VELOCIDAD));
			super.setCaracteristica(Caracteristica.FUERZA,getCaracteristica(Caracteristica.FUERZA));
			super.setCaracteristica(Caracteristica.RESISTENCIA, getCaracteristica(Caracteristica.RESISTENCIA));
			super.setCaracteristica(Caracteristica.DESTREZA, getCaracteristica(Caracteristica.DESTREZA));
		} else {
			System.err.println(combatiente.getNombre() + " No es del mismo equipo");
		}		
	}
	
	@Override
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
				System.out.println("La " + this.getNombre() + " es la vencedora del combate por " + c);
			} else if (this.getCaracteristica(c) < combatiente.getCaracteristica(c)) {
				System.out.println("La " + combatiente.getNombre() + " es la vencedora del combate por " + c);
			} else {
				System.out.println("El resultado de la pelea es empate en todas las caracteristicas");
			}

		} catch (PeleasEntreElMismoEquipoExcepcion e) {
			System.err.println("No se pueden enfrentar 2 ligas del mismo equipo!!!");
		}

		return esGanador;
	}

	@Override
	public int getCaracteristica(Caracteristica caracteristica) {
		int suma = 0; int cantidad = 0; int promedio = 0;	
		for (Combatiente c : combatientes) {
			suma += c.getCaracteristica(caracteristica);
			cantidad++;
		} if (cantidad != 0) {
		promedio = suma / cantidad;
		}
		return promedio;
	}
	
	public void eliminarCombatiente(Combatiente combatiente) {
		combatientes.remove(combatiente);
	}

	public HashSet<Combatiente> getCombatientes() {
		return combatientes;
	}
	
	
	public TreeSet<Integer> listarCombatienteOrdenado(Caracteristica c){
		
		TreeSet<Integer> listaOrdenada = new TreeSet<Integer>();
		
		for(Combatiente comb : combatientes) {
			listaOrdenada.add(comb.getCaracteristica(c));
		}
		
		return listaOrdenada;
	}
	
	@Override
	public String toString() {
		Iterator<Combatiente> itr1 = combatientes.iterator();
		String datos = " "+ "Velocidad: " + super.getCaracteristica(Caracteristica.VELOCIDAD) + ", "
		+ "Fuerza: " + super.getCaracteristica(Caracteristica.FUERZA)+ ", " 
		+ "Resistencia: "+ super.getCaracteristica(Caracteristica.RESISTENCIA) + ", "
		+ "Destreza: "+ super.getCaracteristica(Caracteristica.DESTREZA)
		+"\n Combatientes: ";
		while (itr1.hasNext()) {
			datos += itr1.next().getNombre() + ", ";
		}
		return datos;
	}
}
