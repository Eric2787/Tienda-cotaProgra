package Controlador;

import Almacenamiento.BD;
import Modelo.Pez;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Controlador para la gestión de las operaciones relacionadas con los peces.
 */
public class ControladorPez implements SaludosInterfaz{

	/**
	 * Constructor por defecto.
	 */
	public ControladorPez() {

	}

	/**
	 * Registra un nuevo pez en el stock.
	 *
	 * @param nombre Nombre del pez.
	 * @param edad Edad del pez.
	 * @param color Color del pez.
	 * @param raza Raza del pez.
	 * @param tamanio Tamaño del pez.
	 * @param peso Peso del pez.
	 * @param precio Precio del pez.
	 * @param tipoAgua Tipo de agua del pez (true para un tipo, false para otro).
	 * @param sexo Sexo del pez.
	 * @param tipoAlimentacion Tipo de alimentación del pez.
	 */
	public void registrarPez(String nombre, int edad, String color, String raza, float tamanio, float peso, float precio, boolean tipoAgua, boolean sexo, String tipoAlimentacion) {
		// Validación: no se admiten peces con un peso mayor o igual a 50 gramos.
		if (peso >= 50) {
			JOptionPane.showMessageDialog(null, "No se pueden registrar peces con un peso mayor o igual a 50 gramos.", "Error de Registro", JOptionPane.ERROR_MESSAGE);
			return;
		}

		Pez pececito = new Pez();

		pececito.setNombre(nombre);
		pececito.setEdad(edad);
		pececito.setColor(color);
		pececito.setRaza(raza);
		pececito.setTamanio(tamanio);
		pececito.setPeso(peso);
		pececito.setPrecio(precio);
		pececito.setTipoAgua(tipoAgua);
		pececito.setSexo(sexo);
		pececito.setAlimentacion(tipoAlimentacion);

		ArrayList<Pez> auxPeces = BD.getStockPez();

		auxPeces.add(pececito);

		BD.setStockPez(auxPeces);

		System.out.println("Felicidades, tu pez se ha registrado.");
	}

	/**
	 * Consulta la lista de peces disponibles en stock.
	 *
	 * @return Lista de peces en stock.
	 */
	public ArrayList<Pez> consultarPez() {
		ArrayList<Pez> auxPeces = BD.getStockPez();
		return auxPeces;
	}

	/**
	 * Elimina un pez del stock.
	 *
	 * @param pececito Pez a eliminar.
	 */
	public void eliminarPez(Pez pececito) {
		ArrayList<Pez> auxPeces = BD.getStockPez();

		auxPeces.remove(pececito);

		BD.setStockPez(auxPeces);
	}

	/**
	 * Registra la venta de un pez.
	 *
	 * @param pececito Pez vendido.
	 */
	public void registrarVentaPez(Pez pececito) {
		ArrayList<Pez> auxPeces = BD.getVentaPez();

		auxPeces.add(pececito);

		BD.setVentaPez(auxPeces);
	}

	/**
	 * Realiza el proceso de venta de un pez, aplicando descuentos si corresponde.
	 *
	 * @param pececito Pez a vender.
	 */
	public void venderPez(Pez pececito) {
		ArrayList<Pez> auxPeces = BD.getStockPez();

		if (pececito.getPrecio() > 5000) {
			Float dto = (float) (pececito.getPrecio() * 0.90);

			for (int i = 0; i < auxPeces.size(); i++) {
				if (auxPeces.get(i).getNombre().equals(pececito.getNombre())) {
					auxPeces.get(i).setPrecio(dto);

					this.registrarVentaPez(pececito);
					this.eliminarPez(pececito);

					System.out.println("Precio final: " + pececito.getPrecio());
					System.out.println("Descuento: 10%");
					break;
				}
			}
		} else {
			this.registrarVentaPez(pececito);
			this.eliminarPez(pececito);

			System.out.println("Precio final: " + pececito.getPrecio());
			System.out.println("Felicidades, se ha vendido tu pez.");
		}
	}

	/**
	 * Consulta la lista de peces vendidos.
	 *
	 * @return Lista de peces vendidos.
	 */
	public ArrayList<Pez> consultarVentasPez() {
		ArrayList<Pez> auxPeces = BD.getVentaPez();

		return auxPeces;
	}

    /**
     * @param perfil
     */
	@Override
	public void Saludar(int perfil) {}

	@Override
	public void Saludar() {
		Scanner lectorString = new Scanner(System.in);
		ControladorValidacion controladorValidacion = new ControladorValidacion();

		//Lista para manipular los datos de la BD
		List<Pez> listaPeces = BD.getStockPez();

		//Verificar si la lista esta vacia, si no, devuelve los peces registrados
		if (listaPeces.isEmpty()) {
			System.out.println("No hay peces registrados");
		}else{
			System.out.println("Lista de peces registrados.");
			for (int i = 0; i < listaPeces.size(); i++) {
				System.out.println(i+1 + ". " + listaPeces.get(i).getNombre());
			}

			while(true){
				System.out.println("Selecciona cual pececito saludar.");
				String pso = lectorString.nextLine();

				if (controladorValidacion.valEntero(pso)) {
					int opcion = Integer.parseInt(pso);

					if (opcion >= 1 && opcion <= listaPeces.size()) {
						int numList = opcion - 1;

						Pez pez = listaPeces.get(numList);

						System.out.println(" ¡Hola!  Soy " + pez.getNombre());

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

						String tipoAguaPez= "";
						if(pez.getTipoAgua()){
							tipoAguaPez = "Salada";
						}else{
							tipoAguaPez = "Dulce";
						}
						System.out.println("Tipo de agua: " + tipoAguaPez);

						String sexoMascota;
						if(pez.getSexo()){
							sexoMascota = "Macho";
						}else{
							sexoMascota = "Hembra";
						}
						System.out.println("Sexo: " + sexoMascota);
						System.out.println("Alimentacion: " + pez.getAlimentacion());
					} break;
				}else {
					System.out.println("Ingresa un numero valido");
				}
			}
		}
	}
}