package Modelo;

/**
 * Clase que representa a una Araña, heredando de Animal.
 */
public class Arania extends  Animal {
	// Atributos de la clase Arania 🕷️

	private boolean venenosa;

	// Getters y Setters

	/**
	 * Indica si la araña es venenosa.
	 *
	 * @return true si es venenosa, false de lo contrario.
	 */
	public boolean getVenenosa() {
		return venenosa;
	}

	/**
	 * Establece si la araña es venenosa.
	 *
	 * @param venenosa true si es venenosa, false de lo contrario.
	 */
	public void setVenenosa(boolean venenosa) {
		this.venenosa = venenosa;
	}
}
