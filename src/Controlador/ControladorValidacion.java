package Controlador;

/**
 * Controlador para la validación de entrada de datos, asegurando
 * que los tipos de datos introducidos por el usuario sean correctos.
 */
public class ControladorValidacion{
	/**
	 * Constructor por defecto.
	 */
	public ControladorValidacion() {
	}

	/**
	 * Valida si una cadena de texto puede ser convertida a un número entero.
	 *
	 * @param cadena La cadena de texto a validar.
	 * @return true si la cadena es un número entero válido, false de lo contrario.
	 */
	public boolean valEntero(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		}catch(NumberFormatException e){
			return false;
		}
	}

	/**
	 * Valida si una cadena de texto puede ser convertida a un número de punto flotante.
	 *
	 * @param cadena La cadena de texto a validar.
	 * @return true si la cadena es un número de punto flotante válido, false de lo contrario.
	 */
	public boolean valFloat(String cadena){
		try {
			Float.parseFloat(cadena);
			return true;
		}catch(NumberFormatException e){
			return false;
		}
	}

	/**
	 * Valida si una cadena de texto puede ser convertida a un número de doble precisión.
	 *
	 * @param cadena La cadena de texto a validar.
	 * @return true si la cadena es un número de doble precisión válido, false de lo contrario.
	 */
	public boolean valDouble(String cadena){
		try {
			Double.parseDouble(cadena);
			return true;
		}catch(NumberFormatException e){
			return false;
		}
	}
}
