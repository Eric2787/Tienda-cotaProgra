package Controlador;

import Almacenamiento.BD;
import Modelo.Arania;

import java.util.ArrayList;

/**
 * Controlador para la gestión de las operaciones relacionadas con las arañas.
 */
public class ControladorArania {
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

}
