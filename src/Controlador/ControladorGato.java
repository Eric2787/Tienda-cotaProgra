package Controlador;

import Almacenamiento.BD;
import Modelo.Gato;

import java.util.ArrayList;

public class ControladorGato {
	public ControladorGato() {

	}

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

	public ArrayList<Gato> consultarGatos() {
		ArrayList<Gato> auxgatos = BD.getStockGatos();
		return auxgatos;
	}

	public void eliminarGatos(Gato gato) {
		ArrayList<Gato> auxgatos = BD.getStockGatos();
		auxgatos.remove(gato);
		BD.setStockGatos(auxgatos);
	}

	public void registrarVentaGatos(Gato gato) {
		ArrayList<Gato> auxgatos = BD.getVentaGatos();
		auxgatos.add(gato);
		BD.setVentaGatos(auxgatos);
	}

	public void venderGatos(Gato gato) {
		ArrayList<Gato> auxgatos = BD.getStockGatos();
		if (gato.getPrecio()> 5000){
			float descuento = (float) (gato.getPrecio() * 0.90);
			for (int i = 0; i < auxgatos.size(); i++) {
				if (auxgatos.get(i).getPrecio() == gato.getPrecio()) {
					auxgatos.get(i).setPrecio(descuento);
					this.registrarVentaGatos(gato);
					this.eliminarGatos(gato);
					break;
				}
			}
		}else {
			this.registrarVentaGatos(gato);
			this.venderGatos(gato);
		}
		System.out.println("Precio final: " + gato.getPrecio());
		System.out.println("Felicidades, se ha vendido con exito");
	}

	public ArrayList<Gato> consultarVentasGatos(){
		ArrayList<Gato> auxgatos = BD.getVentaGatos();
		return auxgatos;
	}
}

