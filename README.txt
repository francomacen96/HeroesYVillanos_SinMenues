a. Nombres de los integrantes del grupo


Integrantes del grupo:

- Aguilar Leandro
- Castro Samuel Alejandro
- Macén Franco
- Servile Luciano


b. Decisiones de diseño tomadas


Diagrama de UML: 
Tenemos dos sectores, en el primero se incluirán las clases: 
	Sistema: Donde los archivos seran leidos y redistribuidos en cada funcion. 
	Menu Principal, ItemAbstracto, ItemSimple, SubMenu: Donde mostraran una interfaz para que el Usuario/Cliente pueda acceder e interactuar con el programa.

El segundo sector seran: Combatiente, Liga, Heroe, Villano, Caracteristica, Equipo. Donde se podran crear clases de cada uno y llenando sus parametros con la informacion distribuida del Sistema.

Para la implementación del menu principal, se decidió implementar el patron de diseño Singleton, ya que se prefiere que la clase MenuPrincipal sea instanciada unicamente una vez. MenuPrincipal a su vez llamará a la clase SubMenu ya que posee sus mismas característiicas.
Luego, para las diferentes opciones y submenues, se utilizará un patron Composite con una estructura de clases como la detallada a continuación: @todo cambiar ItemSimple

ItemAbstracto (abstract)
        ^
        |
        |
  _______________
 |               |
 |               |
ItemSubMenu    ItemSimple(abstract) 
               ^     ^         ^
		       |     |         |
		       |     |         |
	 Ej:  Opcion1  Opcion2   [Opcion...n]

La clase abstracta ItemAbstracto integrará todos las las clases relativas a menúes, opciones y submenúes. Su método abstracto ejecutarFuncion()  será el que se implemente por las diferentes clases hijas de modo que cada una de ellas ejecutará una función de acuerdo a lo necesario.
ItemSubMenu será una clase concreta cuyo ejecutarFuncion() será listarOpciones() que displayará por donde corresponda (consola) las diferentes opciones de 
que el mismo contenga, sean opciones simples o más submenues. Contendrá un array de variables ItemAbstracto.
Cada uno de los submenúes necesarios será buildeado como un ItemSubMenu y se le agregarán al arraylist las opciones necesarias.
ItemSimple será una clase abstracta cuyo método sin implementar será ejecutarFuncion(). Será a su vez heredado por las distintas opciones a utilizar en el programa, las cuales serán opciones simples (no serán submenúes) e implementarán ejecutarFuncion cada una a su manera.


c. Descripción de cada archivo *.java comprendido en solución del problema

Sistema: Donde los archivos seran leidos y redistribuidos en cada funcion. Tiene como atributos un HashMap<String, Combatiente> personajes,un HashSet<Combatiente> liga_heroesy un HashSet<Combatiente> liga_villanos donde seran guardados los datos del archivo .txt .Tiene dos metodos: leerArchivoPersonaje(), leerArchivosLiga().

Menu Principal: Es un aclase concreta que crea un ItemSubMenu con una llamada única (Singleton). Incluirá las opciones del primer menú.

ItemAbstracto: Es una clase abstracta que incluirá el método ejecutarFuncion implementado por sus clases hijas.

ItemSubMenu: Clase concreta heredada de ItemAbstracto que contendrá un array de variables ItemAbstracto e implementará la función ejecutarFuncion, cuyo funcionamiento será siempre, para las instancias a esta clase, llamar al método listarOpciones.

ItemSimple: Clase abstracta de la cual se heredarán las sucesivas opciones a utilizar en el programa, cada una de las cuales implementará ejecutarFuncion a su manera. @todo cambiar itemSimple

Combatiente: La clase Combatiente es una clase abstracta y es la superclase de Liga, Heroe y Villano. Tiene como atributos un nombre, velocidad, fuerza, resitencia, deztreza. Su metodo esGanador() determinara quien es el que tiene mas velocidad, fuerza, resitencia o deztreza, comparando a otro Combatiente.

Liga: Clase hija de Combatiente, La Liga tendra como atributos un nombre, velocidad, fuerza, resitencia, deztreza. Y ademas, un HashMap de Combatientes. 

Heroe: Clase hija de Combatiente, el Heroe tendra como atributos un nombre, velocidad, fuerza, resitencia, deztreza. Y ademas, un nombre civil. Su metodo esGanador() determinara quien es el que tiene mas velocidad, fuerza, resitencia o deztreza, comparando a otro Combatiente.

Villano: Clase hija de Combatiente, el Villano tendra como atributos un nombre, velocidad, fuerza, resitencia, deztreza. Clase hija de Combatiente, el Heroe tendra un nombre, un alias, velocidad, fuerza, resitencia, deztreza.Su metodo esGanador() determinara quien es el que tiene mas velocidad, fuerza, resitencia o deztreza, comparando a otro Combatiente.

Caracteristica: Clase enum donde podran elegirse entre VELOCIDAD, DESTREZA, FUERZA, RESISTENCIA. Tiene un  método publico "nextCaracteristica" que dada una caracteristica, te devuelve la siguiente en la lista de prioridad.

Equipo: Clase enum donde podran elegirse entre HEROE o VILLANO


d. Conclusiones


------------