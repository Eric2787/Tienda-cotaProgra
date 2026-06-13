package Modelo;

/**
 * Clase que representa a una Serpiente, heredando de Animal.
 */
public class Serpiente extends Animal {
	// Atributos de la clase Serpiente 🐍
	private String paisOrigen;
	// Getters y Setters

	/**
	 * Obtiene el país de origen de la serpiente.
	 *
	 * @return El país de origen.
	 */
	public String getPaisOrigen() {
		return paisOrigen;
	}

	/**
	 * Establece el país de origen de la serpiente.
	 *
	 * @param paisOrigen El país de origen a establecer.
	 */
	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

}
