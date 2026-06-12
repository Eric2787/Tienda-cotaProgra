package Controlador;

import Almacenamiento.BD;
import Modelo.*;

import java.io.*;
import java.util.ArrayList;

public class ControladorBD{

	String nomArchPerro = "BDPerro.obj";
	File archPerro = new File(nomArchPerro);
	String nomArchGato = "BDGato.obj";
	File archGato = new File(nomArchGato);
	String nomArchPez  = "BDPez.obj";
	File archPez = new File(nomArchPez);
	String nomArchArania  = "BDArania.obj";
	File archArania = new File(nomArchArania);
	String nomArchSerpiente = "BDSerpiente.obj";
	File archSerpiente = new File(nomArchSerpiente);

	String nomVenPerro = "BDVenPerro.obj";
	File archVenPerro = new File(nomVenPerro);
	String nomVenGato = "BDVenGato.obj";
	File archVenGato = new File(nomVenGato);
	String nomVenPez =  "BDVenPez.obj";
	File archVenPez = new File(nomVenPez);
	String nomVenArania = "BDVenArania.obj";
	File archVenArania = new File(nomVenArania);
	String nomVenSerpiente = "BDVenSerpiente.obj";
	File archVenSerpiente = new File(nomVenSerpiente);

	public ControladorBD(){

	}

	public void respaldarBD() throws IOException {
		this.guardarStockPerros();
		this.guardarStockGatos();
		this.guardarStockPez();
		this.guardarStockArania();
		this.guardarStockSerpientes();
	}

	public void cargarBD() throws IOException, ClassNotFoundException {
		this.leerPerros();
		this.leerGatos();
		this.leerPezs();
		this.leerAranias();
		this.leerSerpientes();

	}

	public void respaldarVentas() throws IOException{
		this.guardarVenPerros();
		this.guardarVenGatos();
		this.guardarVenPezs();
		this.guardarVenAranias();
		this.guardarVenSerpientes();
	}

	public void cargarVentas() throws IOException, ClassNotFoundException {
		this.leerVenPerros();
		this.leerVenGatos();
		this.leerVenPezs();
		this.leerVenAranias();
		this.leerVenSerpientes();
	}

	/*
	* Aquí empiezan los métodos individuales para guardar cada uno de los animales
	 */

	public void guardarStockPerros() throws IOException {
		ArrayList<Perro> auxPerros = BD.getStockPerros();
		FileOutputStream flujoS = new FileOutputStream(archPerro);
		ObjectOutputStream escritor = new ObjectOutputStream(flujoS);

		if (auxPerros.size() > 0){
			for (int a = 0; a < auxPerros.size(); a++){
				try {
					escritor.writeObject(auxPerros.get(a));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				escritor.close();
				flujoS.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void guardarStockGatos() throws IOException{
		ArrayList<Gato> auxGatos = BD.getStockGatos();
		FileOutputStream flujoS = new FileOutputStream(archGato);
		ObjectOutputStream escritor = new ObjectOutputStream(flujoS);
		if (auxGatos.size() > 0){
			for (int a = 0; a < auxGatos.size(); a++){
				try {
					escritor.writeObject(auxGatos.get(a));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				escritor.close();
				flujoS.close();
			}  catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void guardarStockPez() throws IOException {
		ArrayList<Pez> auxPezs = BD.getStockPez();
		FileOutputStream flujoS = new FileOutputStream(archPez);
		ObjectOutputStream escritor = new ObjectOutputStream(flujoS);
		if (auxPezs.size() > 0){
			for (int a = 0; a < auxPezs.size(); a++){
				try {
					escritor.writeObject(auxPezs.get(a));
				}  catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				escritor.close();
				flujoS.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void guardarStockArania() throws IOException {
		ArrayList<Arania> auxAranias = BD.getStockAranias();
		FileOutputStream flujoS = new FileOutputStream(archArania);
		ObjectOutputStream escritor = new ObjectOutputStream(flujoS);
		if (auxAranias.size() > 0){
			for (int a = 0; a < auxAranias.size(); a++){
				try {
					escritor.writeObject(auxAranias.get(a));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				escritor.close();
				flujoS.close();
			}  catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void guardarStockSerpientes() throws IOException {
		ArrayList<Serpiente> auxSerpiente = BD.getStockSerp();
		FileOutputStream flujoS = new FileOutputStream(archSerpiente);
		ObjectOutputStream escritor = new ObjectOutputStream(flujoS);
		if (auxSerpiente.size() > 0){
			for (int a = 0; a < auxSerpiente.size(); a++){
				try {
					escritor.writeObject(auxSerpiente.get(a));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				escritor.close();
				flujoS.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void leerPerros() throws IOException, ClassNotFoundException{
		ArrayList<Perro> auxPerros = new ArrayList<>();
		if (archPerro.exists()){
			FileInputStream flujoE = new FileInputStream(archPerro);
			ObjectInputStream lector = new ObjectInputStream(flujoE);

			while (true){
				if(flujoE.available()>0){
					Perro perrito = (Perro) lector.readObject();
					auxPerros.add(perrito);
				}else{
					break;
				}
			}
			BD.setStockPerros(auxPerros);
			flujoE.close();
			lector.close();
		}
	}

	public void leerGatos() throws IOException, ClassNotFoundException{
		ArrayList<Gato> auxGatos = new ArrayList<>();
		if (archGato.exists()){
			FileInputStream flujoE = new FileInputStream(archGato);
			ObjectInputStream lector = new ObjectInputStream(flujoE);
			while (true){
				if(flujoE.available()>0){
					Gato gato = (Gato) lector.readObject();
					auxGatos.add(gato);
				}else {
					break;
				}
			}
			BD.setStockGatos(auxGatos);
			flujoE.close();
			lector.close();
		}
	}

	public void leerPezs() throws IOException, ClassNotFoundException{
		ArrayList<Pez> auxPezs = new ArrayList<>();
		if (archPez.exists()){
			FileInputStream flujoE = new FileInputStream(archPez);
			ObjectInputStream lector = new ObjectInputStream(flujoE);
			while (true){
				if(flujoE.available()>0){
					Pez pez = (Pez) lector.readObject();
					auxPezs.add(pez);
				}else {
					break;
				}
			}
			BD.setStockPez(auxPezs);
			flujoE.close();
			lector.close();
		}
	}

	public void leerAranias() throws IOException, ClassNotFoundException{
		ArrayList<Arania> auxAranias = new ArrayList<>();
		if (archArania.exists()){
			FileInputStream flujoE = new FileInputStream(archArania);
			ObjectInputStream lector = new ObjectInputStream(flujoE);
			while (true){
				if(flujoE.available()>0){
					Arania arania = (Arania) lector.readObject();
					auxAranias.add(arania);
				}else{
					break;
				}
			}
			BD.setStockAranias(auxAranias);
			flujoE.close();
			lector.close();
		}
	}

	public void leerSerpientes() throws IOException, ClassNotFoundException{
		ArrayList<Serpiente> auxSerpiente = new ArrayList<>();
		if (archSerpiente.exists()){
			FileInputStream flujoE = new FileInputStream(archSerpiente);
			ObjectInputStream lector = new ObjectInputStream(flujoE);
			while (true){
				if(flujoE.available()>0){
					Serpiente serpiente = (Serpiente) lector.readObject();
					auxSerpiente.add(serpiente);
				}else {
					break;
				}
			}
			BD.setStockSerp(auxSerpiente);
			flujoE.close();
			lector.close();
		}
	}

	public void guardarVenPerros()  throws IOException {
		ArrayList<Perro> auxPerros = BD.getVentaPerros();
		FileOutputStream flujoS = new FileOutputStream(archVenPerro);
		ObjectOutputStream escritor = new ObjectOutputStream(flujoS);

		if (auxPerros.size() > 0){
			for (int a = 0; a < auxPerros.size(); a++){
				try {
					escritor.writeObject(auxPerros.get(a));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				escritor.close();
				flujoS.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void guardarVenGatos()  throws IOException {
		ArrayList<Gato> auxGatos = BD.getVentaGatos();
		FileOutputStream flujoS = new FileOutputStream(archVenGato);
		ObjectOutputStream escritor = new ObjectOutputStream(flujoS);
		if (auxGatos.size() > 0){
			for (int a = 0; a < auxGatos.size(); a++){
				try {
					escritor.writeObject(auxGatos.get(a));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				escritor.close();
				flujoS.close();
			}  catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void guardarVenPezs() throws IOException {
		ArrayList<Pez> auxPezs = BD.getVentaPez();
		FileOutputStream flujoS = new FileOutputStream(archVenPez);
		ObjectOutputStream escritor = new ObjectOutputStream(flujoS);
		if (auxPezs.size() > 0){
			for (int a = 0; a < auxPezs.size(); a++){
				try {
					escritor.writeObject(auxPezs.get(a));
				}  catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				escritor.close();
				flujoS.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void guardarVenAranias() throws IOException {
		ArrayList<Arania> auxAranias = BD.getVentaAranias();
		FileOutputStream flujoS = new FileOutputStream(archVenArania);
		ObjectOutputStream escritor = new ObjectOutputStream(flujoS);
		if (auxAranias.size() > 0){
			for (int a = 0; a < auxAranias.size(); a++){
				try {
					escritor.writeObject(auxAranias.get(a));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				escritor.close();
				flujoS.close();
			}  catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void guardarVenSerpientes() throws IOException {
		ArrayList<Serpiente> auxSerpiente = BD.getVentaSerp();
		FileOutputStream flujoS = new FileOutputStream(archVenSerpiente);
		ObjectOutputStream escritor = new ObjectOutputStream(flujoS);
		if (auxSerpiente.size() > 0){
			for (int a = 0; a < auxSerpiente.size(); a++){
				try {
					escritor.writeObject(auxSerpiente.get(a));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				escritor.close();
				flujoS.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void leerVenPerros() throws IOException, ClassNotFoundException{
		ArrayList<Perro> auxPerros = new ArrayList<>();
		if (archPerro.exists()){
			FileInputStream flujoE = new FileInputStream(archVenPerro);
			ObjectInputStream lector = new ObjectInputStream(flujoE);

			while (true){
				if(flujoE.available()>0){
					Perro perrito = (Perro) lector.readObject();
					auxPerros.add(perrito);
				}else{
					break;
				}
			}
			BD.setVentaPerros(auxPerros);
			flujoE.close();
			lector.close();
		}
	}

	public void leerVenGatos() throws IOException, ClassNotFoundException{
		ArrayList<Gato> auxGatos = new ArrayList<>();
		if (archGato.exists()){
			FileInputStream flujoE = new FileInputStream(archVenGato);
			ObjectInputStream lector = new ObjectInputStream(flujoE);
			while (true){
				if(flujoE.available()>0){
					Gato gato = (Gato) lector.readObject();
					auxGatos.add(gato);
				}else {
					break;
				}
			}
			BD.setVentaGatos(auxGatos);
			flujoE.close();
			lector.close();
		}
	}

	public void leerVenPezs() throws IOException, ClassNotFoundException{
		ArrayList<Pez> auxPezs = new ArrayList<>();
		if (archPez.exists()){
			FileInputStream flujoE = new FileInputStream(archVenPez);
			ObjectInputStream lector = new ObjectInputStream(flujoE);
			while (true){
				if(flujoE.available()>0){
					Pez pez = (Pez) lector.readObject();
					auxPezs.add(pez);
				}else{
					break;
				}
			}
			BD.setVentaPez(auxPezs);
			flujoE.close();
			lector.close();
		}
	}

	public void leerVenAranias() throws IOException, ClassNotFoundException{
		ArrayList<Arania> auxAranias = new ArrayList<>();
		if (archArania.exists()){
			FileInputStream flujoE = new FileInputStream(archVenArania);
			ObjectInputStream lector = new ObjectInputStream(flujoE);
			while (true){
				if(flujoE.available()>0){
					Arania arania = (Arania) lector.readObject();
					auxAranias.add(arania);
				}else {
					break;
				}
			}
			BD.setVentaAranias(auxAranias);
			flujoE.close();
			lector.close();
		}
	}

	public void leerVenSerpientes() throws IOException, ClassNotFoundException{
		ArrayList<Serpiente> auxSerpientes = new ArrayList<>();
		if (archSerpiente.exists()){
			FileInputStream flujoE = new FileInputStream(archVenSerpiente);
			ObjectInputStream lector = new ObjectInputStream(flujoE);
			while (true){
				if(flujoE.available()>0){
					Serpiente serpiente = (Serpiente) lector.readObject();
					auxSerpientes.add(serpiente);
				}else{
					break;
				}
			}
			BD.setVentaSerp(auxSerpientes);
			flujoE.close();
			lector.close();
		}
	}
}

