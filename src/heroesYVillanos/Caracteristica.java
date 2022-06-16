package heroesYVillanos;

public enum Caracteristica {

	VELOCIDAD, FUERZA, DESTREZA, RESISTENCIA;

	public Caracteristica nextCaracteristica(Caracteristica c) {
		Caracteristica resultado = c;
		switch (c) {
		case VELOCIDAD: {
			resultado = FUERZA;
			break;
		}
		case FUERZA: {
			resultado = RESISTENCIA;
			break;
		}
		case RESISTENCIA: {
			resultado = DESTREZA;
			break;
		}
		case DESTREZA: {
			resultado = VELOCIDAD;
			break;
		}
		}
		return resultado;
	}
}
