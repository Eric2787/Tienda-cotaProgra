package Controlador;

import Almacenamiento.BD;
import Modelo.Arania;

import java.util.ArrayList;

public class ControladorArania {
	public ControladorArania() {

	}

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

		System.out.println("Perro registrado con exito");
	}

	/*
	 * Metodo para consultar los perros
	 */

	public ArrayList<Arania> consultarArania(){
		ArrayList<Arania> auxArania = BD.getStockAranias();
		return auxArania;
	}

	public void eliminarArania(Arania arania){
		ArrayList<Arania> auxArania = BD.getStockAranias();
		auxArania.remove(arania);
		BD.setStockAranias(auxArania);
	}

	public void registrarVentaArania(Arania arania){
		ArrayList<Arania> auxArania = BD.getVentaAranias();
		auxArania.add(arania);
		BD.setVentaAranias(auxArania);
	}

	public void venderArania(Arania arania){
		ArrayList<Arania> auxArania = BD.getStockAranias();
		if (arania.getPrecio() > 5000){
			Float dto = (float) (arania.getPrecio() * 0.90);
			for (int i = 0; i < auxArania.size(); i++) {
				if (auxArania.get(i).getPrecio() == arania.getPrecio()){
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

	public ArrayList<Arania> consultarVentasPerro(){
		ArrayList<Arania> auxArania = BD.getVentaAranias();
		return auxArania;
	}

}
