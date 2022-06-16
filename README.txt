a. Nombres de los integrantes del grupo


Integrantes del grupo:

- Aguilar Leandro
- CastroSamuel Alejandro
- Macén Franco
- Servile Luciano


b. Decisiones de diseño tomadas


Diagrama de UML: 
Tenemos dos sectores, en el primero se incluirán las clases: 
	Sistema: Donde los archivos seran leidos y redistribuidos en cada funcion. 
	Menu Principal, ItemAbstracto, ItemSimple, SubMenu: Donde mostraran una interfaz para que el Usuario/Cliente pueda acceder e interactuar con el programa.

El segundo sector seran: Combatiente, Liga, Heroe, Villano, Caracteristica, Equipo. Donde se podran crear clases de cada uno y llenando sus parametros con la informacion distribuida del Sistema.

Para la implementación del menu principal, se decidió llamar desde la clase Sistema a un método menues() que irá listando las opciones correspondientes a cada submenu e irá llamando al submenú u opción seleccionada por el usuario.

c. Descripción de cada archivo *.java comprendido en solución del problema

Sistema: Donde los archivos seran leidos y redistribuidos en cada funcion. Tiene como atributos un HashMap<String, Combatiente> personajes,un HashSet<Combatiente> liga_heroesy un HashSet<Combatiente> liga_villanos donde seran guardados los datos del archivo .txt .Tiene dos metodos: leerArchivoPersonaje(), leerArchivosLiga().

Combatiente: La clase Combatiente es una clase abstracta y es la superclase de Liga, Heroe y Villano. Tiene como atributos un nombre, velocidad, fuerza, resitencia, deztreza. Su metodo esGanador() determinara quien es el que tiene mas velocidad, fuerza, resitencia o deztreza, comparando a otro Combatiente.

Liga: Clase hija de Combatiente, La Liga tendra como atributos un nombre, velocidad, fuerza, resitencia, deztreza. Y ademas, un HashMep de Combatientes. 

Heroe: Clase hija de Combatiente, el Heroe tendra como atributos un nombre, velocidad, fuerza, resitencia, deztreza. Y ademas, un nombre civil. Su metodo esGanador() determinara quien es el que tiene mas velocidad, fuerza, resitencia o deztreza, comparando a otro Combatiente.

Villano: Clase hija de Combatiente, el Villano tendra como atributos un nombre, velocidad, fuerza, resitencia, deztreza. Clase hija de Combatiente, el Heroe tendra un nombre, un alias, velocidad, fuerza, resitencia, deztreza.Su metodo esGanador() determinara quien es el que tiene mas velocidad, fuerza, resitencia o deztreza, comparando a otro Combatiente.

Caracteristica: Clase enum donde podran elegirse entre VELOCIDAD, DESTREZA, FUERZA, RESISTENCIA

Equipo: Clase enum donde podran elegirse entre HEROE o VILLANO


d. Conclusiones


------------