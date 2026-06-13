package Controlador;

import Almacenamiento.BD;
import Modelo.Pez;
import java.util.ArrayList;

public class ControladorPez {

	public void registrarPez(String nombre, int edad, String color, String raza, float tamanio, float peso, float precio, boolean tipoAgua, boolean sexo, String tipoAlimentacion) {

		Pez pececito = new Pez();

		pececito.setNombre(nombre);
		pececito.setEdad(edad);
		pececito.setColor(color);
		pececito.setRaza(raza);
		pececito.setTamanio(tamanio);
		pececito.setPeso(peso);
		pececito.setPrecio(precio);
		pececito.setTipoAgua(tipoAgua);
		pececito.setSexo(sexo);
		pececito.setAlimentacion(tipoAlimentacion);

		ArrayList<Pez> auxPeces = BD.getStockPez();

		auxPeces.add(pececito);

		BD.setStockPez(auxPeces);

		System.out.println("Felicidades, tu pez se ha registrado.");
	}

	public ArrayList<Pez> consultarPez() {
		ArrayList<Pez> auxPeces = BD.getStockPez();
		return auxPeces;
	}

	public void eliminarPez(Pez pececito) {
		ArrayList<Pez> auxPeces = BD.getStockPez();

		auxPeces.remove(pececito);

		BD.setStockPez(auxPeces);
	}

	public void registrarVentaPez(Pez pececito) {
		ArrayList<Pez> auxPeces = BD.getVentaPez();

		auxPeces.add(pececito);

		BD.setVentaPez(auxPeces);
	}

	public void venderPez(Pez pececito) {
		ArrayList<Pez> auxPeces = BD.getStockPez();

		if (pececito.getPrecio() > 5000) {
			Float dto = (float) (pececito.getPrecio() * 0.90);

			for (int i = 0; i < auxPeces.size(); i++) {
				if (auxPeces.get(i).getNombre().equals(pececito.getNombre())) {
					auxPeces.get(i).setPrecio(dto);

					this.registrarVentaPez(pececito);
					this.eliminarPez(pececito);

					System.out.println("Precio final: " + pececito.getPrecio());
					System.out.println("Descuento: 10%");
					break;
				}
			}
		} else {
			this.registrarVentaPez(pececito);
			this.eliminarPez(pececito);

			System.out.println("Precio final: " + pececito.getPrecio());
			System.out.println("Felicidades, se ha vendido tu pez.");
		}
	}

	public ArrayList<Pez> consultarVentasPez() {
		ArrayList<Pez> auxPeces = BD.getVentaPez();

		return auxPeces;
	}
}