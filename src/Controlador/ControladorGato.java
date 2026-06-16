package Controlador;

import Almacenamiento.BD;
import Modelo.Gato;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Controlador para la gestión de las operaciones relacionadas con los gatos.
 */
public class ControladorGato implements SaludosInterfaz {
	/**
	 * Constructor por defecto.
	 */
	public ControladorGato() {

	}

	/**
	 * Registra un nuevo gato en el stock.
	 *
	 * @param nombre Nombre del gato.
	 * @param raza Raza del gato.
	 * @param edad Edad del gato.
	 * @param color Color del gato.
	 * @param tamanio Tamaño del gato.
	 * @param peso Peso del gato.
	 * @param precio Precio del gato.
	 * @param sexo Sexo del gato.
	 * @param alimentacion Alimentación del gato.
	 * @param colorOjos Código de color de ojos del gato.
	 */
	public void registrarGato(String nombre, String raza, int edad, String color, float tamanio, float peso, float precio, boolean sexo, String alimentacion, int colorOjos) {
		Gato gato = new Gato();
		gato.setNombre(nombre);
		gato.setRaza(raza);
		gato.setEdad(edad);
		gato.setColor(color);
		gato.setTamanio(tamanio);
		gato.setPeso(peso);
		gato.setPrecio(precio);
		gato.setSexo(sexo);
		gato.setAlimentacion(alimentacion);
		gato.setColorOjos(colorOjos);

		ArrayList<Gato> auxgatos = BD.getStockGatos();
		auxgatos.add(gato);
		BD.setStockGatos(auxgatos);
		System.out.println("Felicidades, el gato se ha registrado con exito");
	}

	/**
	 * Consulta la lista de gatos disponibles en stock.
	 *
	 * @return Lista de gatos en stock.
	 */
	public ArrayList<Gato> consultarGatos() {
		ArrayList<Gato> auxgatos = BD.getStockGatos();
		return auxgatos;
	}

	/**
	 * Elimina un gato del stock.
	 *
	 * @param gato Gato a eliminar.
	 */
	public void eliminarGatos(Gato gato) {
		ArrayList<Gato> auxgatos = BD.getStockGatos();
		auxgatos.remove(gato);
		BD.setStockGatos(auxgatos);
	}

	/**
	 * Registra la venta de un gato.
	 *
	 * @param gato Gato vendido.
	 */
	public void registrarVentaGatos(Gato gato) {
		ArrayList<Gato> auxgatos = BD.getVentaGatos();
		auxgatos.add(gato);
		BD.setVentaGatos(auxgatos);
	}

	/**
	 * Realiza el proceso de venta de un gato, aplicando descuentos si corresponde.
	 *
	 * @param gato Gato a vender.
	 */
	public void venderGatos(Gato gato) {
		ArrayList<Gato> auxgatos = BD.getStockGatos();
		if (gato.getPrecio()> 5000){
			float descuento = (float) (gato.getPrecio() * 0.90);
			for (int i = 0; i < auxgatos.size(); i++) {
				if (auxgatos.get(i).getNombre().equals(gato.getNombre())) {
					auxgatos.get(i).setPrecio(descuento);
					this.registrarVentaGatos(gato);
					this.eliminarGatos(gato);
					break;
				}
			}
		}else {
			this.registrarVentaGatos(gato);
			this.eliminarGatos(gato);
		}
		System.out.println("Precio final: " + gato.getPrecio());
		System.out.println("Felicidades, se ha vendido con exito");
	}

	/**
	 * Consulta la lista de gatos vendidos.
	 *
	 * @return Lista de gatos vendidos.
	 */
	public ArrayList<Gato> consultarVentasGatos(){
		ArrayList<Gato> auxgatos = BD.getVentaGatos();
		return auxgatos;
	}

	@Override
	public void Saludar(int perfil) {
	}

	@Override
	public void Saludar(){

		Scanner lectorString = new Scanner(System.in);
		ControladorValidacion controladorValidacion = new ControladorValidacion();

		//Lista para manipular los datos de la BD
		List<Gato> listaGatos = BD.getStockGatos();

		//Verificar si la lista esta vacia, si no, devuelve los gatos registrados
		if (listaGatos.isEmpty()) {
			System.out.println("No hay gatitos registrados");
		}else{
			System.out.println("Lista de gatitos registrados.");
			for (int i = 0; i < listaGatos.size(); i++) {
				System.out.println(i+1 + ". " + listaGatos.get(i).getNombre());
			}

			while(true){
				System.out.println("Selecciona cual gatito saludar.");
				String pso = lectorString.nextLine();

				if (controladorValidacion.valEntero(pso)) {
					int opcion = Integer.parseInt(pso);

					if (opcion >= 1 && opcion <= listaGatos.size()) {
						int numList = opcion - 1;

						Gato gatos = listaGatos.get(numList);

						System.out.println(" ¡Hola!  Soy " + gatos.getNombre()) ;

						System.out.print("""
								 /\\_/\\
								( o.o )
								 > ^ <
								""");
						System.out.println("Nombre: " + gatos.getNombre());
						System.out.println("Edad: " + gatos.getEdad());
						System.out.println("Color: " + gatos.getColor());
						System.out.println("Raza: " + gatos.getRaza());
						System.out.println("Tamaño: " + gatos.getTamanio());
						System.out.println("Peso: " + gatos.getPeso());
						System.out.println("Precio: " + gatos.getPrecio());

						String colorOjosGato = "";
						switch(gatos.getColorOjos()){
							case 1: colorOjosGato = "Azules"; break;
							case 2: colorOjosGato = "Verdes"; break;
							case 3: colorOjosGato = "Negros"; break;
							case 4: colorOjosGato = "Cafe"; break;
							case 5: colorOjosGato = "Grises"; break;
						}
						System.out.println("Color de ojos: " + colorOjosGato);

						String sexoMascota;
						if(gatos.getSexo()){
							sexoMascota = "Macho";
						}else{
							sexoMascota = "Hembra";
						}
						System.out.println("Sexo: " + sexoMascota);
						System.out.println("Alimentacion: " + gatos.getAlimentacion());
					} break;
				}else{
					System.out.println("Ingresa un numero valido");
				}
			}
		}
	}
}
