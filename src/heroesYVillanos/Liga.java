package heroesYVillanos;

import java.util.HashSet;
import java.util.TreeSet;


public class Liga extends Combatiente{
	
	private static HashSet<Combatiente> combatientes;
	
	public Liga(String nombre, Equipo equipo, int velocidad, int fuerza, int resistencia, int destreza, HashSet<Combatiente> combatientes) {
		super(nombre, equipo, velocidad, fuerza, resistencia, destreza);
		Liga.combatientes = combatientes;
		this.combatientes = new HashSet<Combatiente>();
	}

	
	public void agregarCombatiente(Combatiente combatiente) {
		
		if(this.getEquipo() == combatiente.getEquipo()) {
			combatientes.add(combatiente);
		} else {
			System.err.println(combatiente.getNombre() + " No es del mismo equipo");
		}
		
	}

	//este mÃ©todo tiene que ser usado por otro metodo
	
	public double promediarHabilidades(Caracteristica caracteristica) {
		double promedio = 0;
		int cantidad = 0;
		for (Combatiente c: combatientes) {
			promedio += c.getCaracteristica(caracteristica);
			cantidad++;
		}
		return promedio/cantidad;
		
	}
	
	public void eliminarCombatiente(Combatiente combatiente) {
		combatientes.remove(combatiente);
	}

	public static HashSet<Combatiente> getCombatientes() {
		return combatientes;
	}
	
	
	public TreeSet<Integer> listarCombatienteOrdenado(Caracteristica c){
		
		TreeSet<Integer> listaOrdenada = new TreeSet<Integer>();
		
		for(Combatiente comb : combatientes) {
			listaOrdenada.add(comb.getCaracteristica(c));
		}
		
		return listaOrdenada;
	}
	
}
