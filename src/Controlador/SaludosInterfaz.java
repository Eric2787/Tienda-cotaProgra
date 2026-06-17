package Controlador;

/**
 * Clase SaludosInterfaz.
 * Contiene la lógica y atributos correspondientes a la entidad o controlador SaludosInterfaz en el sistema.
 */
public interface SaludosInterfaz {
	/**
	 * Muestra un saludo específico basado en el perfil del animal.
	 *
	 * @param perfil El perfil del animal.
	 */
	void Saludar(int perfil);

	/**
	 * Muestra un saludo general del animal interactuando con el usuario.
	 */
	void Saludar();
}
