package Controlador;

import Almacenamiento.BD;
import Modelo.Gato;

import java.util.ArrayList;

/**
 * Controlador para la gestión de las operaciones relacionadas con los gatos.
 */
public class ControladorGato {
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
}
