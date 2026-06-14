package Modelo;

/**
 * Clase que representa a un Pez, heredando de Animal.
 */
public class Pez  extends Animal{
	// Atributos de la clase Pez
	private boolean tipoAgua;

	/**
	 * Indica el tipo de agua del pez (ej. true para dulce, false para salada).
	 *
	 * @return true si es de un tipo, false para otro.
	 */
	public boolean getTipoAgua() {
		return tipoAgua;
	}

	/**
	 * Establece el tipo de agua del pez.
	 *
	 * @param tipoAgua El tipo de agua a establecer.
	 */
	public void setTipoAgua(boolean tipoAgua) {
		this.tipoAgua = tipoAgua;
	}
}
