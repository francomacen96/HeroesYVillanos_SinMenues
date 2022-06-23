package heroesYVillanos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Map.Entry;

public class Sistema {

	private HashMap<String, Combatiente> personajes; //@todo se debe hacer una sola lista de Combatientes
	private HashMap<String, Liga> ligas;
	public static final int BACK = -1;
	private int opcionMenu;

	public Sistema() {
		this.opcionMenu = 0;
		this.ligas = new HashMap<String,Liga>();
		this.personajes = new HashMap<String,Combatiente>();

	}

	public static void main(String[] args) {
		Sistema s = new Sistema();
		// s.leerArchivoPersonajes();
		// s.leerArchivoLiga();

		s.menues();
	}

	private void menues() {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader);
		cargaArchivoPersonajes();
		cargaArchivoLiga();
		while(true) {
			listarOpciones();
			
			this.opcionMenu = ingresarOpcion();
			switch (this.opcionMenu) {
			case 1:
				ejecutarFuncionPersonajes();
				break;
			case 2:
				ejecutarFuncionLigas();
				break;
			case 3:
				ejecutarFuncionBatallar();
				break;
			case 4: 
				ejecutarFuncionReporte();
				break;
			case 5:
				System.exit(0);
			default:
				System.err.println("Opcion no valida");
				break;
			}
		}
	}

	private void listarOpciones() {
		System.out.println("Menu principal");
		System.out.println("1 - Personajes");
		System.out.println("2 - Ligas");
		System.out.println("3 - Batalla");
		System.out.println("4 - Reportes");
		System.out.println("5 - Salir");


	}

	private int ingresarOpcion() {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader);
		String entrada = "";
		int entradaInt;
		
		System.out.println("Ingrese opcion:");
		try {
			entrada = in.readLine();
			System.out.println("Entrada: " + entrada);
		} catch (IOException E){
			System.err.println(E);
			return -1;
		}
		try {
			entradaInt = Integer.parseInt(entrada);
		}catch (NumberFormatException E) {
			return -1;
		}
		return entradaInt;
	}

	/**
	 * PERSONAJES
	 */

	public void ejecutarFuncionPersonajes() {
		System.out.println("1 - Carga desde archivo");
		System.out.println("2 - Crear personaje");
		System.out.println("3 - Listado de personajes");
		System.out.println("4 - Guardar personajes en archivo");
		System.out.println("5 - Volver al menu");

		Scanner entrada = new Scanner(System.in);
		int eleccion = entrada.nextInt();
		switch (eleccion) {
		case 1: {
			cargaArchivoPersonajes();
			ejecutarFuncionPersonajes();
			}
		case 2: {
			crearPersonaje();
			ejecutarFuncionPersonajes();
		}
		case 3: {
			listarPersonajes();
			ejecutarFuncionPersonajes();
		}
		case 4: {
			guardarEnArchivoPersonajes();
			ejecutarFuncionPersonajes();
		}
		case 5: {
			menues();
		}default:
			System.err.println("Opcion no valida");
			ejecutarFuncionPersonajes();
		
		}
	}

	public void cargaArchivoPersonajes() {

		try {
			FileReader archivo = new FileReader("personajes2_in.txt");
			BufferedReader lector = new BufferedReader(archivo);
			String oneLine = lector.readLine();

			while (oneLine != null) {
				String[] datos = oneLine.split(", ");
				Equipo tipo_De_Personaje = Equipo.valueOf(datos[0]
						.toUpperCase());
				String nombre_Real = datos[1];
				String nombre_Personaje = datos[2];
				int velocidad = Integer.parseInt(datos[3]);
				int fuerza = Integer.parseInt(datos[4]);
				int resistencia = Integer.parseInt(datos[5]);
				int destreza = Integer.parseInt(datos[6]);


				Combatiente personaje = null;
	
				if(tipo_De_Personaje == Equipo.VILLANO) {
					personaje = new Villano(nombre_Real, nombre_Personaje,
							velocidad, fuerza, resistencia, destreza);
				} else {
					personaje = new Heroe(nombre_Real, nombre_Personaje,
							velocidad, fuerza, resistencia, destreza);
				}
				this.personajes.put(nombre_Personaje, personaje);
				oneLine = lector.readLine();
			}
			lector.close();
			System.out.println("Los personajes han sido cargados !");


		} catch (FileNotFoundException e) {
			System.err.println("No se encontro archivo 'personajes.in'");
		} catch (IOException e) {
			System.err.println("No se encontro archivo 'personajes.in'");
		}
	}

	public void crearPersonaje() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese nombre de civil del personaje: ");
		String nombreCivil = entrada.nextLine();
		System.out.println(nombreCivil + " sera HEROE o VILLANO?");
		Equipo tipo_De_Personaje = Equipo.valueOf(entrada.nextLine()
				.toUpperCase());
		;
		System.out.println("Ingrese nombre de personaje: ");
		String nombre_Personaje = entrada.nextLine();
		System.out.println("Ingrese nivel de Velocidad: ");
		int velocidad = entrada.nextInt();
		System.out.println("Ingrese nivel de Fuerza: ");
		int fuerza = entrada.nextInt();
		System.out.println("Ingrese nivel de Resistencia: ");
		int resistencia = entrada.nextInt();
		System.out.println("Ingrese nivel de Destreza: ");
		int destreza = entrada.nextInt();

		Combatiente personaje = null;

		if (tipo_De_Personaje == Equipo.HEROE) {
			personaje = new Heroe(nombreCivil, nombre_Personaje, velocidad,
					fuerza, resistencia, destreza);
		} else {
			personaje = new Villano(nombreCivil, nombre_Personaje, velocidad,
					fuerza, resistencia, destreza);
		}
		this.personajes.put(nombre_Personaje, personaje);
		System.out.println("Su personaje fue creado y guardado exitosamente !");

	}

	public void listarPersonajes() {
		Iterator<Entry<String, Combatiente>> itr = this.personajes.entrySet()
				.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().getValue());
		}
	}

	public void guardarEnArchivoPersonajes() {
		try {
			FileWriter archivo = new FileWriter("personajes.in.txt");
			BufferedWriter escritor = new BufferedWriter(archivo);
			Iterator<Entry<String, Combatiente>> itr = this.personajes
					.entrySet().iterator();
			while (itr.hasNext()) {
				escritor.write(itr.next().getValue().toString());
				escritor.newLine();
			}

			escritor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Los personajes fueron guardados en el archivo local personajes.in.txt" );

	}

	/**
	 * LIGAS
	 */

	public void ejecutarFuncionLigas() {
		System.out.println("1 - Carga desde archivo");
		System.out.println("2 - Crear liga");
		System.out.println("3 - Listado de ligas");
		System.out.println("4 - Guardar en archivo ligas");
		System.out.println("5 - Volver al menu");

		Scanner entrada = new Scanner(System.in);
		int eleccion = entrada.nextInt();
		switch (eleccion) {
		case 1: {
			cargaArchivoLiga();
			ejecutarFuncionLigas();
		}
		case 2: {
			crearLiga();
			ejecutarFuncionLigas();
		}
		case 3: {
			listarLigas();
			ejecutarFuncionLigas();
		}
		case 4: {
			guardarEnArchivoLiga();
			ejecutarFuncionLigas();
		}
		case 5: {
			menues();
		}default:
			System.err.println("Opcion no valida");
			ejecutarFuncionLigas();
		
		}
	}

	public void cargaArchivoLiga() {
		try {
			FileReader archivo = new FileReader("ligas.in.txt");
			BufferedReader lector = new BufferedReader(archivo);
			String oneLine = lector.readLine();

			while (oneLine != null) {
				String[] datos = oneLine.split(", ");
				for (String dato : datos) {
					Liga liga = null;
					String nombre = "Liga: " +dato;
					try {
					
					if (this.personajes.get(dato) != null) {

						liga = new Liga(nombre, this.personajes.get(dato)
									.getEquipo(),
										this.personajes.get(dato).getCaracteristica(
											Caracteristica.VELOCIDAD),
										this.personajes.get(dato).getCaracteristica(
											Caracteristica.FUERZA),
										this.personajes.get(dato).getCaracteristica(
											Caracteristica.RESISTENCIA),
										this.personajes.get(dato).getCaracteristica(
											Caracteristica.DESTREZA), null);
							liga.agregarCombatiente(personajes.get(dato));
							this.ligas.put(nombre, liga);
							
					}
					if (this.ligas.get(dato) != null) {

						liga = new Liga(
								 "Liga " +dato,
								this.ligas.get(dato).getEquipo(),
								(int) this.ligas.get(dato)
										.promediarHabilidades(
												Caracteristica.VELOCIDAD),
								(int) this.ligas.get(dato)
										.promediarHabilidades(
												Caracteristica.FUERZA),
								(int) this.ligas.get(dato)
										.promediarHabilidades(
												Caracteristica.RESISTENCIA),
								(int) this.ligas.get(dato).promediarHabilidades(
												Caracteristica.DESTREZA),
								this.ligas.get(dato).getCombatientes());
						this.ligas.put(dato, liga);
					}
					} catch (NoSuchElementException e) {
						e.getMessage();

					} catch (NullPointerException e) {
						e.getMessage();

					}

				}

				oneLine = lector.readLine();
			}

			lector.close();
			System.out.println("Las ligas han sido cargadas !");

		} catch (FileNotFoundException e) {
			System.err.println("No se encontro archivo 'Ligas.in'");
		} catch (IOException e) {
			System.err.println("No se encontro archivo 'Ligas.in'");
		}
	}

	public void crearLiga() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese nombre de la liga: ");
		String nombreLiga = entrada.nextLine();

		System.out.println("Ingrese nombre de personaje a agregar: ");
		String nombre_Personaje = entrada.nextLine();

		if (this.personajes.containsValue(nombre_Personaje)) {
			Combatiente combatiente = this.personajes
					.get(nombre_Personaje);
			Liga liga = new Liga(nombreLiga, combatiente.getEquipo(),
					combatiente.getCaracteristica(Caracteristica.VELOCIDAD),
					combatiente.getCaracteristica(Caracteristica.FUERZA),
					combatiente.getCaracteristica(Caracteristica.RESISTENCIA),
					combatiente.getCaracteristica(Caracteristica.DESTREZA),
					null);
			liga.agregarCombatiente(combatiente);
			ligas.put(nombreLiga, liga);
			System.out.println("Se encontro al personaje indicado y fue agregado a la liga");
		} else {
			agregarCombatienteALiga(nombreLiga, nombre_Personaje);

		}
		System.out.println("Su liga fue creada y guardado exitosamente !");

	}

	public void agregarCombatienteALiga(String nombreLiga,
			String nombre_Personaje) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("No se encontro el personaje " + nombre_Personaje
				+ " pero ahora sera primer miembro de esta liga segun su tipo");

		System.out.println(nombre_Personaje + " " + "sera HEROE o VILLANO?");
		Equipo tipo_De_Liga = Equipo.valueOf(entrada.nextLine().toUpperCase());

		System.out.println("Ingrese nivel de Velocidad: ");
		int velocidad = entrada.nextInt();
		System.out.println("Ingrese nivel de Fuerza: ");
		int fuerza = entrada.nextInt();
		System.out.println("Ingrese nivel de Resistencia: ");
		int resistencia = entrada.nextInt();
		System.out.println("Ingrese nivel de Destreza: ");
		int destreza = entrada.nextInt();
		Combatiente combatiente = null;
		if (tipo_De_Liga == Equipo.HEROE) {
			combatiente = new Heroe(nombre_Personaje, nombre_Personaje,
					velocidad, fuerza, resistencia, destreza);
			this.personajes.put(nombre_Personaje, combatiente);
		} else {
			combatiente = new Villano(nombre_Personaje, nombre_Personaje,
					velocidad, fuerza, resistencia, destreza);
			this.personajes.put(nombre_Personaje, combatiente);

		}
		Liga liga = new Liga(nombreLiga, tipo_De_Liga, velocidad, fuerza,
				resistencia, destreza, null);
		liga.agregarCombatiente(combatiente);
		this.ligas.put(nombreLiga, liga);
	}

	public void listarLigas() {
		System.out.println("Las ligas son: ");
		Iterator<Entry<String, Liga>> itr = this.ligas.entrySet().iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().getKey());

		}
	}
	
	
	public void guardarEnArchivoLiga() {
		try {
			FileWriter archivo = new FileWriter("ligas.in.txt");
			BufferedWriter escritor = new BufferedWriter(archivo);
			Iterator<Entry<String, Liga>> itr = this.ligas.entrySet()
					.iterator();
			while (itr.hasNext()) {
				escritor.write(itr.next().getValue().getNombre());
				escritor.newLine();
			}

			escritor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Las ligas fueron guardadas en el archivo local ligas.in.txt" );

	}

	
	
	/**
	 * BATALLAR
	 */
	public void ejecutarFuncionBatallar() {
		System.out.println("1 - Batalla 1 vs 1");
		System.out.println("2 - Batalla 1 vs Liga");
		System.out.println("3 - Batalla Liga vs Liga");
		System.out.println("4 - Volver al menu");

		Scanner entrada = new Scanner(System.in);
		int eleccion = entrada.nextInt();
		switch (eleccion) {
		
		case 1: {
			entrada = new Scanner(System.in);
			System.out.println("Ingrese nombre de personaje: ");
			String nombrePersonaje = entrada.nextLine();
			
			System.out.println("Ingrese nombre de combatiente a enfrentar: ");
			String nombreContrincante = entrada.nextLine();
			
			System.out.println("Ingrese caracteristica a determinar ganador: ");
			Caracteristica c = Caracteristica.valueOf(entrada.nextLine().toUpperCase());
			batallar1Contra1(this.personajes,nombrePersonaje, nombreContrincante, c);
			ejecutarFuncionBatallar();
			entrada.close();

		}
		case 2: {
			entrada = new Scanner(System.in);
			System.out.println("Ingrese nombre de personaje: ");
			String nombrePersonaje = entrada.nextLine();
			System.out.println("Ingrese nombre de liga a enfrentar: ");
			String nombreLiga = entrada.nextLine();
			System.out.println("Ingrese bajo que caracteristica combatiran: ");
			Caracteristica c = Caracteristica.valueOf(entrada.nextLine()
					.toUpperCase());
			batallar1ContraLiga(this.personajes,this.ligas,nombrePersonaje, nombreLiga, c);
			ejecutarFuncionBatallar();
			entrada.close();
		}
		case 3: {
			entrada = new Scanner(System.in);
			System.out.println("Ingrese nombre de liga: ");
			String nombreLiga1 = entrada.nextLine();
			System.out.println("Ingrese nombre de liga a quien enfrentará: "
					+ nombreLiga1);
			String nombreLiga2 = entrada.nextLine();
			System.out.println("Ingrese bajo que caracteristica combatiran: ");
			Caracteristica c = Caracteristica.valueOf(entrada.nextLine()
					.toUpperCase());
			batallarLigaContraLiga(this.ligas,nombreLiga1, nombreLiga2, c);
			ejecutarFuncionBatallar();
			entrada.close();
		}
		case 4: {
			menues();
		}
		default:
			System.err.println("Opcion no valida");
			ejecutarFuncionBatallar();
		}
		entrada.close();
	}

	public void batallar1Contra1(HashMap<String,Combatiente> personajes,String personaje1, String personaje2,
			Caracteristica c) {
		try {
			Combatiente c1 = personajes.get(personaje1);
			Combatiente c2 = personajes.get(personaje2);
			c1.esGanador(c2, c);
		} catch (NoSuchElementException e) {
			System.err.println("No se encontro al personaje");
		}
	}

	public void batallar1ContraLiga(HashMap<String,Combatiente> personajes, HashMap<String,Liga> ligas
			,String personaje1, String nombreLiga,
			Caracteristica c) {

		try {
			personajes.get(personaje1).esGanador(ligas.get(nombreLiga), c);

		} catch (NoSuchElementException e) {
			System.err.println("No se encontro al personaje o liga");
		}
	}

	public void batallarLigaContraLiga(HashMap<String,Liga> ligas,
			String liga1, String liga2,
			Caracteristica c) {
		try {
			ligas.get(liga1).esGanador(ligas.get(liga2), c);

		} catch (NoSuchElementException e) {
			System.err.println("");
		}
	}

	/**
	 * REPORTE
	 */

	private void listarOpcionesReporte() {
		System.out.println("1 - Obtener combatientes que derroten a un combatiente determinado");
		System.out.println("2 - Listado ordenado de combatiente por determinada caracxteristica");
		System.out.println("3 - Volver al menu");
	}
	
	public void ejecutarFuncionReporte() {
		Scanner entrada = new Scanner(System.in);
		
		listarOpcionesReporte();
		int opcion = entrada.nextInt();
		while(opcion != BACK) {
			System.out.println("En while reportes");//LOGS
			switch (opcion) {
				case 1: {
					Caracteristica c1;
					entrada = new Scanner(System.in);
					System.out.println("Ingresar nombre del combatiente: ");
					String nombre = entrada.nextLine();
					
					System.out.println("Ingrese caracteristica: ");
					String carac = entrada.nextLine();
					try {
						c1 = Caracteristica.valueOf(carac.toUpperCase());
					}catch(IllegalArgumentException E){
						System.err.println("Caracteristica invalida");
						entrada.close();
						return;
					}
					
					String resultado = reporteCombatientesQueGananAOtroCombatiente(this.personajes, this.ligas,
							nombre, c1);
					
					System.out.println(resultado);
					
					listarOpcionesReporte();
					opcion = entrada.nextInt();
					break;
				}
				case 2:{ 
					reporteCombatientesPorCaracteristicas();
					
					//ingresarOpcion();
					listarOpcionesReporte();
					opcion = entrada.nextInt();
					break;
				}
				case 3: { 
					return;
				}
				default: {
					System.err.println("Opcion no valida");
					//ejecutarFuncionReporte();
					listarOpcionesReporte();
					opcion = entrada.nextInt();
					break;
				}
			}
		}
	}

	private String reporteCombatientesQueGananAOtroCombatiente(HashMap<String,Combatiente> listaPersonajes, HashMap<String,Liga> listaLigas
			,String combatiente, Caracteristica c) {
		Comparator<Combatiente> comp;
		String resultado = "Los combatientes que vencen a " + combatiente;
		Combatiente c1;
		
		try {
			c1 = listaPersonajes.get(combatiente);
			if(c1 == null) {
				throw new NullPointerException();
			}
		}catch(NullPointerException E) {
			System.err.println("Combatiente ingresado no existe");
			return "Error";
		}
		resultado = resultado +  "(" + c1.getCaracteristica(c) + ") son : ";
		
		Iterator<Entry<String, Combatiente>> itr1 = listaPersonajes.entrySet().iterator();
		Iterator<Entry<String, Liga>> itr2 = listaLigas.entrySet().iterator();
		
		switch(c) {
			case FUERZA:
				comp = new ComparadorPorFuerza();
				System.out.println("Comparamos por fuerza"); 
				while (itr1.hasNext()) {
					Combatiente otroComb = itr1.next().getValue();
					if (comp.compare(listaPersonajes.get(combatiente),otroComb) < 0) {
						resultado += ", " +otroComb.getNombre() + "(Fza: " + otroComb.getCaracteristica(c) + ") ";
					}
				}
				break;
			case VELOCIDAD:
				comp = new ComparadorPorVelocidad();
				System.out.println("Comparamos por velocidad"); 
				while (itr1.hasNext()) {
					Combatiente otroComb = itr1.next().getValue();
					if (comp.compare(listaPersonajes.get(combatiente),otroComb) < 0) {
						resultado += ", " +otroComb.getNombre() + "(Vel: " + otroComb.getCaracteristica(c) + ") ";
					}
				}
				break;
			case DESTREZA:
				comp = new ComparadorPorDestreza();
				System.out.println("Comparamos por destreza"); 
				while (itr1.hasNext()) {
					Combatiente otroComb = itr1.next().getValue();
					if (comp.compare(listaPersonajes.get(combatiente),otroComb) < 0) {
						resultado += ", " +otroComb.getNombre() + "(Dest: " + otroComb.getCaracteristica(c) + ") ";
					}
				}
				break;
			case RESISTENCIA:
				comp = new ComparadorPorResistencia();
				System.out.println("Comparamos por resistencia"); 
				while (itr1.hasNext()) {
					Combatiente otroComb = itr1.next().getValue();
					if (comp.compare(listaPersonajes.get(combatiente),otroComb) < 0) {
						resultado += ", " +otroComb.getNombre() + "(Res: " + otroComb.getCaracteristica(c) + ") ";
					}
				}
				break;
			default:
				System.out.println("Caso por defecto");//logs
				break;
		}
		/*while (itr2.hasNext()) {
			Liga otraLiga = itr2.next().getValue();//@todo cambiar forma de cargar ligas para que se puedan comparar ligas correctamente
			if (compFuerza.compare(listaLigas.get(combatiente), otraLiga) < 0) {
				nombres += ", " + otraLiga.getNombre();
			}
		}*/
		
		return resultado;
	}

	private void reporteCombatientesPorCaracteristicas() {
		PriorityQueue<Combatiente> reporte = new PriorityQueue<Combatiente>();
		
		Combatiente urukhai = new Heroe("Orco","Uruk-hai", 1, 80, 40, 4);//@test, en realidad deben cargarse los del archivo
		Combatiente merry = new Heroe("Meriadoc","Merry", 1, 80, 40, 4);
		Combatiente pipin = new Heroe("Peregrin","Pipin", 1, 80, 40, 5);
		Combatiente sam = new Heroe("Samsagaz","Sam", 1, 90, 40, 1);
		Combatiente frodo = new Heroe("Frodo","El portador", 1, 90, 50, 1);
		Combatiente morgoth = new Villano("Morgoth", "Senior oscuro", 1, 98, 2, 98);
		Combatiente aragorn = new Heroe("Aragorn","El heredero", 1, 99, 1, 99);
		Combatiente sauron = new Villano("Sauron", "El nigromante",98, 2, 98, 2);
		Combatiente gandalf = new Heroe("Gandalf","El blanco",99, 1, 99, 1);

		reporte.add(urukhai);
		listarCombatientes(reporte);
		System.out.println("--------------------");
		reporte.add(merry);
		listarCombatientes(reporte);
		System.out.println("--------------------");
		reporte.add(pipin);
		listarCombatientes(reporte);
		System.out.println("--------------------");
		reporte.add(sam);
		listarCombatientes(reporte);
		System.out.println("--------------------");
		reporte.add(frodo);
		listarCombatientes(reporte);
		System.out.println("--------------------");
		
		reporte.add(aragorn);
		listarCombatientes(reporte);
		System.out.println("--------------------");
		reporte.add(morgoth);
		listarCombatientes(reporte);
		System.out.println("--------------------");
		reporte.add(sauron);
		reporte.add(gandalf);

	}
	
	private void listarCombatientes(Queue<Combatiente> cola) {
		Iterator<Combatiente> itr1 = cola.iterator();
		
		while(itr1.hasNext()) {
			System.out.println(itr1.next());
		}
	}

}
