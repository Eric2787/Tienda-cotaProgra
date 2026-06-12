package Vista;

import Controlador.*;
import Modelo.*;
import Almacenamiento.*;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
	// Variables de control
	int aux = -1;
	int i = 0;
	int i2 = 0;
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

	public void mostrarMenu() throws IOException, ClassNotFoundException{
		Scanner lectorInt = new Scanner(System.in);
		Scanner lectorString = new Scanner(System.in);
		Scanner lectorFloat = new Scanner(System.in);

		do {

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
							alimentacion(opc2);

							controladorGato.registrarGato(nombre, raza, edad, color, tamanio, peso, precio, sexo, alimentacion, colorOjos);
							controladorBD.respaldarBD();
							break;

						case 3:
							System.out.println("Se va a registrar un pez");
							System.out.println("Ingrese el nombre del pez");
							nombre = lectorString.nextLine();
							System.out.println("Ingrese la edad del pez");
							while (true){
								String pso = lectorString.nextLine();
								if (controladorValidacion.valEntero(pso)){
									edad = Integer.parseInt(pso);
									break;
								}else{
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
								if (controladorValidacion.valFloat(pso)){
									precio = Float.parseFloat(pso);
									break;
								}else{
									System.out.println("Ingrese un numero valido");
								}
							}
							System.out.println("Ingrese el tipo de agua del pez");
							System.out.println("1. Salada");
							System.out.println("2. Dulce");
							int opc3 = lectorInt.nextInt();
							switch (opc3){
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
							if (opc3 == 1){
								sexo = true;
							}else{
								sexo = false;
							}
							System.out.println("Ingrese la alimentación del pez");
							System.out.println("1. Es carnivoro");
							System.out.println("2. Es hervivoro");
							System.out.println("3. Es omnivoro");
							opc3 = lectorInt.nextInt();
							alimentacion(opc3);

							controladorPez.registrarPez(nombre, edad, color, raza, tamanio, peso, precio, tipoAgua, sexo, alimentacion);
							controladorBD.respaldarBD();
							break;

						case 4:
							System.out.println("Se va a registrar una araña");
							System.out.println("Ingrese el nombre de la araña");
							nombre = lectorString.nextLine();
							System.out.println("Ingrese la edad de la araña");
							while (true){
								String pso = lectorString.nextLine();
								if (controladorValidacion.valEntero(pso)){
									edad = Integer.parseInt(pso);
									break;
								}else{
									System.out.println("Ingrese un numero valido");
								}
							}
							System.out.println("Ingrese el color de la araña");
							color = lectorString.nextLine();
							System.out.println("Ingrese la raza de la araña");
							raza = lectorString.nextLine();
							System.out.println("Ingrese el tamaño de la araña");
							while(true){
								String pso = lectorString.nextLine();
								if (controladorValidacion.valFloat(pso)){
									tamanio = Float.parseFloat(pso);
									break;
								}else{
									System.out.println("Ingrese un numero valido");
								}
							}
							System.out.println("Ingrese el peso de la araña");
							while(true){
								String pso = lectorString.nextLine();
								if (controladorValidacion.valFloat(pso)){
									peso = Float.parseFloat(pso);
									break;
								}else{
									System.out.println("Ingrese un numero valido");
								}
							}
							System.out.println("Ingrese el precio de la araña");
							while (true){
								String pso = lectorString.nextLine();
								if (controladorValidacion.valFloat(pso)){
									precio = Float.parseFloat(pso);
									break;
								}else{
									System.out.println("Ingrese un numero valido");
								}
							}
							System.out.println("Ingrese si la araña es venenosa");
							System.out.println("1. Es venenosa");
							System.out.println("2. No es venenosa");
							opc3 = lectorInt.nextInt();
							if (opc3 == 1){
								toxicidad = true;
							}else{
								toxicidad = false;
							}
							System.out.println("Ingrese el sexo de la araña");
							System.out.println("1. Macho");
							System.out.println("2. Hembra");
							opc3 = lectorInt.nextInt();
							if (opc3 == 1){
								sexo = true;
							}else{
								sexo = false;
							}
							System.out.println("Ingrese la alimentación de la araña");
							System.out.println("1. Es carnivoro");
							System.out.println("2. Es hervivoro");
							System.out.println("3. Es omnivoro");
							opc3 = lectorInt.nextInt();
							alimentacion(opc3);

							controladorArania.registrarArania(nombre, edad, color, raza, tamanio, peso, precio, toxicidad, sexo, alimentacion);
							controladorBD.respaldarBD();
							break;
					}
				case 2:

					break;

				case 3:
					for (Perro perro : BD.getStockPerros()){
						System.out.println("Nombre: " + perro.getNombre());
					}
					for (Gato gato : BD.getStockGatos()) {
						System.out.println("Nombre: " + gato.getNombre());
					}
					break;

				case 4:

					break;

				case 5:
					controladorBD.respaldarBD();
					break;

				case 6:
					controladorBD.cargarBD();
					break;

				case 7:

					break;

				case 8:
					System.out.println("Gracias por su visita");
					aux = 0;
					break;
			}
		}while (aux != 0) ;
	}

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