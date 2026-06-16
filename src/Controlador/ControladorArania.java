package Controlador;

import Almacenamiento.BD;
import Modelo.Arania;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Controlador para la gestión de las operaciones relacionadas con las arañas.
 */
public class ControladorArania implements  SaludosInterfaz {
	/**
	 * Constructor por defecto.
	 */
	public ControladorArania() {

	}

	/**
	 * Registra una nueva araña en el stock.
	 *
	 * @param nombre Nombre de la araña.
	 * @param edad Edad de la araña.
	 * @param color Color de la araña.
	 * @param raza Raza de la araña.
	 * @param tamanio Tamaño de la araña.
	 * @param peso Peso de la araña.
	 * @param precio Precio de la araña.
	 * @param venenosa Indica si la araña es venenosa.
	 * @param sexo Sexo de la araña.
	 * @param alimentacion Alimentación de la araña.
	 */
	public void registrarArania(String nombre, int edad, String color, String raza, float tamanio, float peso, float precio, boolean venenosa, boolean sexo, String alimentacion){
		Arania arania = new Arania();
		arania.setNombre(nombre);
		arania.setEdad(edad);
		arania.setColor(color);
		arania.setRaza(raza);
		arania.setTamanio(tamanio);
		arania.setPeso(peso);
		arania.setPrecio(precio);
		arania.setVenenosa(venenosa);
		arania.setSexo(sexo);
		arania.setAlimentacion(alimentacion);

		ArrayList<Arania> auxArania = BD.getStockAranias();
		auxArania.add(arania);
		BD.setStockAranias(auxArania);

		System.out.println("Araña registrada con exito");
	}

	/**
	 * Consulta la lista de arañas disponibles en stock.
	 *
	 * @return Lista de arañas en stock.
	 */
	public ArrayList<Arania> consultarArania(){
		ArrayList<Arania> auxArania = BD.getStockAranias();
		return auxArania;
	}

	/**
	 * Elimina una araña del stock.
	 *
	 * @param arania Araña a eliminar.
	 */
	public void eliminarArania(Arania arania){
		ArrayList<Arania> auxArania = BD.getStockAranias();
		auxArania.remove(arania);
		BD.setStockAranias(auxArania);
	}

	/**
	 * Registra la venta de una araña.
	 *
	 * @param arania Araña vendida.
	 */
	public void registrarVentaArania(Arania arania){
		ArrayList<Arania> auxArania = BD.getVentaAranias();
		auxArania.add(arania);
		BD.setVentaAranias(auxArania);
	}

	/**
	 * Realiza el proceso de venta de una araña, aplicando descuentos si corresponde.
	 *
	 * @param arania Araña a vender.
	 */
	public void venderArania(Arania arania){
		ArrayList<Arania> auxArania = BD.getStockAranias();
		if (arania.getPrecio() > 5000){
			Float dto = (float) (arania.getPrecio() * 0.90);
			for (int i = 0; i < auxArania.size(); i++) {
				if (auxArania.get(i).getNombre().equals(arania.getNombre())){
					auxArania.get(i).setPrecio(dto);
					this.registrarVentaArania(arania);
					this.eliminarArania(arania);
					System.out.println("Precio final: " + arania.getPrecio());
					System.out.println("Descuento: 10%");
					break;
				}
			}
		}else {
			this.registrarVentaArania(arania);
			this.eliminarArania(arania);
			System.out.println("Precio final: " + arania.getPrecio());
			System.out.println("Felicidades, se ha vendido con exito");
		}
	}

	/**
	 * Consulta la lista de arañas vendidas.
	 *
	 * @return Lista de arañas vendidas.
	 */
	public ArrayList<Arania> consultarVentasPerro(){
		ArrayList<Arania> auxArania = BD.getVentaAranias();
		return auxArania;
	}

	@Override
	public void Saludar(int perfil) {
	}

	@Override
	public void Saludar() {
		Scanner lectorString = new Scanner(System.in);
		ControladorValidacion controladorValidacion = new ControladorValidacion();

		//Lista para manipular los datos de la BD
		List<Arania> listaAranias = BD.getStockAranias();

		//Verificar si la lista esta vacia, si no, devuelve las arañas registradas
		if (listaAranias.isEmpty()) {
			System.out.println("No hay arañas registradas");
		}else{
			System.out.println("Lista de arañas registradas.");
			for (int i = 0; i < listaAranias.size(); i++) {
				System.out.println(i+1 + ". " + listaAranias.get(i).getNombre());
			}

			while (true) {

				System.out.println("Seleccione cual araña saludar.");
				String pso = lectorString.nextLine();

				if (controladorValidacion.valEntero(pso)) {
					int opcion = Integer.parseInt(pso);

					if (opcion >= 1 && opcion <= listaAranias.size()) {
						int numList = opcion - 1;

						Arania arania = listaAranias.get(numList);

						System.out.println(" ¡Hola!  Soy " + arania.getNombre()) ;

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

						String toxicidadArania;
						if(arania.getVenenosa()){
							toxicidadArania = "Toxica";
						}else{
							toxicidadArania = "No toxica";
						}
						System.out.println("Toxicidad: " + toxicidadArania);

						String sexoMascota;
						if(arania.getSexo()){
							sexoMascota = "Macho";
						}else{
							sexoMascota = "Hembra";
						}
						System.out.println("Sexo: " + sexoMascota);
						System.out.println("Alimentacion: " + arania.getAlimentacion());
					}break;
				}else {
					System.out.println("Ingresa un numero valido");
				}
			}
		}
	}
}
