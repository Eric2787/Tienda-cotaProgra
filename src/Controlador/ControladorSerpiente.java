package Controlador;

import Almacenamiento.BD;
import Modelo.Serpiente;

import java.util.ArrayList;

public class ControladorSerpiente {
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

	public ArrayList<Serpiente> consultarSerpiente(){
		ArrayList<Serpiente> auxSerpiente = BD.getStockSerp();
		return auxSerpiente;
	}

	public void eliminarSerpiente(Serpiente serpiente) {
		ArrayList<Serpiente> auxSerpiente = BD.getStockSerp();
		auxSerpiente.remove(serpiente);
		BD.setStockSerp(auxSerpiente);
	}

	public void registrarVentaSerpiente(Serpiente serpiente){
		ArrayList<Serpiente> auxSerpiente = BD.getStockSerp();
		auxSerpiente.add(serpiente);
		BD.setVentaSerp(auxSerpiente);
	}

	public void venderSerpiente(Serpiente serpiente) {
		ArrayList<Serpiente> auxSerpiente = BD.getStockSerp();
		if(serpiente.getPrecio() > 5000){
			float dto = (float) (serpiente.getPrecio() * 0.90);
			for (int i = 0; i < auxSerpiente.size(); i++) {
				if (auxSerpiente.get(i).getPrecio() == serpiente.getPrecio()){
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

	public ArrayList<Serpiente> consultarVentaSerpiente(){
		ArrayList<Serpiente> auxSerpiente = BD.getVentaSerp();
		return auxSerpiente;
	}

}
