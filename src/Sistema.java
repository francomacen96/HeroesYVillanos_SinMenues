
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Sistema {

	//private HashMap<String, Combatiente> personajes;
	//private HashSet<Combatiente> liga_heroes;
	//private HashSet<Combatiente> liga_villanos;
	private int opcionMenu;

	public static void main(String[] args) {
		Sistema s = new Sistema();
		//s.leerArchivoPersonajes();
		//s.leerArchivoLiga();

		s.menues();
	}

	/*private void leerArchivoPersonajes() {

		this.personajes = new HashMap<String, Combatiente>();

		try {
			FileReader archivo = new FileReader("personajes.in.txt");
			BufferedReader lector = new BufferedReader(archivo);
			String oneLine = lector.readLine();

			while (oneLine != null) {
				String[] datos = oneLine.split(", ");
				Equipo tipo_De_Personaje = Equipo.valueOf(datos[0].toUpperCase());;
				String nombre_Real = datos[1];
				String nombre_Personaje = datos[2];
				int velocidad = Integer.parseInt(datos[3]);
				int fuerza = Integer.parseInt(datos[4]);
				int resistencia = Integer.parseInt(datos[5]);
				int destreza = Integer.parseInt(datos[6]);

				Combatiente personaje = null;
				if(tipo_De_Personaje == Equipo.HEROE || tipo_De_Personaje == Equipo.HÉROE) {
					personaje = new Heroe(nombre_Real, nombre_Personaje, velocidad, fuerza, resistencia, destreza);

				} else {
					personaje = new Villano(nombre_Real, nombre_Personaje, velocidad, fuerza,
							resistencia, destreza);
				}
				
				personajes.put(nombre_Personaje, personaje);


				oneLine = lector.readLine();
			}

			lector.close();
		} catch (FileNotFoundException e) {
			System.err.println("No se encontro archivo 'personajes.in'");
		} catch (IOException e) {
			System.err.println("No se encontro archivo 'personajes.in'");
		}
	}*/

	/*private void leerArchivoLiga() {

		this.liga_heroes = new HashSet<Combatiente>();
		this.liga_villanos = new HashSet<Combatiente>();

		try {
			FileReader archivo = new FileReader("ligas.in.txt");
			BufferedReader lector = new BufferedReader(archivo);
			String oneLine = lector.readLine();

			while (oneLine != null) {
				String[] datos = oneLine.split(", ");
				for (String dato : datos) {
					if (personajes.get(dato).getEquipo() == Equipo.HEROE) {
						liga_heroes.add(personajes.get(dato));

					} else {
						liga_villanos.add(personajes.get(dato));

					}

				}

				oneLine = lector.readLine();
			}

			lector.close();
		} catch (FileNotFoundException e) {
			System.err.println("No se encontro archivo 'Ligas.in'");
		} catch (IOException e) {
			System.err.println("No se encontro archivo 'Ligas.in'");
		}
	}*/
	
	private void menues() {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader);
		
		
		listarOpciones();
		
		this.opcionMenu = ingresarOpcion(in);
		
		while(this.opcionMenu != 100) {
			switch(this.opcionMenu) {
			case 0:
				this.opcionMenu = menuPrincipal();
				break;
			case 1:
				this.opcionMenu = menuBatallar();
				break;
			case 100:
				System.exit(0);
			default:
				System.out.println("Opcion no valida");
				this.opcionMenu = 0;
				break;
			}
			this.opcionMenu = ingresarOpcion(in);
		}
		if(this.opcionMenu != 100)
			listarOpciones();
	}
	
	private int menuPrincipal() {
		System.out.println("Permaneci en menu principal");
		return 1;
	}
	
	private int menuBatallar() {
		System.out.println("Entre en menu batallar, salgo");
		return 0;
	}
	
	private void listarOpciones() {
		System.out.println("Menu principal");
		System.out.println("0 - Permanecer");
		System.out.println("1 - menuBatallar");
		System.out.println("100 - Salir");
		
	}
	
	private int ingresarOpcion(BufferedReader in) {
		String entrada = "";
		int entradaInt;
		try {
			entrada = in.readLine();
		}catch(IOException E) {
			System.err.println(E);
		}
		System.out.println("la entrada es : " + entrada);
		entradaInt = Integer.parseInt(entrada);
		
		return entradaInt;
	}
}