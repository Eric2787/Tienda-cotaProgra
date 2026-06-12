package Controlador;

import Almacenamiento.BD;
import Modelo.Perro;

import java.util.ArrayList;

public class ControladorPerro {
	public ControladorPerro() {

	}
	/*
	* Metodo de insertar un "perrito" a una lista dinamica de la clase Perro
	* @param nombre: El el nombre definido por el usuario
	* @param edad: Es la edad definida por el usuario
	* @param color: Es el color definido por el usuario
	* @param raza: Es la raza definida por el usuario
	* @param tamanio: Es el tamaño definido por el usuario
	* @param peso: Es el tamaño definido por el usuario
	* @param precio: Es el precio definido por el usuario
	* @param perfil: Es el perfil defindo por el usuario
	* @param sexo: Es el sexo definido por el usuario
	* @param alimentacion: Es la alimentacion definida por el usuario
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

	/*
	* Metodo para consultar los perros
	 */

	public ArrayList<Perro> consultarPerros(){
		ArrayList<Perro> auxPerros = BD.getStockPerros();
		return auxPerros;
	}

	public void eliminarPerro(Perro perro){
		ArrayList<Perro> auxPerros = BD.getStockPerros();
		auxPerros.remove(perro);
		BD.setStockPerros(auxPerros);
	}

	public void registrarVentaPerro(Perro perro){
		ArrayList<Perro> auxPerros = BD.getVentaPerros();
		auxPerros.add(perro);
		BD.setVentaPerros(auxPerros);
	}

	public void venderPerro(Perro perro){
		ArrayList<Perro> auxPerros = BD.getStockPerros();
		if (perro.getPrecio() > 5000){
			Float dto = (float) (perro.getPrecio() * 0.90);
			for (int i = 0; i < auxPerros.size(); i++) {
				if (auxPerros.get(i).getPrecio() == perro.getPrecio()){
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

	public ArrayList<Perro> consultarVentasPerro(){
		ArrayList<Perro> auxPerros = BD.getVentaPerros();
		return auxPerros;
	}

}
