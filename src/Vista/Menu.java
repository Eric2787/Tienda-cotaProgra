package Vista;

import Controlador.*;
import Modelo.*;
import Almacenamiento.*;

import java.io.IOException;
import java.util.Scanner;

/**
 * Clase que gestiona la interfaz de usuario en consola para el sistema de la tienda de mascotas.
 */
public class Menu {
	// Variables de control
	int aux = -1;
	int i = 0;
	int i2 = 0;
	int opc, opc2 = 0;
	//Variables de caracteristicas de animales
	String nombre, color, raza, paisOrigen, alimentacion, modoReproduccion;
	int edad;
	float tamanio, peso, precio;
	int perfil, colorOjos;
	boolean toxicidad, tipoAgua, sexo;

	// Controladores
	ControladorPerro controladorPerro = new ControladorPerro();
	ControladorGato controladorGato = new ControladorGato();
	ControladorPez controladorPez = new ControladorPez();
	ControladorArania controladorArania = new ControladorArania();
	ControladorSerpiente controladorSerpiente = new ControladorSerpiente();

	ControladorBD controladorBD = new ControladorBD();

	ControladorValidacion controladorValidacion = new ControladorValidacion();

	/**
	 * Muestra el menú principal de la aplicación e interactúa con el usuario para realizar las distintas operaciones.
	 *
	 * @throws IOException Si ocurre un error de entrada/salida.
	 * @throws ClassNotFoundException Si no se encuentra la clase al leer los objetos serializados.
	 */
	public void mostrarMenu() throws IOException, ClassNotFoundException{
		Scanner lectorInt = new Scanner(System.in);
		Scanner lectorString = new Scanner(System.in);
		Scanner lectorFloat = new Scanner(System.in);

		do {
			controladorBD.cargarBD();

			System.out.println("Bienvenido a la tienda de +KOTA");
			System.out.println("Nuestro menú es: ");
			System.out.println("1. Registrar animal");
			System.out.println("2. Vender una animal");
			System.out.println("3. Consultar stock");
			System.out.println("(Total de animales en stock)");
			System.out.println("4. Consultar ventas");
			System.out.println("5. Respaldar base de datos");
			System.out.println("6. Cargar base de datos");
			System.out.println("7. Saludar");
			System.out.println("8. salir");
			i = lectorInt.nextInt();

			switch (i) {
				case 1:
					System.out.println("1. Registrar un perro");
					System.out.println("2. Registrar un gato");
					System.out.println("3. Registrar un pez");
					System.out.println("4. Registrar un araña");
					System.out.println("5. Registrar un serpiente");
					System.out.println("6. Volver");
					i2 = lectorInt.nextInt();
					switch (i2) {
						case 1:
							System.out.println("Se van a registrar un perro");
							// Parametros pedidos al usuario
							System.out.println("Ingresa el nombre del perro");
							nombre = lectorString.nextLine();

							System.out.println("Ingresa la edad del perro");
							edad = lectorInt.nextInt();

							System.out.println("Ingresa el color del perro");
							color = lectorString.nextLine();

							System.out.println("Ingresa la raza del perro");
							raza = lectorString.nextLine();

							System.out.println("Ingresa el tamaño del perro");
							tamanio = lectorFloat.nextFloat();

							System.out.println("Ingresa el peso del perro");
							peso = lectorFloat.nextFloat();

							System.out.println("Ingresa el precio del perro");
							precio = lectorFloat.nextFloat();

							System.out.println("Ingresa el perfil del perro");
							System.out.println("1. Semental");
							System.out.println("2. Mascota");
							System.out.println("3. Policia");
							System.out.println("4. Apoyo a invidentes");
							perfil = lectorInt.nextInt();

							System.out.println("Ingrese el sexo del perro");
							System.out.println("1. Macho");
							System.out.println("2. Hembra");
							int opc = lectorInt.nextInt();

							if (opc == 1) {
								sexo = true;
							} else {
								sexo = false;
							}

							System.out.println("Ingrese el tipo de alimentacion");
							System.out.println("1. Es carnivoro");
							System.out.println("2. Es herbiboro");
							System.out.println("3. Es omnivoro");
							opc = lectorInt.nextInt();
						/**
						 * Método alimentacion.
						 *
						 * Ejecuta la acción del método alimentacion.
						 */
							alimentacion(opc);

							controladorPerro.registrarPerro(nombre, edad, color, raza, tamanio, peso, precio, perfil, sexo, alimentacion);
							controladorBD.respaldarBD();
							break;

						case 2:
							System.out.println("Se va a registrar un gato");
							// Parametros pedidos al usuario
							System.out.println("Ingresa el nombre del gato");
							nombre = lectorString.nextLine();
							while (true) {
								System.out.println("Ingresa la edad del gato");
								String pso = lectorString.nextLine();
								if (controladorValidacion.valEntero(pso)) {
									edad = Integer.parseInt(pso);
									break;
								} else {
									System.out.println("Ingresa un numero correcto");
								}
							}

							while (true) {
								System.out.println("Ingresa el tamaño en CM");
								String pso = lectorString.nextLine();
								if (controladorValidacion.valEntero(pso) && Integer.parseInt(pso) > 12) {
									tamanio = Integer.parseInt(pso);
									break;
								} else {
									System.out.println("El gato no puede ser registrado");
									System.out.println("Revisa que sea un numero mayor o igual a 12");
								}
							}

							while (true) {
								System.out.println("Ingresa el peso del gato");
								String pso = lectorString.nextLine();
								if (controladorValidacion.valFloat(pso)) {
									peso = Float.parseFloat(pso);
									break;
								} else {
									System.out.println("Ingresa un numero correcto");
								}
							}
							while (true) {
								System.out.println("Ingresa el precio del gato");
								String pso = lectorString.nextLine();
								if (controladorValidacion.valFloat(pso)) {
									precio = Float.parseFloat(pso);
									break;
								} else {
									System.out.println("Ingresa un numero correcto");
								}
							}

							System.out.println("Ingresa el color de ojos del gato");
							System.out.println("1. Azules");
							System.out.println("2. Verdes");
							System.out.println("3. Negros");
							System.out.println("4. Cafes");
							System.out.println("5. Grises");
							colorOjos = lectorInt.nextInt();

							System.out.println("Ingresa el sexo del gato");
							System.out.println("1. Macho");
							System.out.println("2. Hembra");
							int opc2 = lectorInt.nextInt();
							if (opc2 == 1) {
								sexo = true;
							} else {
								sexo = false;
							}

							System.out.println("Ingresa la raza del gato");
							raza = lectorString.nextLine();

							System.out.println("Ingresa la alimentacion del gato");
							System.out.println("1. Es carnivoro");
							System.out.println("2. Es herbiboro");
							System.out.println("3. Es omnivoro");
							opc2 = lectorInt.nextInt();
						/**
						 * Método alimentacion.
						 *
						 * Ejecuta la acción del método alimentacion.
						 */
							alimentacion(opc2);

							controladorGato.registrarGato(nombre, raza, edad, color, tamanio, peso, precio, sexo, alimentacion, colorOjos);
							controladorBD.respaldarBD();
							break;

						case 3:
							System.out.println("Se va a registrar un pez");
							System.out.println("Ingrese el nombre del pez");
							nombre = lectorString.nextLine();
							System.out.println("Ingrese la edad del pez");
							while (true) {
								String pso = lectorString.nextLine();
								if (controladorValidacion.valEntero(pso)) {
									edad = Integer.parseInt(pso);
									break;
								} else {
									System.out.println("Ingrese un numero valido");
								}
							}
							System.out.println("Ingrese el color del pez");
							color = lectorString.nextLine();
							System.out.println("Ingrese la raza del pez");
							raza = lectorString.nextLine();
							System.out.println("Ingrese el tamaño del pez");
							while (true) {
								String pso = lectorString.nextLine();
								if (controladorValidacion.valEntero(pso)) {
									tamanio = Float.parseFloat(pso);
									break;
								} else {
									System.out.println("Ingrese un numero valido");
								}
							}
							System.out.println("Ingrese el peso del pez");
							while (true) {
								String pso = lectorString.nextLine();
								if (controladorValidacion.valFloat(pso)) {
									peso = Float.parseFloat(pso);
									break;
								} else {
									System.out.println("Ingrese un numero valido");
								}
							}
							System.out.println("Ingrese el precio del pez");
							while (true) {
								String pso = lectorString.nextLine();
								if (controladorValidacion.valFloat(pso)) {
									precio = Float.parseFloat(pso);
									break;
								} else {
									System.out.println("Ingrese un numero valido");
								}
							}
							System.out.println("Ingrese el tipo de agua del pez");
							System.out.println("1. Salada");
							System.out.println("2. Dulce");
							int opc3 = lectorInt.nextInt();
							switch (opc3) {
								case 1:
									tipoAgua = true;
									break;
								case 2:
									tipoAgua = false;
									break;
								default:
									System.out.println("Ingrese una opcion valida");
									break;
							}
							System.out.println("Ingrese el sexo del pez");
							System.out.println("1. Macho");
							System.out.println("2. Hembra");
							opc3 = lectorInt.nextInt();
							if (opc3 == 1) {
								sexo = true;
							} else {
								sexo = false;
							}
							System.out.println("Ingrese la alimentación del pez");
							System.out.println("1. Es carnivoro");
							System.out.println("2. Es hervivoro");
							System.out.println("3. Es omnivoro");
							opc3 = lectorInt.nextInt();
						/**
						 * Método alimentacion.
						 *
						 * Ejecuta la acción del método alimentacion.
						 */
							alimentacion(opc3);

							controladorPez.registrarPez(nombre, edad, color, raza, tamanio, peso, precio, tipoAgua, sexo, alimentacion);
							controladorBD.respaldarBD();
							break;

						case 4:
							System.out.println("Se va a registrar una araña");
							System.out.println("Ingrese el nombre de la araña");
							nombre = lectorString.nextLine();
							System.out.println("Ingrese la edad de la araña");
							while (true) {
								String pso = lectorString.nextLine();
								if (controladorValidacion.valEntero(pso)) {
									edad = Integer.parseInt(pso);
									break;
								} else {
									System.out.println("Ingrese un numero valido");
								}
							}
							System.out.println("Ingrese el color de la araña");
							color = lectorString.nextLine();
							System.out.println("Ingrese la raza de la araña");
							raza = lectorString.nextLine();
							System.out.println("Ingrese el tamaño de la araña");
							while (true) {
								String pso = lectorString.nextLine();
								if (controladorValidacion.valFloat(pso)) {
									tamanio = Float.parseFloat(pso);
									break;
								} else {
									System.out.println("Ingrese un numero valido");
								}
							}
							System.out.println("Ingrese el peso de la araña");
							while (true) {
								String pso = lectorString.nextLine();
								if (controladorValidacion.valFloat(pso)) {
									peso = Float.parseFloat(pso);
									break;
								} else {
									System.out.println("Ingrese un numero valido");
								}
							}
							System.out.println("Ingrese el precio de la araña");
							while (true) {
								String pso = lectorString.nextLine();
								if (controladorValidacion.valFloat(pso)) {
									precio = Float.parseFloat(pso);
									break;
								} else {
									System.out.println("Ingrese un numero valido");
								}
							}
							System.out.println("Ingrese si la araña es venenosa");
							System.out.println("1. Es venenosa");
							System.out.println("2. No es venenosa");
							opc3 = lectorInt.nextInt();
							if (opc3 == 1) {
								toxicidad = true;
							} else {
								toxicidad = false;
							}
							System.out.println("Ingrese el sexo de la araña");
							System.out.println("1. Macho");
							System.out.println("2. Hembra");
							opc3 = lectorInt.nextInt();
							if (opc3 == 1) {
								sexo = true;
							} else {
								sexo = false;
							}
							System.out.println("Ingrese la alimentación de la araña");
							System.out.println("1. Es carnivoro");
							System.out.println("2. Es hervivoro");
							System.out.println("3. Es omnivoro");
							opc3 = lectorInt.nextInt();
						/**
						 * Método alimentacion.
						 *
						 * Ejecuta la acción del método alimentacion.
						 */
							alimentacion(opc3);

							controladorArania.registrarArania(nombre, edad, color, raza, tamanio, peso, precio, toxicidad, sexo, alimentacion);
							controladorBD.respaldarBD();
							break;

						case 5:
							System.out.println("Se va a registrar una serpiente");
							System.out.println("Ingrese el nombre de la serpiente");
							nombre = lectorString.nextLine();
							System.out.println("Ingrese la edad de la serpiente");
							while (true) {
								String pso = lectorString.nextLine();
								if (controladorValidacion.valEntero(pso)) {
									edad = Integer.parseInt(pso);
									break;
								} else {
									System.out.println("Ingrese un numero valido");
								}
							}
							System.out.println("Ingrese el color de la serpiente");
							color = lectorString.nextLine();
							System.out.println("Ingrese la raza de la serpiente");
							raza = lectorString.nextLine();
							System.out.println("Ingrese el tamaño de la serpiente");
							while (true) {
								String pso = lectorString.nextLine();
								if (controladorValidacion.valFloat(pso)) {
									tamanio = Float.parseFloat(pso);
									break;
								} else {
									System.out.println("Ingrese un numero valido");
								}
							}
							System.out.println("Ingrese el peso de la serpiente");
							while (true) {
								String pso = lectorString.nextLine();
								if (controladorValidacion.valFloat(pso)) {
									peso = Float.parseFloat(pso);
									break;
								} else {
									System.out.println("Ingrese un numero valido");
								}
							}
							System.out.println("Ingrese el precio de la serpiente");
							while (true) {
								String pso = lectorString.nextLine();
								if (controladorValidacion.valFloat(pso)) {
									precio = Float.parseFloat(pso);
									break;
								} else {
									System.out.println("Ingrese un numero valido");
								}
							}
							System.out.println("Ingrese el sexo de la serpiente");
							System.out.println("1. Macho");
							System.out.println("2. Hembra");
							opc3 = lectorInt.nextInt();
							if (opc3 == 1) {
								sexo = true;
							} else {
								sexo = false;
							}
							System.out.println("Ingrese la alimentación de la serpiente");
							System.out.println("1. Es carnivoro");
							System.out.println("2. Es hervivoro");
							System.out.println("3. Es omnivoro");
							opc3 = lectorInt.nextInt();
						/**
						 * Método alimentacion.
						 *
						 * Ejecuta la acción del método alimentacion.
						 */
							alimentacion(opc3);
							System.out.println("Ingrese el pais de origen de la serpiente");
							paisOrigen = lectorString.nextLine();
							controladorSerpiente.registrarSerpiente(nombre, edad, color, raza, tamanio, peso, precio, sexo, alimentacion, paisOrigen);
							controladorBD.respaldarBD();
							break;
						case 6:
							break;
						default:
							System.out.println("Ingrese una opcion valida");
							break;
					}
					break;
				case 2:
					System.out.println("Se ha seleccionado vender a un animal");
					System.out.println("Elija el animal que desea vender");
					System.out.println("1. Perro");
					System.out.println("2. Gato");
					System.out.println("3. Pez");
					System.out.println("4. Araña");
					System.out.println("5. Serpiente");
					System.out.println("6. Volver");
					while (true){
						String pso = lectorString.nextLine();
						if(controladorValidacion.valEntero(pso)){
							opc = Integer.parseInt(pso);
							break;
						}else{
							System.out.println("Ingrese un numero valido");
						}
					}
					switch (opc){
						case 1:
							System.out.println("Se va a vender un perro");
							System.out.println("Ingrese el nombre del perro");
							nombre = lectorString.nextLine();
							for(Perro perro : BD.getStockPerros()){
								if(perro.getNombre().equals(nombre)) {
									controladorPerro.venderPerro(perro);
									break;
								}else{
									System.out.println("ERROR: No se encontró el perro. Verifique que el nombre sea correcto");
								}
							}
							controladorBD.respaldarBD();
							break;
						case 2:
							System.out.println("Se va a vender un gato");
							System.out.println("Ingrese el nombre del gato");
							nombre = lectorString.nextLine();
							for(Gato gato : BD.getStockGatos()) {
								if (gato.getNombre().equals(nombre)) {
									controladorGato.venderGatos(gato);
									break;
								} else {
									System.out.println("ERROR: No se encontró el gato. Verifique que el nombre sea correcto");
								}
							}
							controladorBD.respaldarBD();
							break;
						case 3:
							System.out.println("Se va a vender un pez");
							System.out.println("Ingrese el nombre del pez");
							nombre = lectorString.nextLine();
							for (Pez pez : BD.getStockPez()){
								if (pez.getNombre().equals(nombre)) {
									controladorPez.venderPez(pez);
									break;
								}else{
									System.out.println("ERROR: No se encontró el pez. Verifique que el nombre sea correcto");
								}
							}
							controladorBD.respaldarBD();
							break;
						case 4:
							System.out.println("Se va a vender una araña");
							System.out.println("Ingrese el nombre de la araña");
							nombre = lectorString.nextLine();
							for(Arania arania : BD.getStockAranias()){
								if(arania.getNombre().equals(nombre)){
									controladorArania.venderArania(arania);
									break;
								}else{
									System.out.println("ERROR: No se encontró la araña. Verifique que el nombre sea correcto");
								}
							}
							controladorBD.respaldarBD();
							break;
						case 5:
							System.out.println("Se va a vender una serpiente");
							System.out.println("Ingrese el nombre de la serpiente");
							nombre = lectorString.nextLine();
							for(Serpiente serpiente : BD.getStockSerp()){
								if(serpiente.getNombre().equals(nombre)){
									controladorSerpiente.venderSerpiente(serpiente);
									break;
								}else{
									System.out.println("ERROR: No se encontró la serpiente. Verifique que el nombre sea correcto");
								}
							}
							controladorBD.respaldarBD();
							break;
						case 6:
							break;
						default:
							System.out.println("Ingrese una opcion valida");
							break;
					}
					break;
				case 3:
					for (Perro perro : BD.getStockPerros()){
						System.out.print("""
								  /^ ^\\
								 / 0 0 \\
								 V\\ Y /V
								  / - \\
								 /    |
								V__) ||
								""");
						System.out.println("Nombre: " + perro.getNombre());
						System.out.println("Edad: " + perro.getEdad());
						System.out.println("Color: " + perro.getColor());
						System.out.println("Raza: " + perro.getRaza());
						System.out.println("Tamaño: " + perro.getTamanio());
						System.out.println("Peso: " + perro.getPeso());
						System.out.println("Precio: " + perro.getPrecio());
						String auxperfil = switch (perro.getPerfil()) {
							case 1 -> "Semental";
							case 2 -> "Mascota";
							case 3 -> "Policia";
							case 4 -> "Apoyo a invidentes";
							default -> "";
						};
						System.out.println("Perfil: " + auxperfil);
						System.out.println("Sexo: " + perro.getSexo());
						System.out.println("Alimentacion: " + perro.getAlimentacion());
					}
					for (Gato gato : BD.getStockGatos()) {
						System.out.print("""
								 /\\_/\\
								( o.o )
								 > ^ <
								""");
						System.out.println("Nombre: " + gato.getNombre());
						System.out.println("Edad: " + gato.getEdad());
						System.out.println("Color: " + gato.getColor());
						System.out.println("Raza: " + gato.getRaza());
						System.out.println("Tamaño: " + gato.getTamanio());
						System.out.println("Peso: " + gato.getPeso());
						System.out.println("Precio: " + gato.getPrecio());
						System.out.println("Color de ojos: " + gato.getColorOjos());
						System.out.println("Sexo: " + gato.getSexo());
						System.out.println("Alimentacion: " + gato.getAlimentacion());
					}
					for (Pez pez : BD.getStockPez()) {
						System.out.print("""
								      /`·.¸
								     /¸...¸`:·
								 ¸.·´  ¸   `·.¸.·´)
								: © ):´;      ¸  {
								 `·.¸ `·  ¸.·´\\`·¸)
								     `\\\\´´\\¸.·´
								""");
						System.out.println("Nombre: " + pez.getNombre());
						System.out.println("Edad: " + pez.getEdad());
						System.out.println("Color: " + pez.getColor());
						System.out.println("Raza: " + pez.getRaza());
						System.out.println("Tamaño: " + pez.getTamanio());
						System.out.println("Peso: " + pez.getPeso());
						System.out.println("Precio: " + pez.getPrecio());
						System.out.println("Tipo de agua: " + pez.getTipoAgua());
						System.out.println("Sexo: " + pez.getSexo());
						System.out.println("Alimentacion: " + pez.getAlimentacion());
					}
					for (Arania arania : BD.getStockAranias()) {
						System.out.print("""
								 /\\ \\  / /\\
								//\\\\ .. //\\\\
								//\\((  ))/\\\\
								/  < '' >  \\
								""");
						System.out.println("Nombre: " + arania.getNombre());
						System.out.println("Edad: " + arania.getEdad());
						System.out.println("Color: " + arania.getColor());
						System.out.println("Raza: " + arania.getRaza());
						System.out.println("Tamaño: " + arania.getTamanio());
						System.out.println("Peso: " + arania.getPeso());
						System.out.println("Precio: " + arania.getPrecio());
						System.out.println("Toxicidad: " + arania.getVenenosa());
						System.out.println("Sexo: " + arania.getSexo());
						System.out.println("Alimentacion: " + arania.getAlimentacion());
					}
					for (Serpiente serpiente : BD.getStockSerp()) {
						System.out.print("""
								(\\   .-.   /_")
								 \\\\_//^\\\\_//
								  `"`   `"`
								""");
						System.out.println("Nombre: " + serpiente.getNombre());
						System.out.println("Edad: " + serpiente.getEdad());
						System.out.println("Color: " + serpiente.getColor());
						System.out.println("Raza: " + serpiente.getRaza());
						System.out.println("Tamaño: " + serpiente.getTamanio());
						System.out.println("Peso: " + serpiente.getPeso());
						System.out.println("Precio: " + serpiente.getPrecio());
						System.out.println("Toxicidad: " + serpiente.getPaisOrigen());
						System.out.println("Sexo: " + serpiente.getSexo());
						System.out.println("Alimentacion: " + serpiente.getAlimentacion());
					}
					break;

				case 4:
					for (Perro perro : BD.getVentaPerros()){
						System.out.print("""
								  /^ ^\\
								 / 0 0 \\
								 V\\ Y /V
								  / - \\
								 /    |
								V__) ||
								""");
						System.out.println("Nombre: " + perro.getNombre());
						System.out.println("Edad: " + perro.getEdad());
						System.out.println("Color: " + perro.getColor());
						System.out.println("Raza: " + perro.getRaza());
						System.out.println("Tamaño: " + perro.getTamanio());
						System.out.println("Peso: " + perro.getPeso());
						System.out.println("Precio: " + perro.getPrecio());
						System.out.println("Perfil: " + perro.getPerfil());
						System.out.println("Sexo: " + perro.getSexo());
						System.out.println("Alimentacion: " + perro.getAlimentacion());
					}
					for (Gato gato : BD.getVentaGatos()) {
						System.out.print("""
								 /\\_/\\
								( o.o )
								 > ^ <
								""");
						System.out.println("Nombre: " + gato.getNombre());
						System.out.println("Edad: " + gato.getEdad());
						System.out.println("Color: " + gato.getColor());
						System.out.println("Raza: " + gato.getRaza());
						System.out.println("Tamaño: " + gato.getTamanio());
						System.out.println("Peso: " + gato.getPeso());
						System.out.println("Precio: " + gato.getPrecio());
						System.out.println("Color de ojos: " + gato.getColorOjos());
						System.out.println("Sexo: " + gato.getSexo());
						System.out.println("Alimentacion: " + gato.getAlimentacion());
					}
					for (Pez pez : BD.getVentaPez()) {
						System.out.print("""
								      /`·.¸
								     /¸...¸`:·
								 ¸.·´  ¸   `·.¸.·´)
								: © ):´;      ¸  {
								 `·.¸ `·  ¸.·´\\`·¸)
								     `\\\\´´\\¸.·´
								""");
						System.out.println("Nombre: " + pez.getNombre());
						System.out.println("Edad: " + pez.getEdad());
						System.out.println("Color: " + pez.getColor());
						System.out.println("Raza: " + pez.getRaza());
						System.out.println("Tamaño: " + pez.getTamanio());
						System.out.println("Peso: " + pez.getPeso());
						System.out.println("Precio: " + pez.getPrecio());
						System.out.println("Tipo de agua: " + pez.getTipoAgua());
						System.out.println("Sexo: " + pez.getSexo());
						System.out.println("Alimentacion: " + pez.getAlimentacion());
					}
					for (Arania arania : BD.getVentaAranias()) {
						System.out.print("""
								 /\\ \\  / /\\
								//\\\\ .. //\\\\
								//\\((  ))/\\\\
								/  < '' >  \\
								""");
						System.out.println("Nombre: " + arania.getNombre());
						System.out.println("Edad: " + arania.getEdad());
						System.out.println("Color: " + arania.getColor());
						System.out.println("Raza: " + arania.getRaza());
						System.out.println("Tamaño: " + arania.getTamanio());
						System.out.println("Peso: " + arania.getPeso());
						System.out.println("Precio: " + arania.getPrecio());
						System.out.println("Toxicidad: " + arania.getVenenosa());
						System.out.println("Sexo: " + arania.getSexo());
						System.out.println("Alimentacion: " + arania.getAlimentacion());
					}
					for (Serpiente serpiente : BD.getVentaSerp()) {
						System.out.print("""
								(\\   .-.   /_")
								 \\\\_//^\\\\_//
								  `"`   `"`
								""");
						System.out.println("Nombre: " + serpiente.getNombre());
						System.out.println("Edad: " + serpiente.getEdad());
						System.out.println("Color: " + serpiente.getColor());
						System.out.println("Raza: " + serpiente.getRaza());
						System.out.println("Tamaño: " + serpiente.getTamanio());
						System.out.println("Peso: " + serpiente.getPeso());
						System.out.println("Precio: " + serpiente.getPrecio());
						System.out.println("Toxicidad: " + serpiente.getPaisOrigen());
						System.out.println("Sexo: " + serpiente.getSexo());
						System.out.println("Alimentacion: " + serpiente.getAlimentacion());
					}
					break;

				case 5:
					controladorBD.respaldarBD();
					break;

				case 6:
					controladorBD.cargarBD();
					break;

				case 7:
					System.out.println("Elija el animal que desee que salude");
					System.out.println("1. Perro");
					System.out.println("2. Gato");
					System.out.println("3. Pez");
					System.out.println("4. Araña");
					System.out.println("5. Serpiente");
					System.out.println("6. Volver");
					while (true){
						String pso = lectorString.nextLine();
						if(controladorValidacion.valEntero(pso)){
							opc = Integer.parseInt(pso);
							break;
						}else{
							System.out.println("Ingrese un numero valido");
						}
					}
					switch (opc) {
						case 1:
							controladorPerro.Saludar();
							break;
						case 2:
							controladorGato.Saludar();
							break;
						case 3:
							controladorPez.Saludar();
							break;
						case 4:
							controladorArania.Saludar();
							break;
						case 5:
							controladorSerpiente.Saludar();
							break;
						case 6:
							break;
						default:
							System.out.println("Ingrese una opcion valida");
							break;
					}
					break;
				case 8:
					System.out.println("Respaldando datos...");
					controladorBD.respaldarBD();
					System.out.println("Gracias por su visita");
					aux = 0;
					break;
			}
		}while (aux != 0) ;
	}

	/**
	 * Ejecuta la acción del método alimentacion.
	 * @param opc Parámetro opc.
	 */
	private void alimentacion(int opc) {
		switch (opc) {
			case 1:
				alimentacion = "Carnivoro";
				break;
			case 2:
				alimentacion = "Herviboro";
				break;
			case 3:
				alimentacion = "Omnivoro";
				break;
			default:
				alimentacion = "No hay alimentacion especificada";
				break;
		}
	}
}