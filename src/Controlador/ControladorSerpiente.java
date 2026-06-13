package Controlador;

import Almacenamiento.BD;
import Modelo.Serpiente;

import java.util.ArrayList;

/**
 * Controlador para la gestión de las operaciones relacionadas con las serpientes.
 */
public class ControladorSerpiente {

	/**
	 * Registra una nueva serpiente en el stock.
	 *
	 * @param nombre Nombre de la serpiente.
	 * @param edad Edad de la serpiente.
	 * @param color Color de la serpiente.
	 * @param raza Raza de la serpiente.
	 * @param tamanio Tamaño de la serpiente.
	 * @param peso Peso de la serpiente.
	 * @param precio Precio de la serpiente.
	 * @param sexo Sexo de la serpiente.
	 * @param alimentacion Alimentación de la serpiente.
	 * @param paisOrigen País de origen de la serpiente.
	 */
	public void registrarSerpiente(String nombre, int edad, String color, String raza, float tamanio, float peso, float precio, boolean sexo, String alimentacion, String paisOrigen){
		Serpiente serpiente = new Serpiente();
		serpiente.setNombre(nombre);
		serpiente.setEdad(edad);
		serpiente.setColor(color);
		serpiente.setRaza(raza);
		serpiente.setTamanio(tamanio);
		serpiente.setPeso(peso);
		serpiente.setPrecio(precio);
		serpiente.setSexo(sexo);
		serpiente.setAlimentacion(alimentacion);
		serpiente.setPaisOrigen(paisOrigen);

		ArrayList<Serpiente> auxSerpiente = BD.getStockSerp();
		auxSerpiente.add(serpiente);
		BD.setStockSerp(auxSerpiente);
		System.out.println("Serpiente registrado con exito");
	}

	/**
	 * Consulta la lista de serpientes disponibles en stock.
	 *
	 * @return Lista de serpientes en stock.
	 */
	public ArrayList<Serpiente> consultarSerpiente(){
		ArrayList<Serpiente> auxSerpiente = BD.getStockSerp();
		return auxSerpiente;
	}

	/**
	 * Elimina una serpiente del stock.
	 *
	 * @param serpiente Serpiente a eliminar.
	 */
	public void eliminarSerpiente(Serpiente serpiente) {
		ArrayList<Serpiente> auxSerpiente = BD.getStockSerp();
		auxSerpiente.remove(serpiente);
		BD.setStockSerp(auxSerpiente);
	}

	/**
	 * Registra la venta de una serpiente.
	 *
	 * @param serpiente Serpiente vendida.
	 */
	public void registrarVentaSerpiente(Serpiente serpiente){
		ArrayList<Serpiente> auxSerpiente = BD.getStockSerp();
		auxSerpiente.add(serpiente);
		BD.setVentaSerp(auxSerpiente);
	}

	/**
	 * Realiza el proceso de venta de una serpiente, aplicando descuentos si corresponde.
	 *
	 * @param serpiente Serpiente a vender.
	 */
	public void venderSerpiente(Serpiente serpiente) {
		ArrayList<Serpiente> auxSerpiente = BD.getStockSerp();
		if(serpiente.getPrecio() > 5000){
			float dto = (float) (serpiente.getPrecio() * 0.90);
			for (int i = 0; i < auxSerpiente.size(); i++) {
				if (auxSerpiente.get(i).getNombre().equals(serpiente.getNombre())){
					auxSerpiente.get(i).setPrecio(dto);
					this.registrarVentaSerpiente(serpiente);
					this.eliminarSerpiente(serpiente);
					break;
				}
			}
		}else{
			this.registrarVentaSerpiente(serpiente);
			this.eliminarSerpiente(serpiente);
		}
		System.out.println("Precio final: " + serpiente.getPrecio());
		System.out.println("Felicidades, se ha vendido con exito");
	}

	/**
	 * Consulta la lista de serpientes vendidas.
	 *
	 * @return Lista de serpientes vendidas.
	 */
	public ArrayList<Serpiente> consultarVentaSerpiente(){
		ArrayList<Serpiente> auxSerpiente = BD.getVentaSerp();
		return auxSerpiente;
	}

}
