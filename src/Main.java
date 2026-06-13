import Vista.Menu;

import java.io.IOException;

/**
 * Clase principal que inicia la ejecución de la aplicación de la tienda de mascotas.
 */
public class Main {
	/**
	 * Método principal que sirve como punto de entrada de la aplicación.
	 * Instancia el menú y lo muestra al usuario.
	 *
	 * @param args Argumentos de la línea de comandos.
	 * @throws IOException Si ocurre un error de entrada/salida.
	 * @throws ClassNotFoundException Si no se encuentra una clase al leer objetos serializados.
	 */
	public static void main (String[] args) throws IOException, ClassNotFoundException {
		Menu menu = new Menu();
		menu.mostrarMenu();
	}
}
