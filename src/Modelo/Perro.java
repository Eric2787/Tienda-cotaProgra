package Modelo;

/**
 * Clase que representa a un Perro, heredando de Animal.
 */
public class Perro extends Animal {
	// Atributos de la clase Perro 🐶

	private int perfil;

	// Getters y Setters

	/**
	 * Establece el perfil del perro.
	 *
	 * @param perfil El perfil a establecer.
	 */
	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}

	/**
	 * Obtiene el perfil del perro.
	 *
	 * @return El perfil del perro.
	 */
	public int getPerfil() {
		return perfil;
	}

}
