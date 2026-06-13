package Modelo;

/**
 * Clase que representa a un Gato, heredando de Animal.
 */
public class Gato extends Animal{
	// Atributos de la clase Gato 🐱

	private int colorOjos;

	/**
	 * Obtiene el código del color de los ojos del gato.
	 *
	 * @return Código de color de ojos.
	 */
	public int getColorOjos() {
		return colorOjos;
	}

	/**
	 * Establece el código del color de los ojos del gato.
	 *
	 * @param colorOjos Código de color de ojos a establecer.
	 */
	public void setColorOjos(int colorOjos) {
		this.colorOjos = colorOjos;
	}


}
