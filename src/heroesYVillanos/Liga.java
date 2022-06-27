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
			super.setCaracteristica(Caracteristica.VELOCIDAD, promediarHabilidades(Caracteristica.VELOCIDAD));
			super.setCaracteristica(Caracteristica.FUERZA,promediarHabilidades(Caracteristica.FUERZA));
			super.setCaracteristica(Caracteristica.RESISTENCIA, promediarHabilidades(Caracteristica.RESISTENCIA));
			super.setCaracteristica(Caracteristica.DESTREZA, promediarHabilidades(Caracteristica.DESTREZA));
		} else {
			System.err.println(combatiente.getNombre() + " No es del mismo equipo");
		}
		
	}

	@Override
	public int getCaracteristica(Caracteristica caracteristica) {
		return promediarHabilidades(caracteristica); 
	}
	
	// este mÃƒÂ©todo tiene que ser usado por otro metodo

	public int promediarHabilidades(Caracteristica caracteristica) {
		int promedio = 0;
		int cantidad = 0;
		for (Combatiente c : combatientes) {
			promedio += c.getCaracteristica(caracteristica);
			cantidad++;
		}
		return promedio / cantidad;

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
