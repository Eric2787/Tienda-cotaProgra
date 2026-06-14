package Controlador;

import Almacenamiento.BD;
import Modelo.Perro;

import java.util.ArrayList;

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
	 * Realiza el proceso de venta de un perro, aplicando descuentos si corresponde.
	 *
	 * @param perro Perro a vender.
	 */
	public void venderPerro(Perro perro){
		ArrayList<Perro> auxPerros = BD.getStockPerros();
		if (perro.getPrecio() > 5000){
			Float dto = (float) (perro.getPrecio() * 0.90);
			for (int i = 0; i < auxPerros.size(); i++) {
				if (auxPerros.get(i).getNombre().equals(perro.getNombre())){
					auxPerros.get(i).setPrecio(dto);
					this.registrarVentaPerro(perro);
					this.eliminarPerro(perro);
					System.out.println("Precio final: " + perro.getPrecio());
					System.out.println("Descuento: 10%");
					break;
				}
			}
		}else {
			this.registrarVentaPerro(perro);
			this.eliminarPerro(perro);
			System.out.println("Precio final: " + perro.getPrecio());
			System.out.println("Felicidades, se ha vendido con exito");
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

	@Override
	public void Saludar(int perfil) {
		switch (perfil){
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
		}
	}

	@Override
	public void Saludar() {
	}
}
