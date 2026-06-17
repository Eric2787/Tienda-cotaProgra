package Controlador;

import Almacenamiento.BD;
import Modelo.Perro;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Controlador para la gestión de las operaciones relacionadas con los perros.
 */
public class ControladorPerro implements SaludosInterfaz {
	/**
	 * Constructor por defecto.
	 */
	public ControladorPerro() {


	}
	/**
	* Metodo de insertar un "perrito" a una lista dinamica de la clase Perro
	* @param nombre El nombre definido por el usuario
	* @param edad Es la edad definida por el usuario
	* @param color Es el color definido por el usuario
	* @param raza Es la raza definida por el usuario
	* @param tamanio Es el tamaño definido por el usuario
	* @param peso Es el peso definido por el usuario
	* @param precio Es el precio definido por el usuario
	* @param perfil Es el perfil defindo por el usuario
	* @param sexo Es el sexo definido por el usuario
	* @param alimentacion Es la alimentacion definida por el usuario
	*/
	public void registrarPerro(String nombre, int edad, String color, String raza, float tamanio, float peso, float precio, int perfil, boolean sexo, String alimentacion){
		Perro perro = new Perro();
		perro.setNombre(nombre);
		perro.setEdad(edad);
		perro.setColor(color);
		perro.setRaza(raza);
		perro.setTamanio(tamanio);
		perro.setPeso(peso);
		perro.setPrecio(precio);
		perro.setPerfil(perfil);
		perro.setSexo(sexo);
		perro.setAlimentacion(alimentacion);

		ArrayList<Perro> auxPerro = BD.getStockPerros();
		auxPerro.add(perro);
		BD.setStockPerros(auxPerro);

		System.out.println("Perro registrado con exito");
	}

	/**
	 * Consulta la lista de perros disponibles en stock.
	 *
	 * @return Lista de perros en stock.
	 */
	public ArrayList<Perro> consultarPerros(){
		ArrayList<Perro> auxPerros = BD.getStockPerros();
		return auxPerros;
	}

	/**
	 * Elimina un perro del stock.
	 *
	 * @param perro Perro a eliminar.
	 */
	public void eliminarPerro(Perro perro){
		ArrayList<Perro> auxPerros = BD.getStockPerros();
		auxPerros.remove(perro);
		BD.setStockPerros(auxPerros);
	}

	/**
	 * Registra la venta de un perro.
	 *
	 * @param perro Perro vendido.
	 */
	public void registrarVentaPerro(Perro perro){
		ArrayList<Perro> auxPerros = BD.getVentaPerros();
		auxPerros.add(perro);
		BD.setVentaPerros(auxPerros);
	}

	/**
	 * Busca un perro dentro del inventario disponible por su nombre.
	 * @param nombre Nombre del perro ingresado en la interfaz gráfica.
	 * @return El objeto Perro si existe, o null si no se encuentra.
	 */
	public Perro buscarPerro(String nombre) {
		ArrayList<Perro> stockActual = BD.getStockPerros();
		if (stockActual != null) {
			for (Perro p : stockActual) {
				// Comparacion nombre (no importa en minusculas o mayusculas)
				if (p.getNombre().equalsIgnoreCase(nombre)) {
					return p; //Se retorna el objeto
				}
			}
		}
		return null; // Si termina el bucle y no lo halla, regresa nulo
	}

	/**
	 * Realiza el proceso de venta de un perro, aplicando descuentos si corresponde.
	 *
	 * @param perro Perro a vender.
	 */
	public void venderPerro(Perro perro){
		Component f = null;

		ArrayList<Perro> auxPerros = BD.getStockPerros();
		if (perro.getPrecio() > 5000){
			Float dto = (float) (perro.getPrecio() * 0.90);
			for (int i = 0; i < auxPerros.size(); i++) {
				if (auxPerros.get(i).getNombre().equals(perro.getNombre())){
					auxPerros.get(i).setPrecio(dto);
					this.registrarVentaPerro(perro);
					this.eliminarPerro(perro);
					JOptionPane.showMessageDialog(f, "¡Felicidades el perrito ha sido vendido! \nPrecio final: $"+ perro.getPrecio() + "\nDescuento: 10%", "Venta Exitosa", JOptionPane.INFORMATION_MESSAGE);
					break;
				}
			}
		}else {
			this.registrarVentaPerro(perro);
			this.eliminarPerro(perro);
			JOptionPane.showMessageDialog(f, "¡Felicidades el perrito ha sido vendido! \nPrecio final: $"+ perro.getPrecio(), "Venta Exitosa", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Consulta la lista de perros vendidos.
	 *
	 * @return Lista de perros vendidos.
	 */
	public ArrayList<Perro> consultarVentasPerro(){
		ArrayList<Perro> auxPerros = BD.getVentaPerros();
		return auxPerros;
	}


    /**
     * @param perfil
     */
	@Override
	public void Saludar(int perfil) {
		switch (perfil){
			case 1:
				System.out.println("¡GUAU, GUAU!");
				break;
			case 2:
				System.out.println("El perrito esta dormido");
				break;
			case 3:
				System.out.println("El perrito esta olfateando");
				break;
			case 4:
				System.out.println("El perro esta sentado esperando");
				break;
		}
	}

	@Override
	public void Saludar() {
		Scanner lectorString = new Scanner(System.in);
		ControladorValidacion controladorValidacion = new ControladorValidacion();

		//Lista para manipular los datos de la BD
		List<Perro> listaPerros = BD.getStockPerros();

		//Verificar si la lista esta vacia, si no, devuelve los perros registrados
		if (listaPerros.isEmpty()) {
			System.out.println("No hay perros registrados");
		}else{
			System.out.println("Lista de perritos registrados.");
			for (int i = 0; i < listaPerros.size(); i++) {
				System.out.println(i+1 + ". " + listaPerros.get(i).getNombre());
			}

			while (true) {

				System.out.println("Seleccione cual perrito saludar.");
				String pso = lectorString.nextLine();

				if (controladorValidacion.valEntero(pso)) {
					int opcion = Integer.parseInt(pso);

					if(opcion >= 1 &&  opcion <= listaPerros.size()) {
						int numList = opcion -1;

						Perro perro = listaPerros.get(numList);

						System.out.println(" ¡GUAU, GUAU! soy " +  perro.getNombre());

						System.out.print("""
								  /^ ^\\
								 / 0 0 \\
								 V\\ Y /V
								  / - \\
								 /    |
								V__) ||
								""");

						System.out.println("Edad: " + perro.getEdad());
						System.out.println("Color: " + perro.getColor());
						System.out.println("Raza: " + perro.getRaza());
						System.out.println("Tamaño: " + perro.getTamanio());
						System.out.println("Peso: " + perro.getPeso());
						System.out.println("Precio: " + perro.getPrecio());

						String sexoMascota;
						if(perro.getSexo()){
							sexoMascota = "Macho";
						}else{
							sexoMascota = "Hembra";
						}
						System.out.println("Sexo: " + sexoMascota);
						System.out.println("Alimentacion: " + perro.getAlimentacion());

						String perfilPerro = "";
						switch (perro.getPerfil()) {
							case 1: perfilPerro = "Semental"; break;
							case 2: perfilPerro = "Mascota"; break;
							case 3: perfilPerro = "Policia"; break;
							case 4: perfilPerro = "Apoyo a invidentes"; break;
						}
						System.out.println("Perfil: " + perfilPerro);
						System.out.println("Funcion: ");
						this.Saludar(perro.getPerfil());
					} break;
				} else {
					System.out.println("Ingresa un numero valido");
				}
			}
		}
	}
}
